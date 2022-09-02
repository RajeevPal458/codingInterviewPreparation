package org.test.java8;

import java.util.ArrayList;
import java.util.List;

public class SumList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);list.add(2);list.add(4);list.add(9);
		
		System.out.println(list.stream().mapToInt(i->i).sum());
		
		System.out.println(list.stream().mapToInt(i->i.intValue()).sum());
		
		System.out.println(list.stream().mapToInt(Integer::intValue).sum());
		
	}
	

}
