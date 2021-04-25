package com.hnust.service;

import com.hnust.entity.AdsContinuityUvCount;

import java.util.ArrayList;

public interface AdsContinuityUvCountService {

    ArrayList<AdsContinuityUvCount> queryAll();

    //获取指定日期 dt 后的数据
    ArrayList<AdsContinuityUvCount> getByDt(String dt,int size);
}
