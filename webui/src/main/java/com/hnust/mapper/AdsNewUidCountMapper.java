package com.hnust.mapper;

import com.hnust.entity.AdsNewUidCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 每日新增用户数表
 */
public interface AdsNewUidCountMapper {

    @Select("SELECT * FROM ads_new_uid_count;")
    ArrayList<AdsNewUidCount> queryAll();

    //获取指定日期 dt 后的新增用户数的数据
    @Select("SELECT * FROM ads_new_uid_count WHERE create_date>=#{dt} LIMIT #{size};")
    ArrayList<AdsNewUidCount> queryByDt(@Param("dt") String dt, @Param("size") int size);

}
