package com.mohit.collections;

public class JavaHashcode {
    static class Emp {
        String name;
        int age;
        public Emp(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || !(o instanceof Emp)) return false;
            Emp emp = (Emp) o;
            return name.equals(emp.name) && age == emp.age;
        }
    }
    public static void main(String[] args) {
        // equals() method is used to compare if any ele is present in collection

        Emp emp1 = new Emp("shyam", 18);
        Emp emp2 = new Emp("shyam", 18);

        System.out.println(emp1 == emp2);
        // after overriding equals in emp class, we are getting true
        System.out.println(emp1.equals(emp2));



    }
}
