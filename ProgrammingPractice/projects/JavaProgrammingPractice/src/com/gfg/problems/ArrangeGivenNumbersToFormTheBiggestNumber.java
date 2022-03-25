package com.gfg.problems;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class ArrangeGivenNumbersToFormTheBiggestNumber {
	public static void main(String[] args) {
		 String[] arr={"54","546","548","60"};
		 TreeSet<String> set=new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String x, String y) {
				// TODO Auto-generated method stub
				x=x+y;
				y=y+x;
				return -x.compareTo(y);
			}
		});
		 for(int i=0;i<arr.length;i++)
				set.add(arr[i]);
		 StringBuffer sb=new StringBuffer();
		 Iterator<String> it=set.iterator();
		 while(it.hasNext()){
				sb.append(it.next());
		 }
			System.out.println(sb.toString());
		    //output should be 
		// 6054854654
		 //6054854654
	}
	
}
