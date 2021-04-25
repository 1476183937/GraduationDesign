package com.hnust.controller;

import com.hnust.entity.AdsHourseDetailViewCountDay;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsHourseDetailViewCountDayService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 详情页浏览次数 controller
 */
@Controller
public class DetailCountController {


    @Autowired
    private AdsHourseDetailViewCountDayService adsHourseDetailViewCountDayService;

    @RequestMapping("/detail_view_count.html")
    public String detailCount(ModelMap modelMap){

        String now = DateUtils.getNow("yyyy-MM-dd");

        String preDate = DateUtils.dateAdd(now, -6);

        ArrayList<AdsHourseDetailViewCountDay> detailViewCount = adsHourseDetailViewCountDayService.getByDt(preDate, 7);

        ResultEntity<ArrayList<AdsHourseDetailViewCountDay>> detailViewCountEntity = ResultEntity.successWithData(detailViewCount);

        modelMap.addAttribute("detailViewCountEntity",detailViewCountEntity);
        return "detail_view_count";
    }

    /*@RequestMapping("/detail_view_count.html")
    public String test(ModelMap modelMap){


        Random random = new Random();
        ArrayList<AdsHourseDetailViewCountDay> detailViewCount = new ArrayList<>();

        AdsHourseDetailViewCountDay adsHourseDetailViewCountDay1 = new AdsHourseDetailViewCountDay();
        adsHourseDetailViewCountDay1.setDt("2020-11-16");
        adsHourseDetailViewCountDay1.setDetailViewCount(1000+random.nextInt(500));
        AdsHourseDetailViewCountDay adsHourseDetailViewCountDay2 = new AdsHourseDetailViewCountDay();
        adsHourseDetailViewCountDay2.setDt("2020-11-17");
        adsHourseDetailViewCountDay2.setDetailViewCount(1000+random.nextInt(500));
        AdsHourseDetailViewCountDay adsHourseDetailViewCountDay3 = new AdsHourseDetailViewCountDay();
        adsHourseDetailViewCountDay3.setDt("2020-11-18");
        adsHourseDetailViewCountDay3.setDetailViewCount(1000+random.nextInt(500));
        AdsHourseDetailViewCountDay adsHourseDetailViewCountDay4 = new AdsHourseDetailViewCountDay();
        adsHourseDetailViewCountDay4.setDt("2020-11-19");
        adsHourseDetailViewCountDay4.setDetailViewCount(1000+random.nextInt(500));
        AdsHourseDetailViewCountDay adsHourseDetailViewCountDay5 = new AdsHourseDetailViewCountDay();
        adsHourseDetailViewCountDay5.setDt("2020-11-20");
        adsHourseDetailViewCountDay5.setDetailViewCount(1000+random.nextInt(500));
        AdsHourseDetailViewCountDay adsHourseDetailViewCountDay6 = new AdsHourseDetailViewCountDay();
        adsHourseDetailViewCountDay6.setDt("2020-11-21");
        adsHourseDetailViewCountDay6.setDetailViewCount(1000+random.nextInt(500));
        AdsHourseDetailViewCountDay adsHourseDetailViewCountDay7 = new AdsHourseDetailViewCountDay();
        adsHourseDetailViewCountDay7.setDt("2020-11-22");
        adsHourseDetailViewCountDay7.setDetailViewCount(1000+random.nextInt(500));

        detailViewCount.add(adsHourseDetailViewCountDay1);
        detailViewCount.add(adsHourseDetailViewCountDay2);
        detailViewCount.add(adsHourseDetailViewCountDay3);
        detailViewCount.add(adsHourseDetailViewCountDay4);
        detailViewCount.add(adsHourseDetailViewCountDay5);
        detailViewCount.add(adsHourseDetailViewCountDay6);
        detailViewCount.add(adsHourseDetailViewCountDay7);
        ResultEntity<ArrayList<AdsHourseDetailViewCountDay>> detailViewCountEntity = ResultEntity.successWithData(detailViewCount);

        modelMap.addAttribute("detailViewCountEntity",detailViewCountEntity);
        return "detail_view_count";
    }*/


    //根据日期 dt 获取近几天详情页浏览次数
    @RequestMapping("/detail_view_count")
    @ResponseBody
    public ResultEntity<ArrayList<AdsHourseDetailViewCountDay>> getByDt(@RequestBody String dt){

        String preDate = DateUtils.dateAdd(dt, -6);

        ArrayList<AdsHourseDetailViewCountDay> detailViewCount = adsHourseDetailViewCountDayService.getByDt(preDate, 7);

        ResultEntity<ArrayList<AdsHourseDetailViewCountDay>> detailViewCountEntity = ResultEntity.successWithData(detailViewCount);

        return detailViewCountEntity;
    }


}
