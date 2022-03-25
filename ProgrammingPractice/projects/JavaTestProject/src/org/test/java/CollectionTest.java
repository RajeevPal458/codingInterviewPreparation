package org.test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class CollectionTest {

	public static void main(String[] args) {
		
	    Map<String, String> map= new HashMap<>();
		
		map.put("rajeev", "pal");
		map.put("kamlesh", "lal");
		
		System.out.println(":1:"+map.put("nirmala","nirmala"));
		System.out.println(":1:"+map.put("nirmala","santoshi"));
		System.out.println(":1:"+map.get("rajeev"));
		System.out.println(":2:"+map.get("ra"));
		System.out.println(":3:"+map.remove("ra"));
		System.out.println(":4:"+map.remove("rajeev"));
		
		List<String> list = new ArrayList<>();
		
		list.add("ram");
		list.add("syam");
		list.add(1,"lakshaman");
		//list.remove(0);
		
		System.out.println(":list:"+list);
		System.out.println("list 2 get:"+list.get(0));
		System.out.println("list 3 add:"+list.add("bharat"));
		System.out.println("list 4 add:"+list.add("ram"));
		System.out.println("list 4 add:"+list.remove(0));
		System.out.println("list 4 add:"+list.remove("ram"));
		System.out.println(list);
		System.out.println();
		
		Set<String> set = new HashSet<String>();
		
		set.add("ram");
		set.add("syam");
		set.remove(0);
		
		System.out.println(":set:"+set);
		System.out.println("set 3 add:"+set.add("bharat"));
		System.out.println("set 4 add:"+set.add("ram"));
		System.out.println("set 4 add:"+set.remove(0));
		System.out.println("set 4 add:"+set.remove("ram"));
		System.out.println(set);
		
		//int[] nums = { 2,2,3,3,3,4} ;
		//[2,2,3,3,3,4] ,[8,7,3,8,1,4,10,10,10,2]
		//int nums[] = {8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4};
	
	}
	
	
}

// 30 +16 +4



