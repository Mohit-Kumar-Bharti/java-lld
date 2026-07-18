package com.mohit.collections;

import java.util.*;

public class JavaList {
    //List can initialized by Arraylist or LinkedList or Stack

    static class Car {
        int price;
        String name;

        public Car(int price, String name) {
            this.price = price;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("mohit");

        list.add(0,"ram");
        System.out.println("after adding at index 0 " + list);

        String secondEle = list.get(1);
        System.out.println(secondEle);

        int index1 = secondEle.indexOf("mohit");
        int lastIndex = secondEle.lastIndexOf("mohit");
        System.out.println(index1 +  " " + lastIndex);


        boolean contains = list.contains("mohit");
        System.out.println(contains);


        list.clear();
        System.out.println("list is cleared");


        List<Integer> score = new ArrayList<>();
        for(int  i = 0;i<10;i++) score.add(i);


        Integer[] arr = score.toArray(new Integer[0]);
        for(int i = 0;i<arr.length;i++) System.out.print(arr[i] + " ");

        System.out.println();

        List<Integer> newList = Arrays.asList(arr);
        System.out.println("newList is " + newList);


        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(1000, "bmw"));
        cars.add(new Car(500, "honda"));

        Comparator<Car> comparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.price - o2.price;
            }
        };

        Collections.sort(cars, comparator);
        for(Car car : cars) System.out.println(car.name);

        Collections.sort(cars, (car1, car2) -> car2.price - car1.price);
        for(Car car : cars) System.out.println(car.name);






    }


}
