package org.algo.sort;

public class CountSort {

	public static void sort(char[] charArr, int range) {
		int[] rangeArr=new int[range];
		
		char[] charoutputArr=new char[charArr.length];
		for (int i = 0; i < rangeArr.length; i++) {
			rangeArr[i] = 0;
		}
		
		for (int i = 0; i < charArr.length; i++) {
			int num =(int)charArr[i];
			rangeArr[num]++;
		}
		PrintArray.printIntArr(rangeArr);
		
		for (int i = 1; i < rangeArr.length; i++) {
			rangeArr[i]= rangeArr[i]+rangeArr[i-1];
		}
		
		PrintArray.printIntArr(rangeArr);
		
		for (int i =0; i < charArr.length; i++) {
			int num =(int)charArr[i];
			charoutputArr[rangeArr[num]-1]= charArr[i];
			rangeArr[num]--;
		} 
		
		/*for (int i = charArr.length-1; i >=0; i--) {
			int num =(int)charArr[i];
			charoutputArr[rangeArr[num]-1]= charArr[i];
			rangeArr[num]--;
		} */
		for (int i = 0; i < charArr.length; i++) {
			charArr[i] = charoutputArr[i];
		}
		
	}

}
