package com.hnust.service.impl;

import com.hnust.entity.AdsSlientCount;
import com.hnust.mapper.AdsSlientCountMapper;
import com.hnust.service.AdsSlientCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 每日沉默用户数
 */
@Service
public class AdsSlientCountServiceImpl implements AdsSlientCountService {

    @Autowired
    private AdsSlientCountMapper adsSlientCountMapper;

    @Override
    public ArrayList<AdsSlientCount> queryAll() {
        return adsSlientCountMapper.queryAll();
    }

    //获取指定日期 dt 的沉默用户数的数据
    public ArrayList<AdsSlientCount> getByDt(String dt,int size){
        ArrayList<AdsSlientCount> slientCounts = adsSlientCountMapper.queryByDt(dt, size);

        return slientCounts;
    }

}
