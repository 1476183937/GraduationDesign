package com.hnust.mapper;

import com.hnust.entity.AdsLookCountDay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 每日带看数
 */
public interface AdsLookCountDayMapper {

    @Select("SELECT * FROM ads_look_count_day;")
    ArrayList<AdsLookCountDay> queryAll();

    //根据日期获取最近几天的带看数
    @Select("SELECT * FROM ads_look_count_day WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsLookCountDay> queryByDt(@Param("dt")String dt,@Param("size")int size);

}
