package com.lagou.class1_3.work3;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Map<Object, String> studentMap = new HashMap<>();
        studentMap.put(new Student("zhangfei", 18), "北京");
        studentMap.put(new Student("zhaoyun", 39), "上海");
        Set<Object> key = studentMap.keySet();
        for (Object ts:key) {
            System.out.println(ts + "::" + studentMap.get(ts));
        }
        studentMap.forEach((k, v) -> {
            System.out.println(k + "::" + v);
        });
        Set<Map.Entry<Object, String>> entries = studentMap.entrySet();
        for (Map.Entry<Object, String> k : entries) {
            System.out.println(k.getKey() + "::" + k.getValue());
        }
        Iterator<Map.Entry<Object, String>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, String> kv = iterator.next();
            System.out.println(kv.getKey() + "::" + kv.getValue());
        }

    }

}
