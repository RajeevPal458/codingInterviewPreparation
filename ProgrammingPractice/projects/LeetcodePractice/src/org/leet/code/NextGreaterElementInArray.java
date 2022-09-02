package org.leet.code;

import java.util.Stack;

public class NextGreaterElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {11, 13, 21, 3};
        int n = arr.length;
        printNGE(arr, n);
	}

	static void printNGE1(int arr[], int n)
    {
        int next, i, j;
        for (i=0; i<n; i++)
        {
            next = -1;
            for (j = i+1; j<n; j++)
            {
                if (arr[i] < arr[j])
                {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i]+" -- "+next);
        }
    }
	
	private static void printNGE(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i= arr.length-1; i>=0; i--) {
			
			if(stack.isEmpty()) {
				System.out.println("-1");
				stack.push(arr[i]);
			}else {
				while (!stack.isEmpty() && stack.peek() < arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.peek());
					
				}
				stack.push(arr[i]);
			}
			
			
		}   
		
	}
	
	

}
