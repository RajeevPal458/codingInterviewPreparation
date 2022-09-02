package com.bt.service;

import java.util.Stack;

public class MaximumRectangularAreaInHistogram {
	private static Stack<Integer> stack = new Stack<Integer>();
	
	public static void printstack() {
			System.out.print(stack.toString());
			System.out.println();
	}
	public static int maxAreaRactangle(int[] arr,int len){
		int max=0,maxArea=0;
		int top=0;
		int i;
		for(i=0;i<len;i++){
			//{6, 1, 5, 4, 5, 2, 6};
			//          3     5
			printstack();
			if(stack.isEmpty()||(arr[i]>arr[stack.peek()])){
				stack.push(i);
				System.out.println("PUSH:"+i);
				continue;
			}
			System.out.println("I:"+i+" stack.peek() "+stack.peek());
			while(!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
				top=stack.pop();
				System.out.println("POP:"+top +":i:"+i);
				printstack();
				if(!stack.isEmpty()){
					max=arr[top]*(i-stack.peek()-1);
					System.out.println("Stack Not Empty top:"+top+":i:"+i+"::"+stack.peek()+":max:"+max);
					if(arr[i]>arr[stack.peek()]) i--;
				}
				else{
					max=arr[top]*i;
					System.out.println("Stack Empty:arr[top]:"+arr[top]);
					//stack.push(i);
					i--;
				}
				System.out.println("MAX:"+max);
				if(maxArea<max)
					maxArea=max;
				System.out.println("MAX Area:"+maxArea);
			}
		}
		System.out.println("Out Of Loop:i:"+i);
		while(!stack.isEmpty()){
			top=stack.pop();
			System.out.println("POP:"+top);
			if(!stack.isEmpty()){
				max=arr[top]*(i-stack.peek()-1);
				System.out.println("Stack Not Empty top:"+top+":i:"+i+"::"+stack.peek());
			}
			else{
				max=arr[top]*i;
				System.out.println("Stack Empty");
			}
			if(maxArea<max)
				maxArea=max;
			System.out.println("Max --"+max);
		}
		return maxArea;
	}
	
	
	// The main function to find the maximum rectangular area under given
    // histogram with n bars
    static int getMaxArea(int hist[], int n)
    {
        Stack<Integer> s = new Stack<>();
        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar
        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);
      
            // If this bar is lower than top of stack, then calculate area of rectangle
            // with stack top as the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top
      
                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
      
                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }
      
        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
      
            if (max_area < area_with_top)
                max_area = area_with_top;
        }
      
        return max_area;
 
    }
	public static void main(String[] args) {
		//int[] arr={2,1,2,3,5};
		//int[] arr={6, 1, 5, 4, 5, 2, 6};
		int[] arr ={1,2,3,1,2};
		System.out.println("Ans:-"+getMaxArea(arr,arr.length));;
	}
}



















