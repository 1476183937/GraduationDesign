package com.hnust.mapper;

import com.hnust.entity.AdsHourseDetailViewCountDay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 详情页浏览次数
 */
public interface AdsHourseDetailViewCountDayMapper {

    @Select("SELECT * FROM ads_hourse_detail_view_count_day;")
    ArrayList<AdsHourseDetailViewCountDay> queryAll();

    //根据日期 dt 获取近几天详情页浏览次数
    @Select("SELECT * FROM ads_hourse_detail_view_count_day WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsHourseDetailViewCountDay> queryByDt(@Param("dt") String dt,@Param("size")int size);

}
