package com.hnust.udf;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.io.IOException;

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

            for (int i = 0; i < baseFieldsSplit.length; i++) {
                if (i == baseFields.length()-1){
                    if (commonFileds.has(baseFieldsSplit[i])){
                        String field = commonFileds.get(baseFieldsSplit[i]).toString();

                        sb.append(field.substring(1,field.length()-1));
                    }
                }else{
                    if (commonFileds.has(baseFieldsSplit[i])){
                        String field = commonFileds.get(baseFieldsSplit[i]).toString();
                        sb.append(field.substring(1,field.length()-1)).append("\t");
                    }
                }
            }




            JsonNode event = jsonNode.get("event");
            if (null == event || "null".equals(event.toString())){
                //事件event 为 null
                //获取事件类型，如：https://www.baidu.com/look
                String url = commonFileds.get("url").toString();
                String[] urlSplit = url.substring(1,url.length()-1).split("/");
                String urlType = urlSplit[urlSplit.length - 1];
                if (StringUtils.isBlank(urlType)){
                    //可能url是以 / 结尾的
                    urlType = urlSplit[urlSplit.length-2];
                }

                //
                String time = commonFileds.get("t").toString();
                sb.append(time.substring(1,time.length()-1)).append("\t");
                sb.append(urlType).append("\t");
                sb.append("null");

                return sb.toString();
            }

            String eventType = event.get("eventType").toString();

            //获取事件时间
            String eventTime = event.get("eventTime").toString();

            //拼接字符串，按 \t 分割
            sb.append(eventTime.substring(1,eventTime.length()-1)).append("\t");
            sb.append(eventType.substring(1,eventType.length()-1)).append("\t");
            sb.append(event.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }

    /*public static void main(String[] args) {
        String json = "{\"cm\":{\"mid\":\"39128729\",\"uid\":\"1079763\",\"sr\":\"1\",\"os\":\"7.1.2\",\"ar\":\"山西省,阳泉市\",\"md\":\"S5\",\"ba\":\"锤子\",\"hw\":\"1440x2560\",\"t\":\"1586016159224\",\"network\":\"移动\",\"ln\":\"113.557\",\"la\":\"37.8689\",\"url\":\"https://www.baidu.com/display?hourseId=358616\"},\"event\":{\"eventTime\":\"1586016159224\",\"eventType\":\"display\",\"event\":{\"action\":1,\"hourseId\":\"358616\",\"hourseName\":\"汽车许多\",\"place\":\"7\",\"category\":\"洋房,SOHO,SOHO,叠拼别墅\",\"area\":\"海南省,三亚市\"}}}";
//        String json = "{\"cm\":{\"mid\":\"33351747\",\"uid\":\"262427\",\"sr\":\"5\",\"os\":\"3.2\",\"ar\":\"辽宁省,鞍山市\",\"md\":\"Y35\",\"ba\":\"vivo\",\"hw\":\"1440x2560\",\"t\":\"1586016159224\",\"network\":\"WIFI\",\"ln\":\"122.97\",\"la\":\"41.1198\",\"url\":\"https://www.baidu.com/report/\"},\"event\":null}";

        String evaluate = new BaseFiledAnalizer().evaluate(json, "mid,uid,sr,os,ar,md,ba,hw,t,network,ln,la,url");
        System.out.println(evaluate);
    }
*/
}
