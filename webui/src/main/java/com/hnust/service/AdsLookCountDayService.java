package com.hnust.service;

import com.hnust.entity.AdsLookCountDay;

import java.util.ArrayList;

public interface AdsLookCountDayService {

    ArrayList<AdsLookCountDay> queryAll();

    //根据日期获取最近几天的成交数
    ArrayList<AdsLookCountDay> getByDt(String dt, int size);

}
