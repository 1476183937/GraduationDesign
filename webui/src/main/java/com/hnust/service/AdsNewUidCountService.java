package com.hnust.service;

import com.hnust.entity.AdsNewUidCount;

import java.util.ArrayList;

public interface AdsNewUidCountService {

    ArrayList<AdsNewUidCount> queryAll();

    //获取指定日期后的新增用户数的数据
    ArrayList<AdsNewUidCount> getByDt(String dt,int size);

}
