package com.hnust.service.impl;

import com.hnust.entity.AdsPageViewCount;
import com.hnust.mapper.AdsPageViewCountMapper;
import com.hnust.service.AdsPageViewCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsPageViewCountServiceImpl implements AdsPageViewCountService {

    @Autowired
    private AdsPageViewCountMapper adsPageViewCountMapper;

    @Override
    public ArrayList<AdsPageViewCount> queryAll() {
        return adsPageViewCountMapper.queryAll();
    }
}
