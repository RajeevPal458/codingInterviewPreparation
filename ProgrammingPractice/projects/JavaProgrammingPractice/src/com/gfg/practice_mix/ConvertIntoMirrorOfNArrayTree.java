package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.gfg.practice_mix.SymmetricTreeMirrorImageOfItself.Node;

public class ConvertIntoMirrorOfNArrayTree {
	private static final int N=26;
	static Node root; 
	static class Node{
		int data;
		List<Node> child;
		Node(int data){
			this.data=data;
			child=new ArrayList<>();
		}
	}
	static int MAX=100;
	static int front,rear;
	static Node[] queue;
	static void initializeQueue(){
		front=-1;
		rear=-1;
		queue=new Node[MAX];
		for(int i=0;i<MAX;i++)
			queue[i]=null;
	}
	static void inQue(Node val){
		if(rear==MAX){
			System.out.println("queue is ovrflow!");
			return;
		}
		if(front==-1)
			front=0;
		rear+=1;
		queue[rear]=val;
	}
	static Node deQueue(){
		if(front==-1||front==rear+1){
			System.out.println("Queue is underflow!");
			return null;
		}
		Node val=queue[front];
		front+=1;
		return val;
	}
	static boolean isEmpty(){
		if(rear==-1||front==rear+1)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		root = new Node(10);
	    root.child.add(new Node(2));
	    root.child.add(new Node(34));
	    root.child.add(new Node(56));
	    root.child.add(new Node(100));
	    root.child.get(1).child.add(new Node(1));
	    root.child.get(3).child.add(new Node(7));
	    root.child.get(3).child.add(new Node(8));
	    root.child.get(3).child.add(new Node(9));
	    initializeQueue();
	    System.out.println("Level order traversal Before Mirroring\n");
	    printNodeLevelWise();
	    System.out.println();
	    mirrorTree(root);
	 
	    System.out.println("Level order traversal After Mirroring\n");
	    printNodeLevelWise();
	}
	private static void mirrorTree(Node root) {
		if(root==null) return ;
		
		int size=root.child.size();
		
		if(size<2) return;
		
		for(int i=0;i<size;i++)
			mirrorTree(root.child.get(i));
		
		Collections.reverse(root.child);
	}
	private static void printNodeLevelWise() {
		if(root==null) return ;
		int size;
		inQue(root);
		while(!isEmpty()){
			
			Node n=deQueue();
			size=n.child.size();
			System.out.print(n.data+" ");
			
			Iterator<Node> list=n.child.iterator();
			while(list.hasNext()){
				inQue(list.next());
			}
		}
	}
}
