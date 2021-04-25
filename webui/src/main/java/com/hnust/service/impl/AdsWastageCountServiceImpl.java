package com.hnust.service.impl;

import com.hnust.entity.AdsWastageCount;
import com.hnust.mapper.AdsWastageCountMapper;
import com.hnust.service.AdsWastageCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 每日流失用户数 service
 */
@Service
public class AdsWastageCountServiceImpl implements AdsWastageCountService {

    @Autowired
    private AdsWastageCountMapper adsWastageCountMapper;

    @Override
    public ArrayList<AdsWastageCount> queryAll() {
        return adsWastageCountMapper.queryAll();
    }

    //根据日期获取流失用户数的数据
    public ArrayList<AdsWastageCount> getByDt(String dt,int size){

        ArrayList<AdsWastageCount> wastageCounts = adsWastageCountMapper.queryByDt(dt, size);

        return wastageCounts;
    }

}
