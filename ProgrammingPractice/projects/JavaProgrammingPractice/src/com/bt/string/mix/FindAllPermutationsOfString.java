package com.bt.string.mix;

public class FindAllPermutationsOfString {

public static void main(String[] args) {
		
		String str ="abc";
		permutations(str.toCharArray(), 0, str.length());

		System.out.println();
		permutations(str,"");
	}
	
	public static void permutations(String str,String res){
		if(str.isEmpty()) {
			System.out.println(res);
			return;
		}
		boolean[] alph = new boolean[26];
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			String newstr = str.substring(0,i)+str.substring(i+1);
			if(!alph[ch-'a'])
				permutations(newstr,res+ch);
			alph[ch-'a']=true;
		}
	
	}
	

	public static void permutations(char[] arr,int start,int n){
		if(start==n) {
			System.out.println(arr);
			return;
		}
		
		for(int i=start;i<n;i++){
			swap(arr,start,i);
			permutations(arr,start+1,n);
			swap(arr,start,i);
		}
	
	}
	
	public static void swap(char[] arr,int i,int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
