package com.hnust.service.impl;

import com.hnust.entity.AdsUserRetentionCountDay;
import com.hnust.mapper.AdsUserRetentionCountDayMapper;
import com.hnust.service.AdsUserRetentionCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsUserRetentionCountDayServiceImpl implements AdsUserRetentionCountDayService {

    @Autowired
    private AdsUserRetentionCountDayMapper adsUserRetentionCountDayMapper;

    @Override
    public ArrayList<AdsUserRetentionCountDay> queryAll() {
        return adsUserRetentionCountDayMapper.queryAll();
    }
}
