package org.test.java8.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxCountList {
	
	public static void main(String[] args) {
		List<Integer> employees = new ArrayList<>();
		employees.add(1);
		employees.add(2);
		employees.add(3);
		employees.add(4);
		
		employees.add(5);
		employees.add(6);
		employees.add(7);
		employees.add(8);
		
		employees.add(9);
		employees.add(10);
		
		
		long count = employees.stream().distinct().count();
		
		int min = employees.stream().min(Comparator.comparing(a->a)).get();
		
		int max = employees.stream().min(Comparator.comparing(a->-a)).get();
		
		System.out.println(":count:"+count+":min:"+min+":max:"+max);
		
		employees.stream().filter(a -> a%2==0).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println();

		employees.stream().map(a -> a+1).collect(Collectors.toList()).forEach(System.out::println);
		
		
	}

}
