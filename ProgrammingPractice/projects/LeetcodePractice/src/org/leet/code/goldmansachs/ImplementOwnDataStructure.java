package org.leet.code.goldmansachs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.synth.SynthStyleFactory;

public class ImplementOwnDataStructure {
	
	class MapEntry{
		int key;
		String value;
		MapEntry(int key,String value){
			this.key=key;
			this.value=value;
		}
	}
	
	LinkedList<Integer> listkey = new LinkedList<Integer>();
	MapEntry[] hashtable =null;
	boolean flag =true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input= {"add 5 3",
		                 "add 1 2",
		                 "get 5",
		                 "evict",
		                 "get 1",
		                 "remove 5",
		                 "exit"} ;
		String[] result =new ImplementOwnDataStructure().solution(input);
		System.out.println(result);
		
		for(String ans:result) {
			System.out.println(ans);
		}
	}
	public  String[] solution(String[] string) {
        // write your code in Java 8
		int maxKey =0;
		for(String st:string) {
			String[] starr = st.split(" ");
			if(starr.length>=2) {
				int key = Integer.valueOf(starr[1]);
				if(maxKey<key) maxKey = key;
			}
		}
		System.out.println(maxKey);
		
		if(hashtable==null)
			hashtable =new MapEntry[maxKey+1];
		
		List<String> result = new ArrayList<String>();
		
		for(String st:string) {
			String[] starr = st.split(" ");
			
			if(st.contains("add")) {
				
				System.out.println("add operation");
				if(flag) {
					
					listkey.remove(Integer.valueOf(starr[1]));
					listkey.addLast(Integer.valueOf(starr[1]));
					this.add(Integer.valueOf(starr[1]),starr[2]);
					
				}
				
				
			}else if(st.contains("get")) {
				
				System.out.println("get operation");
				listkey.remove(Integer.valueOf(starr[1]));
				listkey.addLast(Integer.valueOf(starr[1]));
				String vl =this.get(Integer.valueOf(starr[1]));
				result.add(vl);
				
			}else if(st.contains("evict")) {
				System.out.println("evict operation");
				
				this.evict();
				
			}else if(st.contains("remove")) {
				System.out.println("remove operation");
				
				String vl =this.remove(Integer.valueOf(starr[1]));
				result.add(vl);
				
			}else if(st.contains("exit")) {
				System.out.println("exit operation");
				flag=false;
				break;
			}
			
		}
		
	   String[] stres = new String[result.size()];
	   int j=0;
	   for(String  s:result) {
		   stres[j++]=s;
	   }
       return stres;
    }
	
	private void evict() {
		// TODO Auto-generated method stub
		int first =listkey.getFirst();
		hashtable[first] =null;
	}
	private String remove(Integer key) {
		// TODO Auto-generated method stub
		String val ="-1";
		
		try {
			MapEntry entry =hashtable[key] ;
			val = entry.value;
			hashtable[key]=null;
		} catch (Exception e) {
			
		}
		
		return val;
	}
	private String get(int key) {
		// TODO Auto-generated method stub evict
		String val ="-1";
		
		try {
			MapEntry entry =hashtable[key] ;
			val = entry.value;
		} catch (Exception e) {
			
		}
		
		return val;
	}
	public void add(int key , String value) {
		// evict  hashtable
		hashtable[key] =new MapEntry(key, value);
		
	} 
	

}
