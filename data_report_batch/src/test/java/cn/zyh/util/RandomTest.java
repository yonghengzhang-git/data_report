package cn.zyh.util;

import com.jrx.zyh.model.TransactionInfo;
import com.jrx.zyh.util.RandomDataUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/6/2 14:14
 * @describe
 */
public class RandomTest {

    @Test
    public void test01(){
        List<TransactionInfo> transactionInfos = RandomDataUtil.randomTranInfoRange("2021-1-1", "2021-1-10");
        System.out.println(transactionInfos);
    }

}
