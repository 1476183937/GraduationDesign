package com.hnust.service.impl;

import com.hnust.entity.AdsReportCountDay;
import com.hnust.mapper.AdsReportCountDayMapper;
import com.hnust.service.AdsReportCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsReportCountDayServiceImpl implements AdsReportCountDayService {

    @Autowired
    private AdsReportCountDayMapper adsReportCountDayMapper;

    @Override
    public ArrayList<AdsReportCountDay> queryAll() {
        return adsReportCountDayMapper.queryAll();
    }
}
