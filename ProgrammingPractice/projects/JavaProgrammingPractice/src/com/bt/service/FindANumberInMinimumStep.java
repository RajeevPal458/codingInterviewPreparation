package com.bt.service;
public class FindANumberInMinimumStep {
	public static int infinite=999;
	static class Que{
		
		static int MAX=9999999;
		static int front,rear;
		static Number[] queue;
		public Que(){
			initializeQueue();
		}
		static void initializeQueue(){
			front=-1;
			rear=-1;
			queue=new Number[MAX];
			for(int i=0;i<MAX;i++)
				queue[i]=null;
		}
		static void inQue(Number val){
			if(rear==MAX){
				System.out.println("queue is ovrflow!");
				return;
			}
			if(front==-1)
				front=0;
			rear+=1;
			queue[rear]=val;
		}
		static Number deQueue(){
			if(front==-1||front==rear+1){
				System.out.println("Queue is underflow!");
				return null;
			}
			Number val=queue[front];
			front+=1;
			return val;
		}
		static boolean isEmpty(){
			if(rear==-1||front==rear+1)
				return true;
			else
				return false;
		}
	}
	static class Number{
		int num;
		int level;
		public Number(int num,int level){
			this.num=num;
			this.level=level;
		}
	}
	public static void findNumber(int num,int level){
		
		Que que=new Que();
		que.inQue(new Number(0, level));
		while(!que.isEmpty()){
			
			Number val=que.deQueue();
			if(val.num > infinite||val.num < -infinite){
				System.out.println("Number Not Found!");
				break;
			}
			if(val.num==num){
				System.out.println("Number Found At Level!"+(val.level-1)+":"+val.num);
				break;
			}
				que.inQue(new Number(val.num+val.level,val.level+1));
				que.inQue(new Number(val.num-val.level,val.level+1));
		}
	}
	public static void main(String[] args) {
		findNumber(133,1);
	}
}
