package com.ncst.libset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("blue");
        set.add("green");
        set.add("white");

        //Set是无序集合，输出的结果与插入的顺序不一定相同
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //不允许重复，因此插入将失败，但并不会报错
        set.add("green");
        System.out.println("=================");
        iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



    }
}
