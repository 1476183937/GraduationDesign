package com.hnust.mapper;

import com.hnust.entity.AdsProvinceCityCountDay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 省市活跃数
 */
public interface AdsProvinceCityCountDayMapper {

    @Select("SELECT * FROM ads_province_city_count_day;")
    ArrayList<AdsProvinceCityCountDay> queryAll();


    //根据日期查询当日的省市活跃数据
    @Select("SELECT * FROM ads_province_city_count_day WHERE dt=#{dt}")
    ArrayList<AdsProvinceCityCountDay> queryByDt(@Param("dt")String dt);

    //根据日期和省份查询当日的省市活跃数据
    @Select("SELECT * FROM ads_province_city_count_day WHERE dt=#{dt} AND province_name=#{province}")
    ArrayList<AdsProvinceCityCountDay> queryByProvinceAndDt(@Param("province")String privince,@Param("dt")String dt);

}
