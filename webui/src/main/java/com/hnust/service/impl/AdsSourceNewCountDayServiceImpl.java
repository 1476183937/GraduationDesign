package com.hnust.service.impl;

import com.hnust.entity.AdsSourceNewCountDay;
import com.hnust.entity.vo.SourceActivityVO;
import com.hnust.mapper.AdsSourceNewCountDayMapper;
import com.hnust.service.AdsSourceNewCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 各个渠道新增用户
 */
@Service
public class AdsSourceNewCountDayServiceImpl implements AdsSourceNewCountDayService {

    @Autowired
    private AdsSourceNewCountDayMapper adsSourceNewCountDayMapper;

    @Override
    public ArrayList<AdsSourceNewCountDay> queryAll() {
        return adsSourceNewCountDayMapper.queryAll();
    }

    //根据日期获取各个渠道新增用户数
    public ArrayList<SourceActivityVO> getByDt(String dt){

        return adsSourceNewCountDayMapper.queryByDt(dt);
    }

}
