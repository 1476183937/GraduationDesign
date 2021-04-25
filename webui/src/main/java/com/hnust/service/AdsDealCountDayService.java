package com.hnust.service;

import com.hnust.entity.AdsDealCountDay;

import java.util.ArrayList;

public interface AdsDealCountDayService {

    ArrayList<AdsDealCountDay> queryAll();

    //根据日期获取最近几天的成交数
    ArrayList<AdsDealCountDay> getByDt(String dt,int size);

}
