package com.hnust.mapper;

import com.hnust.entity.AdsHourseListViewCountDay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 列表页浏览次数
 */
public interface AdsHourseListViewCountDayMapper {

    @Select("SELECT * FROM ads_hourse_list_view_count_day;")
    ArrayList<AdsHourseListViewCountDay> queryAll();

    //根据日期 dt 获取列表页浏览次数
    @Select("SELECT * FROM ads_hourse_list_view_count_day WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsHourseListViewCountDay> queryByDt(@Param("dt")String dt,@Param("size")int size);
}
