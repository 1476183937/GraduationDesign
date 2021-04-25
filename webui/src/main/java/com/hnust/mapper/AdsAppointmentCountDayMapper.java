package com.hnust.mapper;

import com.hnust.entity.AdsAppointmentCountDay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


/**
 * 每日预约数
 */
public interface AdsAppointmentCountDayMapper {

    @Select("SELECT * FROM ads_appointment_count_day;")
    ArrayList<AdsAppointmentCountDay> queryAll();

    //根据日期获取最近几天的预约数
    @Select("SELECT * FROM ads_appointment_count_day WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsAppointmentCountDay> queryByDt(@Param("dt")String dt,@Param("size")int size);

}