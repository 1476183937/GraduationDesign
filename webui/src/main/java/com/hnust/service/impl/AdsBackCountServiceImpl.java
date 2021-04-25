package com.hnust.service.impl;

import com.hnust.entity.AdsBackCount;
import com.hnust.mapper.AdsBackCountMapper;
import com.hnust.service.AdsBackCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 回流用户数 service
 */
@Service
public class AdsBackCountServiceImpl implements AdsBackCountService {

    @Autowired
    private AdsBackCountMapper adsBackCountMapper;

    @Override
    public ArrayList<AdsBackCount> queryAll() {
        return adsBackCountMapper.queryAll();
    }

    //根据日期获取周回流用户数
    public ArrayList<AdsBackCount> getByDt(String dt,int size){

        ArrayList<AdsBackCount> backCounts = adsBackCountMapper.queryByDt(dt, size);

        return backCounts;
    }

}
