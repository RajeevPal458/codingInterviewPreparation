package com.bt.stringarr.mix;

public class PrintAllPossibleWordsFromPhoneDigits {
	static String[] words={"", "", "abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};;
	static int count=0;
	private static void printWordsUtil(int[] num,char[] data,int index, int n){
		if(index==n){
			for(int i=0;i<n;i++){
				System.out.print(data[i]);
			}
			count++;
			System.out.println();
			return; 
		}
		for(int i=0;i<words[num[index]].length();i++){
			data[index]=words[num[index]].charAt(i);
			printWordsUtil(num,data,index+1,n);
			data[index]='0';
			if (num[index] == 0 || num[index] == 1)
	            return;
		}
	}
	private static void printWords(int[] num,int n) {
		
		char[] data=new char[n];
		printWordsUtil(num,data,0,n);
		
	}
	public static void main(String[] args) {
		int number[] = {2, 3, 4};
	    int n = number.length;
	    printWords(number, n);
	    System.out.println("count:"+count);
	}


}
