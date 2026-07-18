package com.mohit.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class JavaMap {
    public static void main(String[] args) {
        // HashMap, TreeMap

        Map<String,String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        System.out.println(map);

        map.remove("a");
        System.out.println(map);


        map.put("mohit", "good boy");
        String val  = map.get("mohit");
        System.out.println(val);

        String value2 = map.getOrDefault("shyam", "not there");
        System.out.println(value2);
        System.out.println(map.containsKey("shyam"));


        for(String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }

        for(String value : map.values()) {
            System.out.println(value);
        }

        Stream<String> stream = map.values().stream();
        stream.forEach(System.out::println);

        String temp = map.computeIfAbsent("shyam", (key) -> key + "abc");
        System.out.println(temp);
    }
}
