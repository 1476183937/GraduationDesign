package com.hnust.controller;

import com.hnust.entity.AdsHourseListViewCountDay;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsHourseListViewCountDayService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 列表浏览次数 controller
 */
@Controller
public class ListViewCountController {

    @Autowired
    private AdsHourseListViewCountDayService adsHourseListViewCountDayService;

    @RequestMapping("/list_view_count.html")
    public String listViewCount(ModelMap modelMap){

        String now = DateUtils.getNow("yyyy-MM-dd");
        String preDate = DateUtils.dateAdd(now, -6);

        ArrayList<AdsHourseListViewCountDay> listViewCount = adsHourseListViewCountDayService.getByDt(preDate, 7);

        ResultEntity<ArrayList<AdsHourseListViewCountDay>> listViewCountEntity = ResultEntity.successWithData(listViewCount);

        modelMap.addAttribute("listViewCountEntity",listViewCountEntity);

        return "list_view_count";
    }

    /*@RequestMapping("/list_view_count.html")
    public String test(ModelMap modelMap){

        Random random = new Random();
        ArrayList<AdsHourseListViewCountDay> listViewCount = new ArrayList<>();
        AdsHourseListViewCountDay adsHourseListViewCountDay1 = new AdsHourseListViewCountDay();
        adsHourseListViewCountDay1.setDt("2020-11-16");
        adsHourseListViewCountDay1.setListViewCount((long) (1000+random.nextInt(500)));

        AdsHourseListViewCountDay adsHourseListViewCountDay2 = new AdsHourseListViewCountDay();
        adsHourseListViewCountDay2.setDt("2020-11-17");
        adsHourseListViewCountDay2.setListViewCount((long) (1000+random.nextInt(500)));

        AdsHourseListViewCountDay adsHourseListViewCountDay3 = new AdsHourseListViewCountDay();
        adsHourseListViewCountDay3.setDt("2020-11-18");
        adsHourseListViewCountDay3.setListViewCount((long) (1000+random.nextInt(500)));

        AdsHourseListViewCountDay adsHourseListViewCountDay4 = new AdsHourseListViewCountDay();
        adsHourseListViewCountDay4.setDt("2020-11-19");
        adsHourseListViewCountDay4.setListViewCount((long) (1000+random.nextInt(500)));

        AdsHourseListViewCountDay adsHourseListViewCountDay5 = new AdsHourseListViewCountDay();
        adsHourseListViewCountDay5.setDt("2020-11-20");
        adsHourseListViewCountDay5.setListViewCount((long) (1000+random.nextInt(500)));

        AdsHourseListViewCountDay adsHourseListViewCountDay6 = new AdsHourseListViewCountDay();
        adsHourseListViewCountDay6.setDt("2020-11-21");
        adsHourseListViewCountDay6.setListViewCount((long) (1000+random.nextInt(500)));

        AdsHourseListViewCountDay adsHourseListViewCountDay7 = new AdsHourseListViewCountDay();
        adsHourseListViewCountDay7.setDt("2020-11-22");
        adsHourseListViewCountDay7.setListViewCount((long) (1000+random.nextInt(500)));

        listViewCount.add(adsHourseListViewCountDay1);
        listViewCount.add(adsHourseListViewCountDay2);
        listViewCount.add(adsHourseListViewCountDay3);
        listViewCount.add(adsHourseListViewCountDay4);
        listViewCount.add(adsHourseListViewCountDay5);
        listViewCount.add(adsHourseListViewCountDay6);
        listViewCount.add(adsHourseListViewCountDay7);

        ResultEntity<ArrayList<AdsHourseListViewCountDay>> listViewCountEntity = ResultEntity.successWithData(listViewCount);

        modelMap.addAttribute("listViewCountEntity",listViewCountEntity);

        return "list_view_count";
    }*/

    //根据日期 dt 获取列表页浏览次数
    @RequestMapping("/list_view_count")
    @ResponseBody
    public ResultEntity<ArrayList<AdsHourseListViewCountDay>> getByDt(@RequestBody String dt){

        String preDate = DateUtils.dateAdd(dt, -6);

        ArrayList<AdsHourseListViewCountDay> listViewCount = adsHourseListViewCountDayService.getByDt(preDate, 7);
        ResultEntity<ArrayList<AdsHourseListViewCountDay>> listViewCountEntity = ResultEntity.successWithData(listViewCount);

        return listViewCountEntity;
    }

}
