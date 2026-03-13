package com.mohit.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static void main() {

        List<Integer> nums = Arrays.asList(1,2,33,4,5);

        // sum
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);


        // sorting
        nums.sort((a,b) -> a.compareTo(b));

        System.out.println("after sorting : " + nums);


        // filtering

        List<Integer> list = Arrays.asList(1,2,3,4);

        List<Integer> even = list.stream()
                                .filter(n -> n%2 == 0)
                                .collect(Collectors.toList());

        System.out.println(even);


        // mapping, map() does NOT modify original list.w
        List<String> names = Arrays.asList("mohit","ram");
        List<String> upper = names.stream()
                                    .map(String::toUpperCase)
                                    .collect(Collectors.toList());
        System.out.println(names + " ... " + upper);

        // map to append ram to each string
        List<String> ramAppend = names.stream().map(e -> e + "ram").collect(Collectors.toList());
        System.out.println(ramAppend);



        // reverse sorting
        // -1 and 1 return karne ka mtlb bada chhota, 0 mtlb equal hai a,b comparator me
        List<Integer> toSort = Arrays.asList(2,1,33,22);

        toSort.sort((a,b) -> a > b ? -1 : 1);
        System.out.println(toSort);


    }
}
