package com.hnust.controller;

import com.hnust.entity.AdsNewUidCount;
import com.hnust.entity.ResultEntity;
import com.hnust.service.AdsNewUidCountService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 日新增用户数据
 */
@Controller
public class DayAddController {

    @Autowired
    private AdsNewUidCountService adsNewUidCountService;


    /*@RequestMapping("/day_add.html")
    public String test(ModelMap modelMap){

        ArrayList<AdsNewUidCount> result = new ArrayList<>();

        Random random = new Random();
        AdsNewUidCount adsNewUidCount1 = new AdsNewUidCount();
        adsNewUidCount1.setCreateDate("2021-04-16");
        adsNewUidCount1.setNewUidCount((long) (1000+random.nextInt(500)));
        AdsNewUidCount adsNewUidCount2 = new AdsNewUidCount();
        adsNewUidCount2.setCreateDate("2021-04-17");
        adsNewUidCount2.setNewUidCount((long) (1000+random.nextInt(500)));
        AdsNewUidCount adsNewUidCount3 = new AdsNewUidCount();
        adsNewUidCount3.setCreateDate("2021-04-18");
        adsNewUidCount3.setNewUidCount((long) (1000+random.nextInt(500)));
        AdsNewUidCount adsNewUidCount4 = new AdsNewUidCount();
        adsNewUidCount4.setCreateDate("2021-04-19");
        adsNewUidCount4.setNewUidCount((long) (1000+random.nextInt(500)));
        AdsNewUidCount adsNewUidCount5 = new AdsNewUidCount();
        adsNewUidCount5.setCreateDate("2021-04-20");
        adsNewUidCount5.setNewUidCount((long) (1000+random.nextInt(500)));
        AdsNewUidCount adsNewUidCount6 = new AdsNewUidCount();
        adsNewUidCount6.setCreateDate("2021-04-21");
        adsNewUidCount6.setNewUidCount((long) (1000+random.nextInt(500)));
        AdsNewUidCount adsNewUidCount7 = new AdsNewUidCount();
        adsNewUidCount7.setCreateDate("2021-04-22");
        adsNewUidCount7.setNewUidCount((long) (1000+random.nextInt(500)));

        result.add(adsNewUidCount1);
        result.add(adsNewUidCount2);
        result.add(adsNewUidCount3);
        result.add(adsNewUidCount4);
        result.add(adsNewUidCount5);
        result.add(adsNewUidCount6);
        result.add(adsNewUidCount7);

        ResultEntity<ArrayList<AdsNewUidCount>> userAddEntity = ResultEntity.successWithData(result);
        modelMap.addAttribute("userAddEntity",userAddEntity);

        return "day_add";
    }*/

    @RequestMapping("/day_add.html")
    public String dayAdd(ModelMap modelMap){
        //获取当前日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取7天前的日期
        String pre7Days = DateUtils.dateAdd(now, -6);

        //需要获取的结果条数
        int size = 7;

        //获取数据
        ArrayList<AdsNewUidCount> result = adsNewUidCountService.getByDt(pre7Days, size);

        ResultEntity<ArrayList<AdsNewUidCount>> userAddEntity = ResultEntity.successWithData(result);
        modelMap.addAttribute("userAddEntity",userAddEntity);

        return "day_add";
    }


    /**
     * 获取指定日期中7天内新增的用户数
     * @param dt
     * @return
     */
    @RequestMapping("/user_add")
    @ResponseBody
    public ResultEntity<ArrayList<AdsNewUidCount>> getByDt(@RequestBody String dt){

        //获取对于日期 dt 7天前的日期
        String preDate = DateUtils.dateAdd(dt, -6);

        //需要获取的结果数
        int size = 7;
        //获取结果
        ArrayList<AdsNewUidCount> result = adsNewUidCountService.getByDt(preDate, size);

        ResultEntity<ArrayList<AdsNewUidCount>> userAddEntity = ResultEntity.successWithData(result);

        return userAddEntity;
    }



}
