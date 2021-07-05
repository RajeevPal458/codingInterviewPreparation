package org.test.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		
		Map<String, String> map= new HashMap<>();
		
		map.put("rajeev", "pal");
		map.put("kamlesh", "lal");
		
		System.out.println(":1:"+map.get("rajeev"));
		System.out.println(":2:"+map.get("ra"));
		
		List<String> set = new ArrayList<>();
		
		set.add("ram");
		set.add("syam");
		set.set(1,"lakshaman");
		set.remove(0);
		
		System.out.println(":list:"+set);
		System.out.println("list 2 get:"+set.get(0));
	}
}
