package com.hnust.mapper;

import com.hnust.entity.AdsBackCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 回流用户数
 */
public interface AdsBackCountMapper {

    @Select("SELECT * FROM ads_back_count;")
    ArrayList<AdsBackCount> queryAll();

    //根据日期 dt 获取 dt 后 size 周的回流用户数数据
    @Select("SELECT bc.* FROM ads_back_count bc JOIN " +
            "(" +
            "  SELECT MAX(dt) dt FROM ads_back_count WHERE dt>=#{dt} GROUP BY wk_dt LIMIT #{size}" +
            ")t1 ON bc.dt = t1.dt;")
    ArrayList<AdsBackCount> queryByDt(@Param("dt")String dt,@Param("size")int size);

}
