package com.bt.string.mix;

import java.util.Arrays;

import javax.sound.midi.SysexMessage;

public class LexicographicRankOfString {

	public static void swap(char[] ptr,int i,int j){
		char temp=ptr[i];
		ptr[i]=ptr[j];
		ptr[j]=temp;
	}
	static int rank=1;
	public static void rank(char[] str,int l,int r){
		int j;
		if(l==r){
			System.out.println(Arrays.toString(str)+"  Rank-"+rank);
			rank++;
		}
		for(j=l;j<=r;j++){
			swap(str,l,j);
			rank(str,l+1,r);
			swap(str,l,j);
		}
	}
	public static void rank1(String str,int i,int k){
		if(i==k){
			System.out.println(Arrays.toString(str.toCharArray())+"  Rank:"+rank);
			
			if(str.equals("cab"))
				System.out.println(".......................................Rank of String:"+str+" : "+rank);
			rank++;
		}
		String str1;
		for(int j=i;j<k;j++){
			str1=str.replace(str.charAt(i),'x').replace(str.charAt(j),str.charAt(i)).replace('x',str.charAt(j));
			rank1(str1,i+1,k);
			str1=str.replace(str.charAt(i),'x').replace(str.charAt(j),str.charAt(i)).replace('x',str.charAt(j));
		}
		
	}
	public static void geratePermutationInLexicoOrderAndPrintRank(){
		
		
	}
	public static int fact(int n){return (n==1)?1:n*fact(n-1);}
	
	public static void findRankDirectaly(char[] arr,int len){
		int trak[]=new int[26];
		int ft=fact(len);
		int rank=1;
		System.out.println(ft);
		
		for(int i=0;i<trak.length;i++)
			trak[i]=0;
		findTrakSmallerchar(arr,trak);
		System.out.println(Arrays.toString(trak));
		for(int i=0;i<arr.length;i++)
		{
			ft=ft/(len-i);
			rank+=trak[arr[i]-'a'-1]*ft;
			updateCount(trak,arr[i]);
			System.out.print(trak[arr[i]-'a']+"*"+ft +" ");
			
		}
		
		System.out.println("="+rank);
	}
	private static void findTrakSmallerchar(char[] arr,int[] count) {
		System.out.println("CountArr1:"+Arrays.toString(count));
		for(int i=0;i<arr.length;i++)
			++count[arr[i]-'a'];
		System.out.println("CountArr2:"+Arrays.toString(count));
		for(int i=1;i<26;i++)
			count[i] +=count[i-1];
		System.out.println("CountArr3:"+Arrays.toString(count));
				
		/*for(int i=0;i<trak.length;i++)
			trak[i]=0;
		int count=0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				
				if(arr[i]>=arr[j]){
					count++;
				}
			}
			trak[arr[i]]=count;
			count=0;
		}		*/
		
	}
	public static void updateCount(int[] count,char ch){
		for(int i=ch-'a';i<26;i++)
			--count[i];
	}
	public static void populateAndIncrementCount(char[] arr,int[] count){
		//System.out.println("CountArr1:"+Arrays.toString(count));
		for(int i=0;i<arr.length;i++)
			++count[arr[i]];
		//System.out.println("CountArr2:"+Arrays.toString(count));
		for(int i=1;i<256;i++)
			count[i] +=count[i-1];
		//System.out.println("CountArr3:"+Arrays.toString(count));
	}
	public static void main(String[] args) {
		char[] pqr={'s','t','r','i','n','g'};
		findRankDirectaly(pqr, pqr.length);
		
		
	}
}

















