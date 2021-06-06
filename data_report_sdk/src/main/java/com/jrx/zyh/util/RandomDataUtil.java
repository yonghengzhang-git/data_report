package com.jrx.zyh.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import com.jrx.zyh.model.Customer;
import com.jrx.zyh.model.TransactionInfo;
import utils.RandomPersonInfoUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/6/1 17:36
 * @describe
 */
public class RandomDataUtil {

    private static String[] eduArr = {"文盲", "小学", "初中", "高中", "本科", "研究生"};
    private static String[] marArr = {"未婚", "初婚", "再婚", "复婚", "离婚", "丧偶"};
    private static String[] traArr = {"消费", "还款"};
    private static String baseStr = "山岳巍峨湖泊荡漾植被旷野岛撒汪洋冰川冻土沙漠沃壤木丰树森岩多滩广鸟飞兽走鳞潜羽翔境态和谐物种安详形分上下道合阴阳幽冥杳渺天体著彰凝气为精聚能以场缩浓而质积微显量化巨幻虚恍惚成象强固凌弱柔亦制刚终极必反存兴趋亡色空轮回动静恒常唯实众名一理万方父母爹娘没齿难忘兄弟姐妹危困助帮姑姨叔舅亲戚互访侄男闺少哺育茁壮夫妻相敬梦忆糟糠隔屋邻舍遇事谦谅伯公妪婆慈孝赡养";
    private static SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
    private static Snowflake snowflake = new Snowflake(1, 1);

    //随机生成客户对象属性

    /**
     * 随机生成中文名
     *
     * @return
     */
    public static String randomName() {
        return RandomPersonInfoUtil.getRandomChineseName();
    }

    /**
     * 随机生成学历信息
     *
     * @return
     */
    public static String randomEdu() {
        return RandomUtil.randomEle(eduArr);
    }

    /**
     * 随机生成0,1  byte
     *
     * @return
     */
    public static Byte randomByte() {
        return (byte) RandomUtil.randomInt(2);
    }

    /**
     * 随机生成婚姻情况
     *
     * @return
     */
    public static String randomMar() {
        return RandomUtil.randomEle(marArr);
    }

    /**
     * 随机生成生日MMdd
     *
     * @return
     */
    public static Integer randomBirthday() {
        return Integer.parseInt(sdf.format(RandomUtil.randomDay(-365, 0).toJdkDate()));
    }

    /**
     * 随机生成地址
     *
     * @return
     */
    public static String randomAddress() {
        return RandomUtil.randomString(baseStr, 6);
    }

    //存储随机生成的客户对象
    public static List<Customer> customerList;

    /**
     * 生成没有id的Customer集合
     */
    static {
        ArrayList<Customer> list = new ArrayList<>();
        for (int i = 1; i < 120; i++) {

            Customer customer = new Customer(
                    null,
                    randomName(),
                    randomByte(),
                    randomEdu(),
                    randomMar(),
                    randomBirthday(),
                    randomAddress()
            );

            DateTime now = DateTime.now();

            list.add(customer);

        }

        customerList = list;

    }

    //随机生成交易对象属性

    /**
     * 随机生成客户id
     */
    public static Integer randomCustId() {
        return RandomUtil.randomInt(2, 119);
    }

    /**
     * 随机账户号
     */
    public static String randomAccount() {
        return RandomUtil.randomNumbers(10);
    }

    /**
     * 随机卡号
     */
    public static String randomCardNo() {
        return RandomUtil.randomNumbers(16);
    }

    /**
     * 交易流水号(雪花算法)
     */
    public static Long randomTranNo() {
        return snowflake.nextId();
    }

    /**
     * 交易金额
     */
    public static BigDecimal randomBill() {
        return new BigDecimal(RandomUtil.randomDouble(1000, 100000)).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * 交易类型
     */
    public static String randomTranType() {
        return RandomUtil.randomEle(traArr);
    }

    public static List<TransactionInfo> randomTranInfoRange(String start, String end) {

        List<TransactionInfo> transactionInfos = new ArrayList<>();

        LocalDate s = DateUtil.parseLocalDate(start);
        LocalDate e = DateUtil.parseLocalDate(end);

        while (s.isBefore(e)) {

            List<TransactionInfo> infoList = randomTranInfo(s);
            transactionInfos.addAll(infoList);

            s = s.minusDays(-1);
        }
        return transactionInfos;
    }

    /**
     * 根据字符串yyyy-MM-dd生成当日交易信息集合
     *
     * @param date
     * @return
     */
    public static List<TransactionInfo> randomTranInfo(String date) {
        return randomTranInfo(DateUtil.parseLocalDate(date));
    }

    /**
     * 根据LocalDate生成交易信息集合
     *
     * @param date
     * @return
     */
    public static List<TransactionInfo> randomTranInfo(LocalDate date) {

        int month = date.getMonthValue();
        Date d = DateUtil.toDate(date);

        ArrayList<TransactionInfo> list = new ArrayList<>();
        for (int i = 0; i < 220; i++) {
            TransactionInfo info = new TransactionInfo(
                    null,
                    randomCustId(),
                    randomAccount(),
                    randomCardNo(),
                    randomTranNo(),
                    month+1,
                    randomBill(),
                    randomTranType(),
                    d
            );
            list.add(info);
        }

        return list;
    }

    public void test(){

    }

}
