package com.bt.arrTree.mix;

import java.util.Comparator;

public class Course implements Comparable<Course>{

	int id;
    String name;
    int price;
   
    public Course(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Course c) {
        return this.id - c.id;
    }
   
    @Override
    public String toString() {
        return String.format("#%d %s@%d ", id, name, price);
    }

    public static class PriceComparator implements Comparator<Course>{
        @Override
        public int compare(Course c1, Course c2) {
            return c1.price - c2.price;
        }       
    }
   
    public static class NameComparator implements Comparator<Course>{
        @Override
        public int compare(Course c1, Course c2) {
            return c1.name.compareTo(c2.name);
        }
    }
}
