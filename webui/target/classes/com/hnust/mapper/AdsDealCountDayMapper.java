package com.hnust.mapper;

import com.hnust.entity.AdsDealCountDay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 每日成交数
 */
public interface AdsDealCountDayMapper {

    @Select("SELECT * FROM ads_deal_count_day;")
    ArrayList<AdsDealCountDay> queryAll();

    //根据日期获取最近几天的成交数
    @Select("SELECT * FROM ads_deal_count_day WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsDealCountDay> queryByDt(@Param("dt")String dt,@Param("size")int size);

}
