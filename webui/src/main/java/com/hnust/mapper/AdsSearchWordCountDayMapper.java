package com.hnust.mapper;

import com.hnust.entity.AdsSearchWordCountDay;
import com.hnust.entity.vo.SearchCountVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 搜索次数
 */
public interface AdsSearchWordCountDayMapper {

    @Select("SELECT * FROM ads_search_word_count_day;")
    ArrayList<AdsSearchWordCountDay> queryAll();

    //根据日期获取当天总的搜索次数
    @Select("SELECT dt,SUM(search_word_count) count FROM ads_search_word_count_day GROUP BY dt HAVING dt>=#{dt} LIMIT #{size};")
    ArrayList<SearchCountVO> queryByDt(@Param("dt")String dt,@Param("size")int size);

    //根据日期获取当天搜索次数最多的几个词语
    @Select("SELECT * FROM ads_search_word_count_day WHERE dt=#{dt} ORDER BY search_word_count DESC LIMIT #{size};")
    ArrayList<AdsSearchWordCountDay> getTopSearchWord(@Param("dt")String dt,@Param("size")int size);

}
