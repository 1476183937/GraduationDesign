package com.hnust.mapper;

import com.hnust.entity.AdsAvgVisitTime;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

//
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
public interface AdsAvgVisitTimeMapper {

    @Select("SELECT * FROM ads_avg_visit_time;")
    ArrayList<AdsAvgVisitTime> queryAll();

}
