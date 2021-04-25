package com.hnust.mapper;

import com.hnust.entity.AdsUrlCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 页面浏览次数统计
 */
public interface AdsUrlCountMapper {

    @Select("SELECT * FROM ads_url_count;")
    ArrayList<AdsUrlCount> queryAll();

    //获取指定日期 dt 中浏览次数最多的几条url
    @Select("SELECT * FROM ads_url_count WHERE dt=#{dt} ORDER BY url_count DESC LIMIT #{size};")
    ArrayList<AdsUrlCount> queryByDt(@Param("dt")String dt,@Param("size")int size);

}
