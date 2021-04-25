package com.hnust.controller;

import com.hnust.entity.AdsSearchWordCountDay;
import com.hnust.entity.ResultEntity;
import com.hnust.entity.vo.SearchCountVO;
import com.hnust.service.AdsSearchWordCountDayService;
import com.hnust.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 搜索统计 controller
 */
@Controller
public class SearchCountController {

    @Autowired
    private AdsSearchWordCountDayService adsSearchWordCountDayService;

    @RequestMapping("/search_count.html")
    public String searchCount(ModelMap modelMap){

        //获取当前日期
        String now = DateUtils.getNow("yyyy-MM-dd");

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(now, -6);

        //获取近7天的每天总的搜索次数
        ArrayList<SearchCountVO> searchWordCount = adsSearchWordCountDayService.getByDt(preDate, 7);
        ResultEntity<ArrayList<SearchCountVO>> searchWordCountEntity = ResultEntity.successWithData(searchWordCount);

        //获取当前天的搜索次数最多的词语
        ArrayList<AdsSearchWordCountDay> topSearchWord = adsSearchWordCountDayService.getTopSearchWord(now, 10);
        ResultEntity<ArrayList<AdsSearchWordCountDay>> topSearchWordEntity = ResultEntity.successWithData(topSearchWord);

        modelMap.addAttribute("searchWordCountEntity",searchWordCountEntity);
        modelMap.addAttribute("topSearchWordEntity",topSearchWordEntity);

        return "search_count";
    }

    //根据日期获取当天总的搜索次数
    @RequestMapping("/search_count")
    @ResponseBody
    public ResultEntity<ArrayList<SearchCountVO>> getByDt(@RequestBody String dt){

        //获取7天前的日期
        String preDate = DateUtils.dateAdd(dt, -6);

        ArrayList<SearchCountVO> searchWordCount = adsSearchWordCountDayService.getByDt(preDate, 7);

        ResultEntity<ArrayList<SearchCountVO>> searchWordCountEntity = ResultEntity.successWithData(searchWordCount);

        return searchWordCountEntity;
    }

    //根据日期获取当天搜索次数最多的几个词语
    @RequestMapping("/search_top")
    @ResponseBody
    public ResultEntity<ArrayList<AdsSearchWordCountDay>> getTopSearchWord(@RequestBody String dt){

        ArrayList<AdsSearchWordCountDay> topSearchWord = adsSearchWordCountDayService.getTopSearchWord(dt, 10);

        ResultEntity<ArrayList<AdsSearchWordCountDay>> topSearchWordEntity = ResultEntity.successWithData(topSearchWord);

        return topSearchWordEntity;
    }

}
