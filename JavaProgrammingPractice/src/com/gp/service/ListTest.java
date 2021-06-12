package com.gp.service;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		
		list.add(0,4);
		list.add(1,2);
		System.out.println(list.toString());
		list.add(0,1);
		list.add(list.size(),5);
		System.out.println(list.toString());
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list.get(0));
		
	}
}
