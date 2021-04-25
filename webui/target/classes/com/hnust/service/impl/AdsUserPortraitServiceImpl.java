package com.hnust.service.impl;

import com.hnust.entity.AdsUserPortrait;
import com.hnust.mapper.AdsUserPortraitMapper;
import com.hnust.service.AdsUserPortraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdsUserPortraitServiceImpl implements AdsUserPortraitService {

    @Autowired
    private AdsUserPortraitMapper adsUserPortraitMapper;

    @Override
    public ArrayList<AdsUserPortrait> queryAll() {
        return adsUserPortraitMapper.queryAll();
    }
}
