package com.hnust.mapper;

import com.hnust.entity.AdsWastageCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 每日流失用户数
 */
public interface AdsWastageCountMapper {

    @Select("SELECT * FROM ads_wastage_count;")
    ArrayList<AdsWastageCount> queryAll();

    //获取指定日期 dt 的流失用户数的数据
    @Select("SELECT * FROM ads_wastage_count WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsWastageCount> queryByDt(@Param("dt")String dt,@Param("size")int size);

}
