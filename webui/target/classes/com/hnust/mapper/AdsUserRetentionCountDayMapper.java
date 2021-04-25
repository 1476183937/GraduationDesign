package com.hnust.mapper;

import com.hnust.entity.AdsUserRetentionCountDay;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
public interface AdsUserRetentionCountDayMapper {

    @Select("SELECT * FROM ads_user_retention_count_day;")
    ArrayList<AdsUserRetentionCountDay> queryAll();

}
