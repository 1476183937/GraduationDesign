package com.hnust.mapper;

import com.hnust.entity.AdsUserPortrait;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
public interface AdsUserPortraitMapper {

    @Select("SELECT * FROM ads_user_portrait;")
    ArrayList<AdsUserPortrait> queryAll();

}
