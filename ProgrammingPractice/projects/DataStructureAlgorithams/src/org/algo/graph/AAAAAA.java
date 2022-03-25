package org.algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
//https://www.geeksforgeeks.org/topological-sorting/
//
public class AAAAAA {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(5);
		queue.add(2);
		queue.add(8);
		queue.add(7);
		queue.add(4);
		queue.add(3);
		queue.add(1);
		
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		
		Queue<Integer> priqueue = new PriorityQueue<>();
		
		priqueue.add(5);
		priqueue.add(2);
		priqueue.add(8);
		priqueue.add(7);
		priqueue.add(4);
		priqueue.add(3);
		priqueue.add(1);
		
		System.out.println(priqueue);
		System.out.println(priqueue.peek());
		System.out.println(priqueue.poll());
		
		
		
		List<Integer> list =Collections.synchronizedList(new ArrayList<Integer>());
		Set<Integer> set =Collections.synchronizedSet(new HashSet<Integer>());
		
		Map<Integer,Integer> map =Collections.synchronizedMap(new HashMap<Integer,Integer>());
		Set<Integer> sortedSet =Collections.synchronizedSortedSet(new TreeSet<Integer>());
		Map<Integer,Integer> sortedMap =Collections.synchronizedSortedMap(new TreeMap<Integer,Integer>());
		
		
		
	}
}
