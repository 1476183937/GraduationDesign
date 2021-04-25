package com.hnust.service.impl;

import com.hnust.entity.AdsUserRetentionDayRate;
import com.hnust.mapper.AdsUserRetentionDayRateMapper;
import com.hnust.service.AdsUserRetentionDayRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 用户留存率 service
 */
@Service
public class AdsUserRetentionDayRateServiceImpl implements AdsUserRetentionDayRateService {

    @Autowired
    private AdsUserRetentionDayRateMapper adsUserRetentionDayRateMapper;

    @Override
    public ArrayList<AdsUserRetentionDayRate> queryAll() {
        return adsUserRetentionDayRateMapper.queryAll();
    }

    //获取指定日期 dt 和留存天数的数据
    @Override
    public ArrayList<AdsUserRetentionDayRate> getByDtAndRetentionDay(String dt, int size, int retentionDay) {

        ArrayList<AdsUserRetentionDayRate> userRetentionDayRates = adsUserRetentionDayRateMapper.queryByDtAndRententionDay(dt, size, retentionDay);

        return userRetentionDayRates;
    }



}
