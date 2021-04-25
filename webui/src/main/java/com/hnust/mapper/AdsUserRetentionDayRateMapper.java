package com.hnust.mapper;

import com.hnust.entity.AdsUserRetentionDayRate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * 用户留存率
 */
public interface AdsUserRetentionDayRateMapper {

    @Select("SELECT * FROM ads_user_retention_day_rate;")
    ArrayList<AdsUserRetentionDayRate> queryAll();

    //获取指定日期 dt 和留存天数的数据
    @Select("SELECT * FROM ads_user_retention_day_rate WHERE stat_date>=#{dt} AND retention_day=#{retentionDay} ORDER BY stat_date LIMIT #{size};")
    ArrayList<AdsUserRetentionDayRate> queryByDtAndRententionDay(@Param("dt") String dt,@Param("size") int size,
                                                       @Param("retentionDay") int retentionDay);

}
