package com.hnust.utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {


    //获取当前日期
    public static String getNow(String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String now = dateFormat.format(date);

        return now;
    }

    //将格式化的日期 date(yyyy-MM-dd) 加 num 天,num 可以为负数
    public static String dateAdd(String date,int num){
        String[] dateSplit = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(dateSplit[0]), Integer.valueOf(dateSplit[1]), Integer.valueOf(dateSplit[2]));

        LocalDate addDate = localDate.plusDays(num);

        return addDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 将日期 dt 加 num 个月
     * @param date
     * @param num
     * @return
     */
    public static String monthAdd(String date,int num){
        String[] dateSplit = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(dateSplit[0]), Integer.valueOf(dateSplit[1]), Integer.valueOf(dateSplit[2]));

        LocalDate preMonthDate = localDate.plusMonths(num);
        String preTime = preMonthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return preTime;
    }

    /**
     * 判断指定日期是否是星期天
     * @param date
     * @return
     */
    public static boolean isWeekEnd(String date){
        String[] dateSplit = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(dateSplit[0]), Integer.valueOf(dateSplit[1]), Integer.valueOf(dateSplit[2]));

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int value = dayOfWeek.getValue();
        if (value == 7){
            return true;
        }

        return false;
    }

    /**
     * 判断指定日期是否是一个月的最后一天
     * @param date
     * @return
     */
    public static boolean isMonthEnd(String date){

        String[] dateSplit = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(dateSplit[0]), Integer.valueOf(dateSplit[1]), Integer.valueOf(dateSplit[2]));

        if (localDate.getDayOfMonth() == localDate.lengthOfMonth()){
            return true;
        }

        return false;
    }

    /**
     * 获取指定日期 dt 所在周中周一的日期
     * @param date
     * @return
     */
    public static String getMonday(String date){
        String[] dateSplit = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(dateSplit[0]), Integer.valueOf(dateSplit[1]), Integer.valueOf(dateSplit[2]));

        int dayOfWeek = localDate.getDayOfWeek().getValue();

        LocalDate mondayDate = localDate.plusDays(1-dayOfWeek);
        String monday = mondayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return monday;
    }

    /**
     * 获取指定日期 dt 所在周中周日的日期
     * @param date
     * @return
     */
    public static String getSumday(String date){
        String[] dateSplit = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(dateSplit[0]), Integer.valueOf(dateSplit[1]), Integer.valueOf(dateSplit[2]));

        int dayOfWeek = localDate.getDayOfWeek().getValue();


        LocalDate mondayDate = localDate.plusDays(7-dayOfWeek);
        String monday = mondayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return monday;
    }




    public static void main(String[] args) {
        System.out.println(monthAdd("2021-04-05",1));
        System.out.println(monthAdd("2021-04-05",-1));
        System.out.println(monthAdd("2021-04-05",-2));

    }


}
