package org.algo.strarr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubArrayFromIntArrayWhoseSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] str = {2,7, 3, 4, 9, 12, 1 };
		
		int sum = 13;
		
		subArray(str , str.length, sum);
	}

	private static void subArray1(int[] arr , int len, int maxsum) {
		// TODO Auto-generated method stub
		int sum=0;
		int start = 0;
		int[] temp = new int[len];
		int end=0;
		for(int i=0;i<len;i++) {
			sum += arr[i];
			if(sum<maxsum) {
				temp[end++] = arr[i];
			}else if(sum>maxsum) {
				while(sum > maxsum) {
					sum = sum-temp[start];
					temp[start++]=0; 
				}
				temp[end++] = arr[i];
				if(sum==maxsum) {
					break;
				}
			}else {
				temp[end++] = arr[i];
				break;
			}
		}
		System.out.println(Arrays.toString(temp));
		System.out.print("{");
		for(int i=start;i<end;i++) {
			System.out.print(temp[i]+" ");
		}
		System.out.print("}");
	}
	private static void subArray(int[] arr , int len, int maxsum) {
		int sum = 0;
		int j=-1;
		int i=-1;
		boolean flag= false;
		for(i=0;i<len;i++) {
			sum= arr[i];
			if(sum==maxsum) {
				j=-1;
				break;
			}
			for(j=i+1;j<len;j++) {
				sum +=arr[j];
				if(sum>maxsum) break;
				if(sum==maxsum) {
					flag=true;
					break;
				}
			}
			if(flag) break;
		}
	    if(j==-1) {
	    	System.out.println("{ "+arr[i]+" }");
	    }else {
	    	System.out.print("{");
			for(int start=i;start<=j;start++) {
				System.out.print(arr[start]+" ");
			}
			System.out.print("}");
	    }
	}
	

}









