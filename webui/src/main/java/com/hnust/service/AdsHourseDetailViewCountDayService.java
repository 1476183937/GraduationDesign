package com.hnust.service;

import com.hnust.entity.AdsHourseDetailViewCountDay;

import java.util.ArrayList;

public interface AdsHourseDetailViewCountDayService {

    ArrayList<AdsHourseDetailViewCountDay> queryAll();

    //根据日期 dt 获取近几天详情页浏览次数
    ArrayList<AdsHourseDetailViewCountDay> getByDt(String dt,int size);

}
