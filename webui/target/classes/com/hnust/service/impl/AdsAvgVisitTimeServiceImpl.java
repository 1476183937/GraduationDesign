package com.hnust.service.impl;

import com.hnust.entity.AdsAvgVisitTime;
import com.hnust.mapper.AdsAvgVisitTimeMapper;
import com.hnust.service.AdsAvgVisitTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsAvgVisitTimeServiceImpl implements AdsAvgVisitTimeService {

    @Autowired
    private AdsAvgVisitTimeMapper adsAvgVisitTimeMapper;

    @Override
    public ArrayList<AdsAvgVisitTime> queryAll() {
        return adsAvgVisitTimeMapper.queryAll();
    }
}
