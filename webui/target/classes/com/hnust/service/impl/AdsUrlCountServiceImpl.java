package com.hnust.service.impl;

import com.hnust.entity.AdsUrlCount;
import com.hnust.mapper.AdsUrlCountMapper;
import com.hnust.service.AdsUrlCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 每日的url浏览次数统计 service
 */
@Service
public class AdsUrlCountServiceImpl implements AdsUrlCountService {

    @Autowired
    private AdsUrlCountMapper adsUrlCountMapper;

    @Override
    public ArrayList<AdsUrlCount> queryAll() {
        return adsUrlCountMapper.queryAll();
    }

    //获取指定日期 dt 中浏览次数最多的几条url
    public ArrayList<AdsUrlCount> getByDt(String dt,int size){

        ArrayList<AdsUrlCount> urlCounts = adsUrlCountMapper.queryByDt(dt, size);

        return urlCounts;
    }

}
