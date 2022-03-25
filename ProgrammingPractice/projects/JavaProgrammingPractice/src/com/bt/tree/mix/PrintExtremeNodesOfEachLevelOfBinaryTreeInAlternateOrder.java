package com.bt.tree.mix;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class PrintExtremeNodesOfEachLevelOfBinaryTreeInAlternateOrder {

	static class Node{
		int key;
		Node left,right;
		Node(int key){
			this.key=key;
			this.left=null;
			this.right=null;
		}
	}
	static class Queue1{
		static int MAX=100;
		static int front,rear;
		static Node[] q;
		public Queue1(){
			initializeQueue();
		}
		static void initializeQueue(){
			front=-1;
			rear=-1;
			q=new Node[MAX];
			for(int i=0;i<MAX;i++)
				q[i]=null;
		}
		static void add(Node val){
			if(rear==MAX){
				System.out.println("queue is ovrflow!");
				return;
			}
			if(front==-1)
				front=0;
			rear+=1;
			q[rear]=val;
		}
		static Node poll(){
			if(front==-1||front==rear+1){
				System.out.println("Queue is underflow!");
				return null;
			}
			Node val=q[front];
			front+=1;
			return val;
		}
		static int size(){
			
			return rear-front+1;
		}
		static boolean isEmpty(){
			if(rear==-1||front==rear+1)
				return true;
			else
				return false;
		}
	}
	public static Node newNode(int key){
		Node temp=new Node(key);
		return temp;
	}
	public static void printExtremeNodes(Node node){
		if(node==null)
			return;
		int count=0,nextcount=0;
		boolean flage=false;
		Vector<Integer> v=new Vector<>();
		Queue1 que=new Queue1();
		que.add(node);
		
		while(!que.isEmpty()){
			nextcount=que.size();
			count=nextcount;
			while(count--!=0){
				
				Node ptr=que.poll();
				System.out.print(ptr.key+" ");
				if(ptr.left!=null){
					que.add(ptr.left);
				}
				if(ptr.right!=null){
					que.add(ptr.right);
				}
				
				if((count==nextcount-1)&&flage){
					v.add(ptr.key);
				}
				else if((count==0)&&!flage){
					v.add(ptr.key);
				}
			}
			flage=!flage;
			System.out.println();
		}
		
		System.out.println();
		System.out.println(v.toString());
	}
	public static void main(String[] args) {
		// Binary Tree of Height 4
		Node root=null;
	    root = newNode(1);
	 
	    root.left = newNode(2);
	    root.right = newNode(3);
	 
	    root.left.left  = newNode(4);
	    root.left.right = newNode(5);
	    root.right.right = newNode(7);
	 
	    root.left.left.left  = newNode(8);
	    root.left.left.right  = newNode(9);
	    root.left.right.left  = newNode(10);
	    root.left.right.right  = newNode(11);
	    root.right.right.left  = newNode(14);
	    root.right.right.right  = newNode(15);
	 
	    root.left.left.left.left  = newNode(16);
	    root.left.left.left.right  = newNode(17);
	    root.right.right.right.right  = newNode(31);
	 
	    printExtremeNodes(root);
	 
	}
}
