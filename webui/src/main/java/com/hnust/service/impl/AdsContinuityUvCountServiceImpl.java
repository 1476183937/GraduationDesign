package com.hnust.service.impl;

import com.hnust.entity.AdsContinuityUvCount;
import com.hnust.mapper.AdsContinuityUvCountMapper;
import com.hnust.service.AdsContinuityUvCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsContinuityUvCountServiceImpl implements AdsContinuityUvCountService {

    @Autowired
    private AdsContinuityUvCountMapper adsContinuityUvCountMapper;

    @Override
    public ArrayList<AdsContinuityUvCount> queryAll() {
        return adsContinuityUvCountMapper.queryAll();
    }

    //获取指定日期 dt 后的数据
    public ArrayList<AdsContinuityUvCount> getByDt(String dt, int size){

        return adsContinuityUvCountMapper.queryByDt(dt,size);
    }

}
