package org.leet.code;

import java.util.Arrays;

public class Sortanarrayof0s1sand2s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortArray(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void sortArray(int[] arr) {
		// TODO Auto-generated method stub
		int[] temp = new int[3];
		for(int i : arr) {
			temp[i]++;
		}
		int j=0;
		for(int i=0;i<temp.length;i++) {
			while (temp[i]-->0) {
				arr[j++]=i;
			}
		}
	}

}
