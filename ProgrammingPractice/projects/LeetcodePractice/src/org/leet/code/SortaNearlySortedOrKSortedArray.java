package org.leet.code;

import java.util.Iterator;
import java.util.PriorityQueue;

// complexity and use cases related to sorting like insertion sort, merge sort, quick sort, etc.
public class SortaNearlySortedOrKSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort1(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
        
	}

	private static void printArray(int[] arr, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
	}

	private static void kSort(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		for(int i=0; i < arr.length ;i++) {
			
			for(int j=i+1;j<=(i+k) ;j++) {
				if(j<arr.length && arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	private static void kSort1(int[] arr, int n, int k)
    {
 
        // min heap
        PriorityQueue<Integer> priorityQueue
            = new PriorityQueue<>();
 
        // add first k + 1 items to the min heap
        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }
 
        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
 
        Iterator<Integer> itr = priorityQueue.iterator();
 
        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }

}
