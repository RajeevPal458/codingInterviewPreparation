package org.hacker.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache1<T,R> extends LinkedHashMap<Integer, String>{

	
	
	private static final long serialVersionUID = 1L;
	private final int capacity;
	LruCache1(int capacity){
		super(capacity, 0.75f, true); 
		
		this.capacity=capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
		// TODO Auto-generated method stub
		return size()>capacity;
	}

	 public static void main(String[] args) {
		    LruCache1<Integer, String> cache = new LruCache1<>(3);
		    cache.put(1, "one");
	        cache.put(2, "two");
	        cache.put(3, "three");

	        System.out.println(cache); // Output: {1=one, 2=two, 3=three}
	        
	        // Access some elements
	        cache.get(1);
	        System.out.println(cache); 
	        cache.put(4, "four"); // 2 gets removed because it's the least recently used

	        System.out.println(cache); // Output: {3=three, 1=one, 4=four}
	    }
	
}
