package com.mohit.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

public class JavaSet {



    public static void main(String[] args) {

        // Hashset, Treeset
        Set<String> set = new HashSet<>();
        set.add("c");
        set.add("d");
        set.add("a");

        System.out.println(set);


        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();


        Stream<String> stream = set.stream();
        stream.forEach((ele) -> System.out.println(ele));

        System.out.println(set.contains("c"));




        SortedSet<String> set2 = new TreeSet<>() ;
        set2.add("d");
        set2.add("a");

        System.out.println(set2);
        System.out.println(set2.first());
        System.out.println(set2.last());

        set2.add("c");
        set2.remove("a");
        System.out.println(set2);
    }

}
