package com.hnust.hive;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnust.entity.LogData;
import jdk.nashorn.internal.scripts.JO;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.junit.Test;

import java.io.IOException;

/**
 * @Title:公共字段解析
 * @Author: ggh
 * @Date: 2021/4/5 20:58
 */
public class BaseFiledAnalizer extends UDF {

    /**
    *@title:
    *@description:
    *@param: jsonStr:json形式的字符串
    *@param: baseFileds：公共字段列表，按 , 号分割，如：mid,uid,os,sr ...
    *@author:ggh
    *@updateTime: 2021/4/5 21:21
    **/
    public String evaluate(String jsonStr,String baseFields){

        if (jsonStr == null || "".equals(jsonStr) || null == baseFields || "".equals(baseFields)){
            return "";
        }

        ObjectMapper objectMapper = new ObjectMapper();
        StringBuffer sb = new StringBuffer();
        String[] baseFieldsSplit = baseFields.split(",");
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            //获取公共字段
            if (!jsonNode.has("cm")){
                //不含公共字段，不合法数据
                return "";
            }
            JsonNode commonFileds = jsonNode.get("cm");

            //获取事件字段
            if (!jsonNode.has("event")){
                //不含事件字段，不合法
                return "";
            }
            JsonNode event = jsonNode.get("event");
            //获取事件的类型
            JsonNode eventType = event.get("eventType");
            for (int i = 0; i < baseFieldsSplit.length; i++) {
                if (i == baseFields.length()-1){
                    if (commonFileds.has(baseFieldsSplit[i])){
                        sb.append(commonFileds.get(baseFieldsSplit[i]));
                    }
                }else{
                    if (commonFileds.has(baseFieldsSplit[i])){
                        sb.append(commonFileds.get(baseFieldsSplit[i])).append("\t");
                    }
                }
            }

            //获取事件时间
            JsonNode eventTime = event.get("eventTime");

            //拼接字符串，按 \t 分割
            sb.append(eventTime).append("\t");
            sb.append(eventType).append("\t");
            sb.append(event.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }

    /*public static void main(String[] args) {
        String json = "{\"cm\":{\"mid\":\"38544733\",\"uid\":\"983272\",\"sr\":\"5\",\"os\":\"3.2\",\"ar\":\"山东省,烟台市\",\"md\":\"GN152\",\"ba\":\"华为\",\"hw\":\"1080x1920\",\"t\":\"1586016000000\",\"ln\":\"121.16\",\"la\":\"36.7762\",\"url\":\"https://www.baidu.com/ad/\"},\"event\":{\"eventTime\":\"1586016000000\",\"eventType\":\"ad\",\"event\":{\"entry\":\"3\",\"action\":\"2\",\"content\":\"2\",\"detail\":\"200\",\"source\":\"1\",\"behavior\":\"1\"}}}\n";

        String evaluate = new BaseFiledAnalizer().evaluate(json, "mid,uid,sr,os,ar,md,ba,hw,t,ln,la,url");
        System.out.println(evaluate);
    }*/

}
