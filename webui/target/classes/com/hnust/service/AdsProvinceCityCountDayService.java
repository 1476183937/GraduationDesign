package com.hnust.service;

import com.hnust.entity.AdsProvinceCityCountDay;

import java.util.ArrayList;

public interface AdsProvinceCityCountDayService {

    ArrayList<AdsProvinceCityCountDay> queryAll();

    //根据日期查询当日的省市活跃数据
    ArrayList<AdsProvinceCityCountDay> getByDt(String dt);

    //根据日期和省份查询当日的省市活跃数据
    ArrayList<AdsProvinceCityCountDay> getByProvinceAndDt(String province,String dt);

}
