package com.hnust.service;

import com.hnust.entity.AdsUrlCount;

import java.util.ArrayList;

public interface AdsUrlCountService {

    ArrayList<AdsUrlCount> queryAll();

    //获取指定日期 dt 中浏览次数最多的几条url
    ArrayList<AdsUrlCount> getByDt(String dt,int size);

}
