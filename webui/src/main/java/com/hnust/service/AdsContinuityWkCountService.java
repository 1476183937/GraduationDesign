package com.hnust.service;

import com.hnust.entity.AdsContinuityWkCount;

import java.util.ArrayList;

public interface AdsContinuityWkCountService {

    ArrayList<AdsContinuityWkCount> queryAll();

    //获取指定日期 dt 后的数据
    ArrayList<AdsContinuityWkCount> getByDt(String dt,int size);

    //获取最新的几条数据
    ArrayList<AdsContinuityWkCount> getLatest(int size);

}
