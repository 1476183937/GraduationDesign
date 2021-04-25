package com.hnust.service.impl;

import com.hnust.entity.AdsLookCountDay;
import com.hnust.mapper.AdsLookCountDayMapper;
import com.hnust.service.AdsLookCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 每日带看数service
 */
@Service
public class AdsLookCountDayServiceImpl implements AdsLookCountDayService {

    @Autowired
    private AdsLookCountDayMapper adsLookCountDayMapper;

    @Override
    public ArrayList<AdsLookCountDay> queryAll() {
        return adsLookCountDayMapper.queryAll();
    }

    /**
     * 根据日期获取最近几天的带看数
     * @param dt
     * @param size
     * @return
     */
    @Override
    public ArrayList<AdsLookCountDay> getByDt(String dt, int size) {
        ArrayList<AdsLookCountDay> lookCountDays = adsLookCountDayMapper.queryByDt(dt, size);
        return lookCountDays;
    }
}
