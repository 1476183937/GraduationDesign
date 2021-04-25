package com.hnust.service;

import com.hnust.entity.AdsHourseListViewCountDay;

import java.util.ArrayList;

public interface AdsHourseListViewCountDayService {

    ArrayList<AdsHourseListViewCountDay> queryAll();

    //根据日期 dt 获取列表页浏览次数
    ArrayList<AdsHourseListViewCountDay> getByDt(String dt,int size);

}
