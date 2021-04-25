package com.hnust.service.impl;

import com.hnust.entity.AdsNewUidCount;
import com.hnust.mapper.AdsNewUidCountMapper;
import com.hnust.service.AdsNewUidCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 每日新增用户数的 service
 */
@Service
public class AdsNewUidCountServiceImpl implements AdsNewUidCountService {

    @Autowired
    private AdsNewUidCountMapper adsNewUidCountMapper;

    @Override
    public ArrayList<AdsNewUidCount> queryAll() {
        return adsNewUidCountMapper.queryAll();
    }

    //获取指定日期后的新增用户数的数据
    public ArrayList<AdsNewUidCount> getByDt(String dt,int size){
        ArrayList<AdsNewUidCount> newUidCounts = adsNewUidCountMapper.queryByDt(dt, size);
        return newUidCounts;
    }

}
