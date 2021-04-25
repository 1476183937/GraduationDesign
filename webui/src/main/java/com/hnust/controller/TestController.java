package com.hnust.controller;


import com.hnust.service.TestService;
import com.hnust.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private AdsAppointmentCountDayServiceImpl adsAppointmentCountDayServiceImpl;

    @Autowired
    private AdsAvgVisitTimeServiceImpl adsAvgVisitTimeServiceImpl;

    @Autowired
    private AdsBackCountServiceImpl adsBackCountServiceImpl;

    @Autowired
    private AdsContinuityUvCountServiceImpl adsContinuityUvCountServiceImpl;

    @Autowired
    private AdsContinuityWkCountServiceImpl adsContinuityWkCountServiceImpl;

    @Autowired
    private AdsDealCountDayServiceImpl adsDealCountDayServiceImpl;

    @Autowired
    private AdsHourseCollectCountDayServiceImpl adsHourseCollectCountDayServiceImpl;

    @Autowired
    private AdsHourseDetailViewCountDayServiceImpl adsHourseDetailViewCountDayServiceImpl;

    @Autowired
    private AdsHourseListViewCountDayServiceImpl adsHourseListViewCountDayServiceImpl;

    @Autowired
    private AdsLookCountDayServiceImpl adsLookCountDayServiceImpl;

    @Autowired
    private AdsNewUidCountServiceImpl adsNewUidCountServiceImpl;

    @Autowired
    private AdsPageViewCountServiceImpl adsPageViewCountServiceImpl;

    @Autowired
    private AdsProvinceCityCountDayServiceImpl adsProvinceCityCountDayServiceImpl;

    @Autowired
    private AdsReportCountDayServiceImpl adsReportCountDayServiceImpl;

    @Autowired
    private AdsSearchWordCountDayServiceImpl adsSearchWordCountDayServiceImpl;

    @Autowired
    private AdsSlientCountServiceImpl adsSlientCountServiceImpl;

    @Autowired
    private AdsSourceNewCountDayServiceImpl adsSourceNewCountDayServiceImpl;

    @Autowired
    private AdsSourceUserCountDayServiceImpl adsSourceUserCountDayServiceImpl;

    @Autowired
    private AdsUrlCountServiceImpl adsUrlCountServiceImpl;

    @Autowired
    private AdsUserPortraitServiceImpl adsUserPortraitServiceImpl;

    @Autowired
    private AdsUserRetentionCountDayServiceImpl adsUserRetentionCountDayServiceImpl;

    @Autowired
    private AdsUserRetentionDayRateServiceImpl adsUserRetentionDayRateServiceImpl;

    @Autowired
    private AdsUvCountServiceImpl adsUvCountServiceImpl;

    @Autowired
    private AdsWastageCountServiceImpl adsWastageCountServiceImpl;

    /*@RequestMapping("/test")
    @ResponseBody
    public ArrayList<AdsBackCount> test(){

        ArrayList<AdsBackCount> adsBackCounts = testService.queryAdsBackCount();
        System.out.println("aaa");
        return adsBackCounts;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public ArrayList<AdsSlientCount> test1(){

        ArrayList<AdsSlientCount> adsBackCounts = adsSlientCountServiceImpl.queryAll();
        return adsBackCounts;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public ArrayList<AdsDealCountDay> test2(){

        ArrayList<AdsDealCountDay> adsBackCounts = adsDealCountDayServiceImpl.queryAll();
        return adsBackCounts;
    }*/

    /*@RequestMapping("/index")
    public String index(){

        System.out.println("index");
        return "index";
    }

    @RequestMapping("/{page}.html")
    public String page(@PathVariable("page") String page){

        return page;
    }

    @RequestMapping("/test3")
    public String test3(){

        System.out.println("test3");
        return "test";
    }*/




/*
1、用户活跃情况：日、周、月、连续3周活跃、最近7天连续3天活跃
2、用户日新增情况
3、用户日留存情况：留存数和留存率
4、每日沉默用户数情况
5、每周回流数情况
6、每日流失数情况
7、连续最近3周活跃的用户数 -
8、最近7天连续3天活跃用户数 -
9、每日页面浏览量+每日url访问情况
10、每日url访问情况 -
11、每日人均访问时长
12、每日预约看房数表
13、每日带看数表
14、每日报备数表
15、每日成交数
16、每日楼盘列表页浏览次数表
17、每日楼盘详情页浏览次数表
18、各楼盘每日收藏数统计表
19、各个省份、城市每日活跃数表
20、各个搜索词每日的统计数
21、各个渠道的每日活跃用户数
22、各个渠道每日新增用户数
23、用户画像*/



}
