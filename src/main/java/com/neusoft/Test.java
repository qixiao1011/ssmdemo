package com.neusoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("王力宏","盖世英雄");
        map.put("陶喆","RNB天王");

        for (Object key :map.keySet()
             ) {
            System.out.println(key.toString()+":"+map.get(key));
        }
    }
}
