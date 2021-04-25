package com.hnust.mapper;

import com.hnust.entity.AdsPageViewCount;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
public interface AdsPageViewCountMapper {

    @Select("SELECT * FROM ads_page_view_count;")
    ArrayList<AdsPageViewCount> queryAll();

}
