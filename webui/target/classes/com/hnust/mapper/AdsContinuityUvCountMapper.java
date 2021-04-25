package com.hnust.mapper;

import com.hnust.entity.AdsContinuityUvCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 最近7天连续3天活跃用户数统计
 */
public interface AdsContinuityUvCountMapper {


    @Select("SELECT * FROM ads_continuity_uv_count;")
    ArrayList<AdsContinuityUvCount> queryAll();

    //获取指定日期 dt 后的数据，按 continuity_count 排序
    @Select("SELECT * FROM ads_continuity_uv_count WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsContinuityUvCount> queryByDt(@Param("dt") String dt,@Param("size") int size);

}

