package com.hnust.controller;

import com.hnust.entity.AdsHourseCollectCountDay;
import com.hnust.entity.ResultEntity;
import com.hnust.entity.vo.CollectCountVO;
import com.hnust.service.AdsHourseCollectCountDayService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class CollectController {

    @Autowired
    private AdsHourseCollectCountDayService adsHourseCollectCountDayService;

    @RequestMapping("/collect.html")
    public String collect(ModelMap modelMap){

        String now = DateUtils.getNow("yyyy-MM-dd");

        String preDate = DateUtils.dateAdd(now, -6);

        //获取最近7天的收藏数统计
        ArrayList<CollectCountVO> collectCount = adsHourseCollectCountDayService.getByDt(preDate, 7);
        ResultEntity<ArrayList<CollectCountVO>> collectCountEntity = ResultEntity.successWithData(collectCount);

        //获取今日收藏数前十的房屋
        ArrayList<AdsHourseCollectCountDay> collectCountByDt = adsHourseCollectCountDayService.getCollectCountByDt(now, 10);
        ResultEntity<Object> collectCountDayEntity = ResultEntity.successWithData(collectCountByDt);

        modelMap.addAttribute("collectCountEntity",collectCountEntity);
        modelMap.addAttribute("collectCountDayEntity",collectCountDayEntity);


        return "collect";
    }

    /*@RequestMapping("/collect.html")
    public String test(ModelMap modelMap){

        Random random = new Random();
        ArrayList<CollectCountVO> collectCount = new ArrayList<>();

        CollectCountVO collectCountVO1 = new CollectCountVO();
        collectCountVO1.setDt("2020-11-16");
        collectCountVO1.setCollectCount((long) (1000+random.nextInt(500)));
        CollectCountVO collectCountVO2 = new CollectCountVO();
        collectCountVO2.setDt("2020-11-17");
        collectCountVO2.setCollectCount((long) (1000+random.nextInt(500)));
        CollectCountVO collectCountVO3 = new CollectCountVO();
        collectCountVO3.setDt("2020-11-18");
        collectCountVO3.setCollectCount((long) (1000+random.nextInt(500)));
        CollectCountVO collectCountVO4 = new CollectCountVO();
        collectCountVO4.setDt("2020-11-19");
        collectCountVO4.setCollectCount((long) (1000+random.nextInt(500)));
        CollectCountVO collectCountVO5 = new CollectCountVO();
        collectCountVO5.setDt("2020-11-20");
        collectCountVO5.setCollectCount((long) (1000+random.nextInt(500)));
        CollectCountVO collectCountVO6 = new CollectCountVO();
        collectCountVO6.setDt("2020-11-21");
        collectCountVO6.setCollectCount((long) (1000+random.nextInt(500)));
        CollectCountVO collectCountVO7 = new CollectCountVO();
        collectCountVO7.setDt("2020-11-22");
        collectCountVO7.setCollectCount((long) (1000+random.nextInt(500)));

        collectCount.add(collectCountVO1);
        collectCount.add(collectCountVO2);
        collectCount.add(collectCountVO3);
        collectCount.add(collectCountVO4);
        collectCount.add(collectCountVO5);
        collectCount.add(collectCountVO6);
        collectCount.add(collectCountVO7);

        ResultEntity<ArrayList<CollectCountVO>> collectCountEntity = ResultEntity.successWithData(collectCount);

        ArrayList<AdsHourseCollectCountDay> collectCountDay = new ArrayList<>();
        AdsHourseCollectCountDay adsHourseCollectCountDay1 = new AdsHourseCollectCountDay();
        adsHourseCollectCountDay1.setDt("2020-11-16");
        adsHourseCollectCountDay1.setCollectCount(1000+random.nextInt(500));
        adsHourseCollectCountDay1.setHourseName("aaaa");
        AdsHourseCollectCountDay adsHourseCollectCountDay2 = new AdsHourseCollectCountDay();
        adsHourseCollectCountDay2.setDt("2020-11-16");
        adsHourseCollectCountDay2.setCollectCount(1000+random.nextInt(500));
        adsHourseCollectCountDay2.setHourseName("aafafaaa");
        AdsHourseCollectCountDay adsHourseCollectCountDay3 = new AdsHourseCollectCountDay();
        adsHourseCollectCountDay3.setDt("2020-11-16");
        adsHourseCollectCountDay3.setCollectCount(1000+random.nextInt(500));
        adsHourseCollectCountDay3.setHourseName("fdsafa");
        AdsHourseCollectCountDay adsHourseCollectCountDay4 = new AdsHourseCollectCountDay();
        adsHourseCollectCountDay4.setDt("2020-11-16");
        adsHourseCollectCountDay4.setCollectCount(1000+random.nextInt(500));
        adsHourseCollectCountDay4.setHourseName("fdafas");
        AdsHourseCollectCountDay adsHourseCollectCountDay5 = new AdsHourseCollectCountDay();
        adsHourseCollectCountDay5.setDt("2020-11-16");
        adsHourseCollectCountDay5.setCollectCount(1000+random.nextInt(500));
        adsHourseCollectCountDay5.setHourseName("fdafac");
        AdsHourseCollectCountDay adsHourseCollectCountDay6 = new AdsHourseCollectCountDay();
        adsHourseCollectCountDay6.setDt("2020-11-16");
        adsHourseCollectCountDay6.setCollectCount(1000+random.nextInt(500));
        adsHourseCollectCountDay6.setHourseName("fdsac");
        AdsHourseCollectCountDay adsHourseCollectCountDay7 = new AdsHourseCollectCountDay();
        adsHourseCollectCountDay7.setDt("2020-11-16");
        adsHourseCollectCountDay7.setCollectCount(1000+random.nextInt(500));
        adsHourseCollectCountDay7.setHourseName("vvvv");

        collectCountDay.add(adsHourseCollectCountDay1);
        collectCountDay.add(adsHourseCollectCountDay2);
        collectCountDay.add(adsHourseCollectCountDay3);
        collectCountDay.add(adsHourseCollectCountDay4);
        collectCountDay.add(adsHourseCollectCountDay5);
        collectCountDay.add(adsHourseCollectCountDay6);
        collectCountDay.add(adsHourseCollectCountDay7);

        ResultEntity<ArrayList<AdsHourseCollectCountDay>> collectCountDayEntity = ResultEntity.successWithData(collectCountDay);

        modelMap.addAttribute("collectCountDayEntity",collectCountDayEntity);
        modelMap.addAttribute("collectCountEntity",collectCountEntity);

        return "collect";
    }*/

    //根据日期获取最近几天的房屋收藏数
    @RequestMapping("collect_count")
    @ResponseBody
    public ResultEntity<ArrayList<CollectCountVO>> getByDt(@RequestBody String dt){

        String preDate = DateUtils.dateAdd(dt, -6);

        ArrayList<CollectCountVO> collectCount = adsHourseCollectCountDayService.getByDt(preDate, 7);

        ResultEntity<ArrayList<CollectCountVO>> collectCountEntity = ResultEntity.successWithData(collectCount);

        return collectCountEntity;
    }

    //获取日期 dt 那天收藏数前几的房屋
    @RequestMapping("/collect_count_day")
    @ResponseBody
    public ResultEntity<ArrayList<AdsHourseCollectCountDay>> getCollectCountByDt(@RequestBody String dt){

        ArrayList<AdsHourseCollectCountDay> collectCount = adsHourseCollectCountDayService.getCollectCountByDt(dt, 10);

        Collections.reverse(collectCount);

        ResultEntity<ArrayList<AdsHourseCollectCountDay>> collectCountEntity = ResultEntity.successWithData(collectCount);

        return collectCountEntity;
    }

}
