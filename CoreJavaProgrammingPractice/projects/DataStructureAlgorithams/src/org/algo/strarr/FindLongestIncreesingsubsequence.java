package org.algo.strarr;

public class FindLongestIncreesingsubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,-1,0,6,2,3};
		int len =arr.length;
		liss(arr,len);
	}

	private static void liss(int[] arr, int len) {
		// TODO Auto-generated method stub
		int[] temp = new int[len];
		int max=0;
		for(int i=0;i<len;i++)
			temp[i] =1;
		int j=0;
		for(int i=1;i<len;i++) {
			j=0;
			while (j<i) {
				if(arr[i]>arr[j]) {
					if(temp[i]<temp[j]+1) {
						temp[i]=temp[j]+1;
						if(temp[i]>max) max= temp[i];
					}
				}
				j++;
			}
		}
		
		System.out.println("MAX:"+max);
	}

}
