package com.mohit.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtility {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "a", "b", "c", "d", "e", "f", "g", "h");
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);


        Collections.sort(list);
        System.out.println(list);

        int index = Collections.binarySearch(list, "e");
        System.out.println(index);

        int index2 = Collections.binarySearch(list, "i");
        System.out.println(index2);




    }
}
