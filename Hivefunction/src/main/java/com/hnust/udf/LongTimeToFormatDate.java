package com.hnust.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LongTimeToFormatDate extends UDF {

    /**
     * 将时间戳转换成指定格式
     * @param longTime：时间戳
     * @param format：日期格式
     * @return
     */
    public String evaluate(String longTime,String format){

        Date date = new Date(Long.valueOf(longTime));

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String formatDate = dateFormat.format(date);

        return formatDate;
    }

    public static void main(String[] args) {
        String date = new LongTimeToFormatDate().evaluate("1586102400000", "yyyy-MM-dd");
        long time = System.currentTimeMillis();
//        System.out.println(time);
        String date1 = new LongTimeToFormatDate().evaluate(time+"", "yyyy-MM-dd HH:mm:ss");
        System.out.println(time);
        System.out.println(date1);
        System.out.println(date);
    }

}
