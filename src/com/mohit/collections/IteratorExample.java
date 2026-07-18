package com.mohit.collections;

import java.util.*;

public class IteratorExample {

    static void main() {
        List<String> list = new ArrayList<String>();
        list.add("ram");
        list.add("daniel");


        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            if(next.equals("ram")) {
                System.out.println(next);
            }
        }
        // if we modify inside this loop , it will cause ConcurrentModificationException
        // but we can remove inside this loop



        Set<String> set = new HashSet<String>();
        set.add("ram");
        set.add("daniel");

        Iterator<String> iterator1 = set.iterator();
        while(iterator1.hasNext()) {
            String next = iterator1.next();
            if(next.equals("daniel")) {
                System.out.println(next);
            }
        }
    }
}
