package com.hnust.hive;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Title:解析事件字段
 * @Author: ggh
 * @Date: 2021/4/5 21:35
 */
public class EventAnalizer extends GenericUDTF {

    //初始化，定义输出的字段和类型
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {

        //存放输出的字段名称
        ArrayList<String> fieldNames = new ArrayList<>();
        //存放输出的各个字段的类型
        ArrayList<ObjectInspector> fieldsOIs = new ArrayList<>();

        fieldNames.add("event_name");
        fieldsOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("event_json");
        fieldsOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames,fieldsOIs);
    }

    /**
    *@title:
    *@description: 解析json形式的事件字段，返回一个数组:[]
    *@param: objects
    *@author:ggh
    *@updateTime: 2021/4/5 21:43
    **/
    @Override
    public void process(Object[] objects) throws HiveException {

        String input = (String) objects[0];
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            //解析事件
            JsonNode jsonNode = objectMapper.readTree(input);
            if (null == jsonNode){
                return;
            }

            String[] result = new String[2];
            //获取事件类型
            JsonNode eventType = jsonNode.get("eventType");
            //获取事件里面的event对应的json串
            JsonNode event = jsonNode.get("event");
            result[0] = eventType.toString();
            result[1] = event.toString();

            //返回
            forward(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() throws HiveException {

    }
}
