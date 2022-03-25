package org.leet.code.goldmansachs;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.stream.Collectors;

public class TopMostAccessedURLsWithStatus200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr ={"10.20.31.12 200 http://example.com/index", "10.20.30.12 200 http://example.com/welcome", "10.20.31.11 200 http://example.com/index", "192.168.10.12 200 http://example.com/index", "192.168.15.12 404 http://example.com/nonono",  
				"192.168.17.12 404 http://example.com/nonono"};
		
		
		int n=2;
		String[] ans = findURLS(arr,n,arr.length);
		System.out.println("output:--");
		for(String st:ans)
			System.out.println(st);
	}

	private static String[] findURLS(String[] arr,int n, int len) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> urlCountMap = new HashMap<String, Integer>();
		
		for(String details:arr) {
			String[] starr = details.split(" ");
			
			if(starr.length>2 &&  starr[1].equals("200")) {
				String path = starr[2];
				//String url = starr[2];
				//String[] urlArr = url.split("/");
				//int urlArrlen = urlArr.length;
				//String path =  urlArr[urlArrlen-1];
				System.out.println(":path:"+path);
				if(!urlCountMap.containsKey(path)) {
					urlCountMap.put(path, 1);
				}else {
					urlCountMap.put(path, urlCountMap.get(path)+1);
				}
				
			}
		}
		
		LinkedHashMap<String, Integer> CountSortedMap =urlCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.sorted(Map.Entry.comparingByKey())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldval,newval)->oldval , LinkedHashMap::new));
		
		String[] ans = new String[n];
		int index =0;
		
		
		for(Map.Entry<String, Integer> entry : CountSortedMap.entrySet()) {
			if(index>n) break;else ans[index++]=entry.getKey();
		}
		
		
		
		return ans;
	}

}
