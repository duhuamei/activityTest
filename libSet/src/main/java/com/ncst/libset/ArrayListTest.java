package com.ncst.libset;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>();
        wordList.add("abc");
        wordList.add("ddd");
        wordList.add("sss");

        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
        System.out.println("=========================");
        wordList.remove(0);
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
        wordList.remove("sss");
        System.out.println("=========================");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
        wordList.add(0,"new one");
        System.out.println("=========================");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }

    }
}
