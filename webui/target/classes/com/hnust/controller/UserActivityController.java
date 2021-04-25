package com.hnust.controller;


import com.hnust.entity.*;
import com.hnust.service.*;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Random;


@Controller
public class UserActivityController {

    @Autowired
    private AdsContinuityUvCountService adsContinuityUvCountService;

    @Autowired
    private AdsContinuityWkCountService adsContinuityWkCountService;

    @Autowired
    private AdsUvCountService adsUvCountService;

    @Autowired
    private AdsNewUidCountService adsNewUidCountService;

    @Autowired
    private AdsDealCountDayService adsDealCountDayService;

    @Autowired
    private AdsBackCountService adsBackCountService;


    /**
     * 访问用户活跃情况页面
     * @param
     * @return
     */
    @RequestMapping("/user_activity.html")
    public String userActivityPage(ModelMap modelMap){


        String now = DateUtils.getNow("yyyy-MM-dd");

        //1、获取最近几天的日活跃数
        //获取7天前的日期
        String pre7DayDate = DateUtils.dateAdd(now, -6);
        //获取数据
        ArrayList<AdsUvCount> dayActivityList = adsUvCountService.getByDay(pre7DayDate, 7);

        //2、获取最近几周的周活跃数
        String monday = DateUtils.getMonday(now);
        // 2.1获取5这周前的日期
        String pre5WeeksDate = DateUtils.dateAdd(monday, -35);

        // 2.2获取前4周的数据和本周次最新一天的数据
        ArrayList<AdsUvCount> pre5WkActivityList = adsUvCountService.getByWk(pre5WeeksDate, 4);
        ArrayList<AdsUvCount> latestActivityList = adsUvCountService.getLatest();

        pre5WkActivityList.addAll(latestActivityList);

        //3、获取最近5月的月活跃数

        //3.1 获取4个月前的日期
        String pre4MnDate = DateUtils.monthAdd(now, -4);
        pre4MnDate = pre4MnDate.substring(0,7)+"-01";

        //3.2 获取数据
        ArrayList<AdsUvCount> pre4MnActivityList = adsUvCountService.getByMn(pre4MnDate, 4);
        pre4MnActivityList.addAll(latestActivityList);

        //4、获取最近3周连续活跃的用户活跃数
        ArrayList<AdsContinuityWkCount> threeWkActivityList = adsContinuityWkCountService.getByDt(pre7DayDate, 7);

        //5、获取最近7天连续3天活跃的用户活跃数
        ArrayList<AdsContinuityUvCount> sevenDayActivityList = adsContinuityUvCountService.getByDt(pre7DayDate, 7);

        modelMap.addAttribute("dayActivityList",dayActivityList);
        modelMap.addAttribute("pre5WkActivityList",pre5WkActivityList);
        modelMap.addAttribute("pre4MnActivityList",pre4MnActivityList);
        modelMap.addAttribute("threeWkActivityList",threeWkActivityList);
        modelMap.addAttribute("sevenDayActivityList",sevenDayActivityList);

        return "user_activity";
    }

    @RequestMapping("/index.html")
    public String index(ModelMap modelMap){

        /*//获取当前日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(now, -6);

        int size = 7;
        //获取今日新增、访问、成交、本周回流等数据
        //1、近7天新增用户数的数据
        ArrayList<AdsNewUidCount> newUidCounts = adsNewUidCountService.getByDt(preDate, size);

        //2、近7天活跃用户数的数据
        ArrayList<AdsUvCount> uvCounts = adsUvCountService.getByDay(preDate, size);

        //3、今日成交数
        ArrayList<AdsDealCountDay> dealCounts = adsDealCountDayService.getByDt(now, 1);
        AdsDealCountDay curDayDealCount = dealCounts.get(dealCounts.size() - 1);

        //获取本周周一的日期
        String monday = DateUtils.getMonday(now);

        //4、获取本周回流用户数
        ArrayList<AdsBackCount> backCounts = adsBackCountService.getByDt(monday, 1);
        AdsBackCount curDayBackCount = backCounts.get(backCounts.size() - 1);

        //获取今日新增用户数
        AdsNewUidCount curDayAdd = newUidCounts.get(newUidCounts.size() - 1);

        //获取今日访问数
        AdsUvCount curDayUv = uvCounts.get(uvCounts.size() - 1);

        modelMap.addAttribute("curDayAdd",curDayAdd);
        modelMap.addAttribute("curDayUv",curDayUv);
        modelMap.addAttribute("curDayDealCount",curDayDealCount);
        modelMap.addAttribute("curDayBackCount",curDayBackCount);
        modelMap.addAttribute("uvCounts",uvCounts);
        modelMap.addAttribute("newUidCounts",newUidCounts);*/

        return "index";
    }

    /*@RequestMapping("/index.html")
    public String test(){


        Random random = new Random();

        //获取今日新增、访问、成交、本周回流等数据
        //1、近7天新增用户数的数据
        ArrayList<AdsNewUidCount> newUidCounts = new ArrayList<>();
        AdsNewUidCount adsNewUidCount1 = new AdsNewUidCount();
        adsNewUidCount1.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount1.setCreateDate("2020-11-16");
        AdsNewUidCount adsNewUidCount2 = new AdsNewUidCount();
        adsNewUidCount2.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount2.setCreateDate("2020-11-17");
        AdsNewUidCount adsNewUidCount3 = new AdsNewUidCount();
        adsNewUidCount3.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount3.setCreateDate("2020-11-18");
        AdsNewUidCount adsNewUidCount4 = new AdsNewUidCount();
        adsNewUidCount4.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount4.setCreateDate("2020-11-19");
        AdsNewUidCount adsNewUidCount5 = new AdsNewUidCount();
        adsNewUidCount5.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount5.setCreateDate("2020-11-20");
        AdsNewUidCount adsNewUidCount6 = new AdsNewUidCount();
        adsNewUidCount6.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount6.setCreateDate("2020-11-21");
        AdsNewUidCount adsNewUidCount7 = new AdsNewUidCount();
        adsNewUidCount7.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount7.setCreateDate("2020-11-22");

        newUidCounts.add(adsNewUidCount1);
        newUidCounts.add(adsNewUidCount2);
        newUidCounts.add(adsNewUidCount3);
        newUidCounts.add(adsNewUidCount4);
        newUidCounts.add(adsNewUidCount5);
        newUidCounts.add(adsNewUidCount6);
        newUidCounts.add(adsNewUidCount7);

        //2、近7天活跃用户数的数据
        ArrayList<AdsUvCount> uvCounts = new ArrayList<>();
        AdsUvCount adsUvCount1 = new AdsUvCount();
        adsUvCount1.setDt("2020-11-16");
        adsUvCount1.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount2 = new AdsUvCount();
        adsUvCount2.setDt("2020-11-17");
        adsUvCount2.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount3 = new AdsUvCount();
        adsUvCount3.setDt("2020-11-18");
        adsUvCount3.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount4 = new AdsUvCount();
        adsUvCount4.setDt("2020-11-19");
        adsUvCount4.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount5 = new AdsUvCount();
        adsUvCount5.setDt("2020-11-20");
        adsUvCount5.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount6 = new AdsUvCount();
        adsUvCount6.setDt("2020-11-21");
        adsUvCount6.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount7 = new AdsUvCount();
        adsUvCount7.setDt("2020-11-22");
        adsUvCount7.setDayCount((long) (1000+random.nextInt(500)));

        uvCounts.add(adsUvCount1);
        uvCounts.add(adsUvCount2);
        uvCounts.add(adsUvCount3);
        uvCounts.add(adsUvCount4);
        uvCounts.add(adsUvCount5);
        uvCounts.add(adsUvCount6);
        uvCounts.add(adsUvCount7);

        //3、今日成交数
//        ArrayList<AdsDealCountDay> dealCounts = adsDealCountDayService.getByDt(now, 1);
        AdsDealCountDay curDayDealCount = new AdsDealCountDay();
        curDayDealCount.setDt("2020-11-22");
        curDayDealCount.setDealCount(random.nextInt(500));
        curDayDealCount.setGvm((long) (100000+random.nextInt(200000)));


        //4、获取本周回流用户数
        AdsBackCount curDayBackCount = new AdsBackCount();
        curDayBackCount.setDt("2020-11-22");
        curDayBackCount.setBackCount((long) (1000+random.nextInt(500)));

        //获取今日新增用户数
        AdsNewUidCount curDayAdd = new AdsNewUidCount();
        curDayAdd.setCreateDate("2020-11-22");
        curDayAdd.setNewUidCount((long) (1000+random.nextInt(500)));

        //获取今日访问数
        AdsUvCount curDayUv = new AdsUvCount();
        curDayUv.setDt("2020-11-22");
        curDayUv.setDayCount((long) (1000+random.nextInt(500)));

        modelMap.addAttribute("curDayAdd",curDayAdd);
        modelMap.addAttribute("curDayUv",curDayUv);
        modelMap.addAttribute("curDayDealCount",curDayDealCount);
        modelMap.addAttribute("curDayBackCount",curDayBackCount);
        modelMap.addAttribute("uvCounts",uvCounts);
        modelMap.addAttribute("newUidCounts",newUidCounts);

        return "index";
    }*/

    @RequestMapping("/index_v1.html")
    public String index_v1(ModelMap modelMap){

        Random random = new Random();

        //获取今日新增、访问、成交、本周回流等数据
        //1、近7天新增用户数的数据
        ArrayList<AdsNewUidCount> newUidCounts = new ArrayList<>();
        AdsNewUidCount adsNewUidCount1 = new AdsNewUidCount();
        adsNewUidCount1.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount1.setCreateDate("2020-11-16");
        AdsNewUidCount adsNewUidCount2 = new AdsNewUidCount();
        adsNewUidCount2.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount2.setCreateDate("2020-11-17");
        AdsNewUidCount adsNewUidCount3 = new AdsNewUidCount();
        adsNewUidCount3.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount3.setCreateDate("2020-11-18");
        AdsNewUidCount adsNewUidCount4 = new AdsNewUidCount();
        adsNewUidCount4.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount4.setCreateDate("2020-11-19");
        AdsNewUidCount adsNewUidCount5 = new AdsNewUidCount();
        adsNewUidCount5.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount5.setCreateDate("2020-11-20");
        AdsNewUidCount adsNewUidCount6 = new AdsNewUidCount();
        adsNewUidCount6.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount6.setCreateDate("2020-11-21");
        AdsNewUidCount adsNewUidCount7 = new AdsNewUidCount();
        adsNewUidCount7.setNewUidCount((long) (1000+random.nextInt(500)));
        adsNewUidCount7.setCreateDate("2020-11-22");

        newUidCounts.add(adsNewUidCount1);
        newUidCounts.add(adsNewUidCount2);
        newUidCounts.add(adsNewUidCount3);
        newUidCounts.add(adsNewUidCount4);
        newUidCounts.add(adsNewUidCount5);
        newUidCounts.add(adsNewUidCount6);
        newUidCounts.add(adsNewUidCount7);

        //2、近7天活跃用户数的数据
        ArrayList<AdsUvCount> uvCounts = new ArrayList<>();
        AdsUvCount adsUvCount1 = new AdsUvCount();
        adsUvCount1.setDt("2020-11-16");
        adsUvCount1.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount2 = new AdsUvCount();
        adsUvCount2.setDt("2020-11-17");
        adsUvCount2.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount3 = new AdsUvCount();
        adsUvCount3.setDt("2020-11-18");
        adsUvCount3.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount4 = new AdsUvCount();
        adsUvCount4.setDt("2020-11-19");
        adsUvCount4.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount5 = new AdsUvCount();
        adsUvCount5.setDt("2020-11-20");
        adsUvCount5.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount6 = new AdsUvCount();
        adsUvCount6.setDt("2020-11-21");
        adsUvCount6.setDayCount((long) (1000+random.nextInt(500)));
        AdsUvCount adsUvCount7 = new AdsUvCount();
        adsUvCount7.setDt("2020-11-22");
        adsUvCount7.setDayCount((long) (1000+random.nextInt(500)));

        uvCounts.add(adsUvCount1);
        uvCounts.add(adsUvCount2);
        uvCounts.add(adsUvCount3);
        uvCounts.add(adsUvCount4);
        uvCounts.add(adsUvCount5);
        uvCounts.add(adsUvCount6);
        uvCounts.add(adsUvCount7);

        modelMap.addAttribute("curDayAdd",random.nextInt(500));
        modelMap.addAttribute("curDayUv",random.nextInt(500));
        modelMap.addAttribute("curDayDealCount",random.nextInt(500));
        modelMap.addAttribute("curDayBackCount",random.nextInt(500));
        modelMap.addAttribute("uvCounts",uvCounts);
        modelMap.addAttribute("newUidCounts",newUidCounts);

        return "index_v1";
    }

    /*@RequestMapping("/user_activity.html")
    public String userActivityPageTest(ModelMap modelMap){

        Random random = new Random();
        //1、获取最近几天的日活跃数
        ArrayList<AdsUvCount> dayActivityList = new ArrayList<>();

        AdsUvCount adsUvCount1 = new AdsUvCount();
        adsUvCount1.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount1.setDt("2021-04-15");
        adsUvCount1.setIsMonthend("N");
        adsUvCount1.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount1.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount1.setIsMonthend("N");

        AdsUvCount adsUvCount2 = new AdsUvCount();
        adsUvCount2.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount2.setDt("2021-04-16");
        adsUvCount2.setIsMonthend("N");
        adsUvCount2.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount2.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount2.setIsMonthend("N");

        AdsUvCount adsUvCount3 = new AdsUvCount();
        adsUvCount3.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount3.setDt("2021-04-17");
        adsUvCount3.setIsMonthend("N");
        adsUvCount3.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount3.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount3.setIsMonthend("N");

        AdsUvCount adsUvCount4 = new AdsUvCount();
        adsUvCount4.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount4.setDt("2021-04-18");
        adsUvCount4.setIsMonthend("N");
        adsUvCount4.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount4.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount4.setIsMonthend("N");

        AdsUvCount adsUvCount5 = new AdsUvCount();
        adsUvCount5.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount5.setDt("2021-04-19");
        adsUvCount5.setIsMonthend("N");
        adsUvCount5.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount5.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount5.setIsMonthend("N");

        AdsUvCount adsUvCount6 = new AdsUvCount();
        adsUvCount6.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount6.setDt("2021-04-20");
        adsUvCount6.setIsMonthend("N");
        adsUvCount6.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount6.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount6.setIsMonthend("N");

        AdsUvCount adsUvCount7 = new AdsUvCount();
        adsUvCount7.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount7.setDt("2021-04-21");
        adsUvCount7.setIsMonthend("N");
        adsUvCount7.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount7.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount7.setIsMonthend("N");

        dayActivityList.add(adsUvCount1);
        dayActivityList.add(adsUvCount2);
        dayActivityList.add(adsUvCount3);
        dayActivityList.add(adsUvCount4);
        dayActivityList.add(adsUvCount5);
        dayActivityList.add(adsUvCount6);
        dayActivityList.add(adsUvCount7);

        //2、获取最近几周的周活跃数
        ArrayList<AdsUvCount> pre5WkActivityList = new ArrayList<>();

        AdsUvCount adsUvCount11 = new AdsUvCount();
        adsUvCount11.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount11.setDt("2021/04/15-04/17");
        adsUvCount11.setIsMonthend("N");
        adsUvCount11.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount11.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount11.setIsMonthend("N");

        AdsUvCount adsUvCount12 = new AdsUvCount();
        adsUvCount12.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount12.setDt("2021/04/15-04/18");
        adsUvCount12.setIsMonthend("N");
        adsUvCount12.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount12.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount12.setIsMonthend("N");

        AdsUvCount adsUvCount13 = new AdsUvCount();
        adsUvCount13.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount13.setDt("2021/04/15-04/19");
        adsUvCount13.setIsMonthend("N");
        adsUvCount13.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount13.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount13.setIsMonthend("N");

        AdsUvCount adsUvCount14 = new AdsUvCount();
        adsUvCount14.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount14.setDt("2021/04/15-04/20");
        adsUvCount14.setIsMonthend("N");
        adsUvCount14.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount14.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount14.setIsMonthend("N");

        AdsUvCount adsUvCount15 = new AdsUvCount();
        adsUvCount15.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount15.setDt("2021/04/15-04/21");
        adsUvCount15.setIsMonthend("N");
        adsUvCount15.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount15.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount15.setIsMonthend("N");

        pre5WkActivityList.add(adsUvCount11);
        pre5WkActivityList.add(adsUvCount12);
        pre5WkActivityList.add(adsUvCount13);
        pre5WkActivityList.add(adsUvCount14);
        pre5WkActivityList.add(adsUvCount15);


        //3、获取最近5月的月活跃数
        ArrayList<AdsUvCount> pre4MnActivityList = new ArrayList<>();
        AdsUvCount adsUvCount21 = new AdsUvCount();
        adsUvCount21.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount21.setDt("2021/04");
        adsUvCount21.setIsMonthend("N");
        adsUvCount21.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount21.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount21.setIsMonthend("N");

        AdsUvCount adsUvCount22 = new AdsUvCount();
        adsUvCount22.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount22.setDt("2021/05");
        adsUvCount22.setIsMonthend("N");
        adsUvCount22.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount22.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount22.setIsMonthend("N");

        AdsUvCount adsUvCount23 = new AdsUvCount();
        adsUvCount23.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount23.setDt("2021/06");
        adsUvCount23.setIsMonthend("N");
        adsUvCount23.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount23.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount23.setIsMonthend("N");

        AdsUvCount adsUvCount24 = new AdsUvCount();
        adsUvCount24.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount24.setDt("2021/07");
        adsUvCount24.setIsMonthend("N");
        adsUvCount24.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount24.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount24.setIsMonthend("N");

        AdsUvCount adsUvCount25 = new AdsUvCount();
        adsUvCount25.setDayCount((long) (1000+random.nextInt(10000)));
        adsUvCount25.setDt("2021/08");
        adsUvCount25.setIsMonthend("N");
        adsUvCount25.setMnCount((long) (1000+random.nextInt(10000)));
        adsUvCount25.setWkCount((long) (1000+random.nextInt(10000)));
        adsUvCount25.setIsMonthend("N");

        pre4MnActivityList.add(adsUvCount21);
        pre4MnActivityList.add(adsUvCount22);
        pre4MnActivityList.add(adsUvCount23);
        pre4MnActivityList.add(adsUvCount24);
        pre4MnActivityList.add(adsUvCount25);

        //4、获取最近3周连续活跃的用户活跃数
        ArrayList<AdsContinuityWkCount> threeWkActivityList = new ArrayList<>();
        AdsContinuityWkCount adsContinuityWkCount11 = new AdsContinuityWkCount();
        adsContinuityWkCount11.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount11.setDt("2021/04/17");
        adsContinuityWkCount11.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount11.setWkDt("2021/04/17-04/21");

        AdsContinuityWkCount adsContinuityWkCount12 = new AdsContinuityWkCount();
        adsContinuityWkCount12.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount12.setDt("2021/04/18");
        adsContinuityWkCount12.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount12.setWkDt("2021/04/17-04/21");

        AdsContinuityWkCount adsContinuityWkCount13 = new AdsContinuityWkCount();
        adsContinuityWkCount13.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount13.setDt("2021/04/19");
        adsContinuityWkCount13.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount13.setWkDt("2021/04/17-04/21");

        AdsContinuityWkCount adsContinuityWkCount14 = new AdsContinuityWkCount();
        adsContinuityWkCount14.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount14.setDt("2021/04/20");
        adsContinuityWkCount14.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount14.setWkDt("2021/04/17-04/21");

        AdsContinuityWkCount adsContinuityWkCount15 = new AdsContinuityWkCount();
        adsContinuityWkCount15.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount15.setDt("2021/04/21");
        adsContinuityWkCount15.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityWkCount15.setWkDt("2021/04/17-04/21");

        threeWkActivityList.add(adsContinuityWkCount11);
        threeWkActivityList.add(adsContinuityWkCount12);
        threeWkActivityList.add(adsContinuityWkCount13);
        threeWkActivityList.add(adsContinuityWkCount14);
        threeWkActivityList.add(adsContinuityWkCount15);

        //5、获取最近7天连续3天活跃的用户活跃数
        ArrayList<AdsContinuityUvCount> sevenDayActivityList = new ArrayList<>();
        AdsContinuityUvCount adsContinuityUvCount1 = new AdsContinuityUvCount();
        adsContinuityUvCount1.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityUvCount1.setDt("2021/04/15");
        adsContinuityUvCount1.setWkDt("2021/04/15-04/21");

        AdsContinuityUvCount adsContinuityUvCount2 = new AdsContinuityUvCount();
        adsContinuityUvCount2.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityUvCount2.setDt("2021/04/16");
        adsContinuityUvCount2.setWkDt("2021/04/15-04/21");

        AdsContinuityUvCount adsContinuityUvCount3 = new AdsContinuityUvCount();
        adsContinuityUvCount3.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityUvCount3.setDt("2021/04/17");
        adsContinuityUvCount3.setWkDt("2021/04/15-04/21");

        AdsContinuityUvCount adsContinuityUvCount4 = new AdsContinuityUvCount();
        adsContinuityUvCount4.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityUvCount4.setDt("2021/04/18");
        adsContinuityUvCount4.setWkDt("2021/04/15-04/21");

        AdsContinuityUvCount adsContinuityUvCount5 = new AdsContinuityUvCount();
        adsContinuityUvCount5.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityUvCount5.setDt("2021/04/19");
        adsContinuityUvCount5.setWkDt("2021/04/15-04/21");

        AdsContinuityUvCount adsContinuityUvCount6 = new AdsContinuityUvCount();
        adsContinuityUvCount6.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityUvCount6.setDt("2021/04/20");
        adsContinuityUvCount6.setWkDt("2021/04/15-04/21");

        AdsContinuityUvCount adsContinuityUvCount7 = new AdsContinuityUvCount();
        adsContinuityUvCount7.setContinuityCount((long) (1000+random.nextInt(10000)));
        adsContinuityUvCount7.setDt("2021/04/21");
        adsContinuityUvCount7.setWkDt("2021/04/15-04/21");


        sevenDayActivityList.add(adsContinuityUvCount1);
        sevenDayActivityList.add(adsContinuityUvCount2);
        sevenDayActivityList.add(adsContinuityUvCount3);
        sevenDayActivityList.add(adsContinuityUvCount4);
        sevenDayActivityList.add(adsContinuityUvCount5);
        sevenDayActivityList.add(adsContinuityUvCount6);
        sevenDayActivityList.add(adsContinuityUvCount7);

        ResultEntity<ArrayList<AdsUvCount>> result1 = ResultEntity.successWithData(dayActivityList);
        ResultEntity<ArrayList<AdsUvCount>> result2 = ResultEntity.successWithData(pre5WkActivityList);
        ResultEntity<ArrayList<AdsUvCount>> result3 = ResultEntity.successWithData(pre4MnActivityList);
        ResultEntity<ArrayList<AdsContinuityWkCount>> result4 = ResultEntity.successWithData(threeWkActivityList);
        ResultEntity<ArrayList<AdsContinuityUvCount>> result5 = ResultEntity.successWithData(sevenDayActivityList);

        modelMap.addAttribute("dayActivity",result1);
        modelMap.addAttribute("wkActivity",result2);
        modelMap.addAttribute("mnActivity",result3);
        modelMap.addAttribute("threeWkActivity",result4);
        modelMap.addAttribute("sevenDayActivity",result5);

        return "user_activity";
    }*/

    /**
     * 获取指定日期 dt 最近7天的日活跃数
     * @param dt
     * @return
     */
    @RequestMapping("/activity/day")
    @ResponseBody
    public ResultEntity<ArrayList<AdsUvCount>> getDayActivityByDt(@RequestBody String dt){

        //获取对于 dt 7天前的日期
        String pre7DayDate = DateUtils.dateAdd(dt, -6);

        //获取数据
        ArrayList<AdsUvCount> pre7DayActivityList = adsUvCountService.getByDay(pre7DayDate, 7);

        if (pre7DayActivityList.size() == 0 || pre7DayActivityList.get(0).getDt().compareTo(dt) > 0){
            return ResultEntity.successWithData(new ArrayList<AdsUvCount>());
        }

        ResultEntity<ArrayList<AdsUvCount>> resultEntity = ResultEntity.successWithData(pre7DayActivityList);

        return resultEntity;
    }

    /**
     * 获取指定日期 dt 最近5周的周活跃用户数
     * @param dt
     * @return
     */
    @RequestMapping("/activity/wk")
    @ResponseBody
    public ResultEntity<ArrayList<AdsUvCount>> getWkActivityByDt(@RequestBody String dt){

        //获取 dt 所在周的周一日期
        String monday = DateUtils.getMonday(dt);

        //获取4周前的日期
        String pre4WkDate = DateUtils.dateAdd(monday, -28);

        //获取前4周和当前周的数据
        ArrayList<AdsUvCount> pre4WkActivityList = adsUvCountService.getByWk(pre4WkDate,4);
        ArrayList<AdsUvCount> curWkActivityList = adsUvCountService.getByWk(monday, 1);
        pre4WkActivityList.addAll(curWkActivityList);

        if (pre4WkActivityList.size() == 0 || pre4WkActivityList.get(0).getDt().compareTo(dt) > 0){
            return ResultEntity.successWithData(new ArrayList<AdsUvCount>());
        }

        ResultEntity<ArrayList<AdsUvCount>> result = ResultEntity.successWithData(pre4WkActivityList);

        return result;
    }

    /**
     * 获取指定日期 dt 最近5月的月活跃用户数
     * @param dt
     * @return
     */
    @RequestMapping("/activity/mn")
    @ResponseBody
    public ResultEntity<ArrayList<AdsUvCount>> getMnActivityByDt(@RequestBody String dt){

        //获取4月前的日期
        String pre4MnDate = DateUtils.monthAdd(dt, -4);
        pre4MnDate = pre4MnDate.substring(0,7)+"-01";

        //获取本月开始日期
        String curMn = dt.substring(0, 7) + "-01";

        ArrayList<AdsUvCount> pre4MnActivityList = adsUvCountService.getByMn(pre4MnDate, 4);
        ArrayList<AdsUvCount> curMnActivityList = adsUvCountService.getByDay(curMn, 1);

        pre4MnActivityList.addAll(curMnActivityList);
        if (pre4MnActivityList.size() == 0 ||
                pre4MnActivityList.get(0).getDt().substring(0,7).compareTo(dt.substring(0,7)) > 0){
            return ResultEntity.successWithData(new ArrayList<AdsUvCount>());
        }

        ResultEntity<ArrayList<AdsUvCount>> result = ResultEntity.successWithData(pre4MnActivityList);

        return result;
    }

    /**
     * 获取指定日期 dt 最近7天的连续3周的活跃用户数
     * @param dt
     * @return
     */
    @RequestMapping("/activity/cwk")
    @ResponseBody
    public ResultEntity<ArrayList<AdsContinuityWkCount>> getWkCount(@RequestBody String dt){

        //获取前7天的日期
        String preDate = DateUtils.dateAdd(dt, -6);

        ArrayList<AdsContinuityWkCount> continue3WkActivityList = adsContinuityWkCountService.getByDt(preDate, 7);
        //按活跃数倒序排序
//        Collections.sort(continue3WkActivityList,(a,b)-> (int) (b.getContinuityCount()-a.getContinuityCount()));

        if (continue3WkActivityList.size() == 0 || continue3WkActivityList.get(0).getDt().compareTo(dt) > 0){
            return ResultEntity.successWithData(new ArrayList<AdsContinuityWkCount>());
        }
        ResultEntity<ArrayList<AdsContinuityWkCount>> result = ResultEntity.successWithData(continue3WkActivityList);
        return result;
    }

    /**
     * 获取指定日期 dt 最近7天中连续3天活跃的每天的统计结果
     * @param dt
     * @return
     */
    @RequestMapping("/activity/cday")
    @ResponseBody
    public ResultEntity<ArrayList<AdsContinuityUvCount>> getContinueDayCount(@RequestBody String dt){

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(dt, -6);
        ArrayList<AdsContinuityUvCount> continue3DatActivityList = adsContinuityUvCountService.getByDt(preDate, 7);

        //按活跃数倒序排序
//        Collections.sort(continue3DatActivityList,(a,b)-> (int) (b.getContinuityCount() - a.getContinuityCount()));

        if (continue3DatActivityList.size() == 0 || continue3DatActivityList.get(0).getDt().compareTo(dt)>0){
            return ResultEntity.successWithData(new ArrayList<AdsContinuityUvCount>());
        }
        ResultEntity<ArrayList<AdsContinuityUvCount>> result = ResultEntity.successWithData(continue3DatActivityList);
        return result;
    }

}
