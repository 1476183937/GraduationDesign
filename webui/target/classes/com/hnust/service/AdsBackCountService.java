package com.hnust.service;

import com.hnust.entity.AdsBackCount;

import java.util.ArrayList;

public interface AdsBackCountService {

    ArrayList<AdsBackCount> queryAll();

    //根据日期获取周回流用户数
    ArrayList<AdsBackCount> getByDt(String dt,int size);

}
