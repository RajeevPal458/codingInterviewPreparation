package com.bt.service;

public class MaximumRectangularAreaInHistogram {
	
	static class Stak{
		
		static int MAX=100;
		static int top;
		static int[] stack;
		
		public Stak(){
			initializestack();
		}
		static void initializestack(){
			top=-1;
			stack=new int[MAX];
			for(int i=0;i<MAX;i++)
				stack[i]=0;
		}
		static void push(int val){
			if(top==MAX){
				System.out.println("stack is ovrflow!");
				return;
			}
			top+=1;
			stack[top]=val;
		}
		static int pop(){
			if(top==-1){
				System.out.println("stack is underflow!");
				return -1;
			}
			int val=stack[top];
			top-=1;
			return val;
		}
		static boolean isEmpty(){
			if(top==-1)
				return true;
			else
				return false;
		}
	}
	public static int maxAreaRactangle(int[] arr,int len){
		int max=0,maxArea=0;
		int top=0;
		Stak stack=new Stak();
		int i;
		for(i=0;i<len;i++){
			
			if(stack.isEmpty()||(arr[i]>arr[stack.stack[stack.top]])){
				stack.push(i);
				System.out.println("PUSH:"+i);
				continue;
			}
			System.out.println("I:"+i+" stack.stack[stack.top] "+stack.stack[stack.top]+" stack.stack[stack.top] "+stack.stack[stack.top]);
			while(!stack.isEmpty()&&arr[i]<arr[stack.stack[stack.top]]){
				top=stack.pop();
				System.out.println("POP:"+top);
				if(!stack.isEmpty()){
					max=arr[top]*(i-stack.stack[stack.top]-1);
					System.out.println("Stack Not Empty");
				}
				else{
					max=arr[top]*i;
					System.out.println("Stack Empty:arr[top]:"+arr[top]);
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
				max=arr[top]*(i-stack.stack[stack.top]-1);
				System.out.println("Stack Not Empty");
			}
			else{
				max=arr[top]*i;
				System.out.println("Stack Empty");
			}
			if(maxArea<max)
				maxArea=max;
			System.out.println(max);
		}
		return maxArea;
	}
	public static void main(String[] args) {
		int[] arr={2,1,2,3,5};
		System.out.println(maxAreaRactangle(arr,arr.length));;
	}
}



















