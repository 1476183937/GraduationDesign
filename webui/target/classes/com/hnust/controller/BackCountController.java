package com.hnust.controller;

import com.hnust.entity.AdsBackCount;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsBackCountService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 回流用户数 controller
 */
@Controller
public class BackCountController {


    @Autowired
    private AdsBackCountService adsBackCountService;


    @RequestMapping("/back_count.html")
    public String backCount(ModelMap modelMap){

        //获取当前日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取周一日期
        String monday = DateUtils.getMonday(now);

        //获取4周前的日期
        String preDate = DateUtils.dateAdd(monday, -28);

        ArrayList<AdsBackCount> backCounts = adsBackCountService.getByDt(preDate, 5);

        ResultEntity<ArrayList<AdsBackCount>> backCountsEntity = ResultEntity.successWithData(backCounts);

        modelMap.addAttribute("backCountsEntity",backCountsEntity);

        return "back_count";
    }

    /*@RequestMapping("/back_count.html")
    public String test(ModelMap modelMap){

        ArrayList<AdsBackCount> backCounts = new ArrayList<>();

        Random random = new Random();
        AdsBackCount adsBackCount1 = new AdsBackCount();
        adsBackCount1.setDt("2020-11-16");
        adsBackCount1.setBackCount((long) (1000+random.nextInt(500)));
        adsBackCount1.setWkDt("2020-11-16_2020-11-23");

        AdsBackCount adsBackCount2 = new AdsBackCount();
        adsBackCount2.setDt("2020-11-16");
        adsBackCount2.setBackCount((long) (1000+random.nextInt(500)));
        adsBackCount2.setWkDt("2020-11-17_2020-11-23");

        AdsBackCount adsBackCount3 = new AdsBackCount();
        adsBackCount3.setDt("2020-11-16");
        adsBackCount3.setBackCount((long) (1000+random.nextInt(500)));
        adsBackCount3.setWkDt("2020-11-18_2020-11-23");

        AdsBackCount adsBackCount4 = new AdsBackCount();
        adsBackCount4.setDt("2020-11-16");
        adsBackCount4.setBackCount((long) (1000+random.nextInt(500)));
        adsBackCount4.setWkDt("2020-11-19_2020-11-23");

        AdsBackCount adsBackCount5 = new AdsBackCount();
        adsBackCount5.setDt("2020-11-16");
        adsBackCount5.setBackCount((long) (1000+random.nextInt(500)));
        adsBackCount5.setWkDt("2020-11-20_2020-11-23");

        AdsBackCount adsBackCount6 = new AdsBackCount();
        adsBackCount6.setDt("2020-11-16");
        adsBackCount6.setBackCount((long) (1000+random.nextInt(500)));
        adsBackCount6.setWkDt("2020-11-21_2020-11-23");

        AdsBackCount adsBackCount7 = new AdsBackCount();
        adsBackCount7.setDt("2020-11-16");
        adsBackCount7.setBackCount((long) (1000+random.nextInt(500)));
        adsBackCount7.setWkDt("2020-11-22_2020-11-23");

        backCounts.add(adsBackCount1);
        backCounts.add(adsBackCount2);
        backCounts.add(adsBackCount3);
        backCounts.add(adsBackCount4);
        backCounts.add(adsBackCount5);
        backCounts.add(adsBackCount6);
        backCounts.add(adsBackCount7);

        ResultEntity<ArrayList<AdsBackCount>> backCountsEntity = ResultEntity.successWithData(backCounts);

        modelMap.addAttribute("backCountsEntity",backCountsEntity);

        return "back_count";
    }*/

    @RequestMapping("/back_count")
    @ResponseBody
    public ResultEntity<ArrayList<AdsBackCount>> back(@RequestBody String dt){

        //获取日期所在周的周一的日期
        String monday = DateUtils.getMonday(dt);

        //获取4周前的日期
        String preDate = DateUtils.dateAdd(monday, -28);
        ArrayList<AdsBackCount> backCounts = adsBackCountService.getByDt(preDate, 5);

        ResultEntity<ArrayList<AdsBackCount>> backCountsEntity = ResultEntity.successWithData(backCounts);

        return backCountsEntity;
    }

}
