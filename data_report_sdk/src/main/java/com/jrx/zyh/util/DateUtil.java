package com.jrx.zyh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Java实习-张永恒
 * @date 2021/6/2 11:49
 * @describe
 */
public abstract class DateUtil {

    /**
     * Date转LocalDate
     * @param date
     * @return
     */
    public static LocalDate toLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * LocalDate转Date
     * @param localDate
     * @return
     */
    public static Date toDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 字符串转LocalDate
     * @param str
     * @return
     */
    public static LocalDate parseLocalDate(String str){
        String[] strArr = str.split("-");
        List<Integer> yMd = Arrays.asList(strArr).stream().map(Integer::parseInt).collect(Collectors.toList());
        return LocalDate.of(yMd.get(0), yMd.get(1), yMd.get(2));
    }

    public static Date parseDate(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str);
    }

    /*public void dateForeach(LocalDate s, LocalDate e){
        while(s.isBefore(e)){

            function();

            s=s.minusDays(-1);

        }
    }

    public abstract void function();
*/
}
