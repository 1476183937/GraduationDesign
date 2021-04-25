package com.hnust.service.impl;

import com.hnust.entity.AdsProvinceCityCountDay;
import com.hnust.mapper.AdsProvinceCityCountDayMapper;
import com.hnust.service.AdsProvinceCityCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 每日各省市活跃数据
 */
@Service
public class AdsProvinceCityCountDayServiceImpl implements AdsProvinceCityCountDayService {

    @Autowired
    private AdsProvinceCityCountDayMapper adsProvinceCityCountDayMapper;

    @Override
    public ArrayList<AdsProvinceCityCountDay> queryAll() {
        return adsProvinceCityCountDayMapper.queryAll();
    }

    //根据日期查询当日的省市活跃数据
    public ArrayList<AdsProvinceCityCountDay> getByDt(String dt){

        return adsProvinceCityCountDayMapper.queryByDt(dt);
    }

    //根据日期和省份查询当日的省市活跃数据
    public ArrayList<AdsProvinceCityCountDay> getByProvinceAndDt(String province,String dt){

        return adsProvinceCityCountDayMapper.queryByProvinceAndDt(province,dt);
    }

}
