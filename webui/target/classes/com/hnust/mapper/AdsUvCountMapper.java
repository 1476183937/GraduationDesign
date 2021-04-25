package com.hnust.mapper;

import com.hnust.entity.AdsUvCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 用户活跃情况统计
 */
public interface AdsUvCountMapper {

    @Select("SELECT * FROM ads_uv_count;")
    ArrayList<AdsUvCount> queryAll();

    //查询日期 dt 后几天内的数据,如查询最近7天的日活跃数
    @Select("SELECT * FROM ads_uv_count WHERE dt>=#{dt} ORDER BY dt LIMIT #{size}")
    ArrayList<AdsUvCount> queryByDay(@Param("dt") String dt,@Param("size")int size);

    //查询指定日期 dt 后几周内的数据，按周次查询,如查询最近5周的周活跃用户数
    @Select("SELECT * FROM ads_uv_count WHERE is_weekend='Y' AND dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsUvCount> queryByWk(@Param("dt") String dt,@Param("size") int size);

    //查询指定日期 dt 后几月内的数据，按月份查，如查询最近5月的月活跃用户数
    @Select("SELECT * FROM ads_uv_count WHERE is_monthend='Y' AND dt>=#{mn} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsUvCount> queryByMn(@Param("mn") String mn,@Param("size") int size);

    //获取最近一天的数据，即数据库中 dt 最大的数据
    @Select("SELECT * FROM ads_uv_count ORDER BY dt DESC LIMIT 1;")
    ArrayList<AdsUvCount> queryLatest();

}
