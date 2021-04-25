package com.hnust.mapper;

import com.hnust.entity.AdsSlientCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 每日沉默用户数
 */
public interface AdsSlientCountMapper {

    @Select("SELECT * FROM ads_slient_count;")
    ArrayList<AdsSlientCount> queryAll();

    //根据日期获取数据
    @Select("SELECT * FROM ads_slient_count WHERE dt>=#{dt} ORDER BY dt LIMIT #{size};")
    ArrayList<AdsSlientCount> queryByDt(@Param("dt") String dt,@Param("size") int size);

}
