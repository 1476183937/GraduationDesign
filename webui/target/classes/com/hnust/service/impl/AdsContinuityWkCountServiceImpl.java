package com.hnust.service.impl;

import com.hnust.entity.AdsContinuityWkCount;
import com.hnust.mapper.AdsContinuityWkCountMapper;
import com.hnust.service.AdsContinuityWkCountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class AdsContinuityWkCountServiceImpl implements AdsContinuityWkCountService {

    @Resource
    private AdsContinuityWkCountMapper adsContinuityWkCountMapper;


    @Override
    public ArrayList<AdsContinuityWkCount> queryAll() {
        return adsContinuityWkCountMapper.queryAll();
    }

    //获取指定日期 dt 后的数据
    public ArrayList<AdsContinuityWkCount> getByDt(String dt, int size){

        return adsContinuityWkCountMapper.queryByDt(dt,size);
    }

    //获取最新的几条数据
    public ArrayList<AdsContinuityWkCount> getLatest(int size){

        return adsContinuityWkCountMapper.queryLatest(size);
    }

}
