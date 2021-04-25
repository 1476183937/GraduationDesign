package com.hnust.service.impl;

import com.hnust.entity.AdsBackCount;
import com.hnust.mapper.AdsBackCountMapper;
import com.hnust.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private AdsBackCountMapper adsBackCountMapper;

    @Override
    public ArrayList<AdsBackCount> queryAdsBackCount() {

        ArrayList<AdsBackCount> adsBackCounts = adsBackCountMapper.queryAll();

        return adsBackCounts;
//        return null;
    }
}
