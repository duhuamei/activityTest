package com.ncst.libset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args){
        HashMap<String ,String> hashMap=new HashMap<String,String>();
        hashMap.put("cat","猫");
        hashMap.put("dog","狗");
        hashMap.put("blue","蓝色");

        //遍历所有的值
        Iterator iterator=hashMap.values().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有的键
        System.out.println("==============");
        iterator=hashMap.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的键值对
        System.out.println("==============");
        Set<Map.Entry<String,String>> entrySet=hashMap.entrySet();
        iterator=entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry= (Map.Entry<String,String>) iterator.next();
            System.out.println(entry.getKey()+ "  "+entry.getValue());
        }
//        for (Map.Entry entry : entrySet) {
//            System.out.println(entry.getKey()+ "  "+entry.getValue());
//        }

        //通过键查找对应的值
        System.out.println("==============");
        String myKey="blue";
        if (hashMap.containsKey(myKey) ) {
            System.out.println(myKey+"的值为："+hashMap.get(myKey));
        }else{
            System.out.println("不存在该键");
        }
    }
}
