package com.hnust.service;

import com.hnust.entity.AdsUserRetentionDayRate;

import java.util.ArrayList;

public interface AdsUserRetentionDayRateService {

    ArrayList<AdsUserRetentionDayRate> queryAll();

    //获取指定日期 dt 和留存天数的数据
    ArrayList<AdsUserRetentionDayRate> getByDtAndRetentionDay(String dt,int size,int retentionDay);

}
