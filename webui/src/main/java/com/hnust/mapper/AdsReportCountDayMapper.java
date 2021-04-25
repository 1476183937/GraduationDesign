package com.hnust.mapper;

import com.hnust.entity.AdsReportCountDay;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
public interface AdsReportCountDayMapper {

    @Select("SELECT * FROM ads_repport_count_day;")
    ArrayList<AdsReportCountDay> queryAll();

}
