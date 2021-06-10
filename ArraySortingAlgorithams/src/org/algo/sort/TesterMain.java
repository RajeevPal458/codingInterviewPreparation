package org.algo.sort;

public class TesterMain {

	public static void main(String[] args) {
		int[] arr= {3,2,5,4,7,6,9,1,8};
		BubbleSort.sort(arr);
		PrintArray.printIntArr(arr);
		
		SelectionSort.sort(arr);
		PrintArray.printIntArr(arr);

		InsertionSort.sort(arr);
		PrintArray.printIntArr(arr);
	}

}
