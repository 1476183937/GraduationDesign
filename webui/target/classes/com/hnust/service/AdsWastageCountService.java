package com.hnust.service;

import com.hnust.entity.AdsWastageCount;

import java.util.ArrayList;

public interface AdsWastageCountService {

    ArrayList<AdsWastageCount> queryAll();

    //根据日期获取流失用户数的数据
    ArrayList<AdsWastageCount> getByDt(String dt,int size);

}
