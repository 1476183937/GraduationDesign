package com.hnust.mapper;

import com.hnust.entity.AdsContinuityWkCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 最近3周连续活跃用户数统计
 */
public interface AdsContinuityWkCountMapper {

    @Select("SELECT * FROM ads_continuity_wk_count;")
    ArrayList<AdsContinuityWkCount> queryAll();

    //获取指定日期 dt 后的数据,按 coutinuity_count 排序
    @Select("SELECT * FROM ads_continuity_wk_count WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsContinuityWkCount> queryByDt(@Param("dt") String dt,@Param("size") int size);

    //获取最新的几条数据
    @Select("SELECT * FROM ads_continuity_wk_count ORDER BY dt DESC LIMIT #{size};")
    ArrayList<AdsContinuityWkCount> queryLatest(@Param("size") int size);

}
