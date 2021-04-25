package com.hnust.service.impl;

import com.hnust.entity.AdsDealCountDay;
import com.hnust.mapper.AdsDealCountDayMapper;
import com.hnust.service.AdsDealCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsDealCountDayServiceImpl implements AdsDealCountDayService {

    @Autowired
    private AdsDealCountDayMapper adsDealCountDayMapper;

    @Override
    public ArrayList<AdsDealCountDay> queryAll() {
        return adsDealCountDayMapper.queryAll();
    }

    /**
     * 根据日期获取最近几天的成交数
     * @param dt
     * @param size
     * @return
     */
    @Override
    public ArrayList<AdsDealCountDay> getByDt(String dt, int size) {

        ArrayList<AdsDealCountDay> dealCountDays = adsDealCountDayMapper.queryByDt(dt, size);

        return dealCountDays;
    }
}
