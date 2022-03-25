package com.bt.tree.mix;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class PrintBinaryTreeInVerticalOrderUsingLevelOrderTraversal{

	static class Node{
		int key;
		Node left,right;
		Node(int key){
			this.key=key;
			this.left=null;
			this.right=null;
		}
	}
	public static Node newNode(int key){
		Node temp=new Node(key);
		return temp;
	}
	static class Pair{
		Node node;
		int hd;
		Pair(Node node,int hd){
			this.node=node;
			this.hd=hd;
		}
	}
	static class Queue1{
		static int MAX=100;
		static int front,rear;
		static Pair[] q;
		public Queue1(){
			initializeQueue();
		}
		static void initializeQueue(){
			front=-1;
			rear=-1;
			q=new Pair[MAX];
			for(int i=0;i<MAX;i++)
				q[i]=null;
		}
		static void add(Pair val){
			if(rear==MAX){
				System.out.println("queue is ovrflow!");
				return;
			}
			if(front==-1)
				front=0;
			rear+=1;
			q[rear]=val;
		}
		static Pair poll(){
			if(front==-1||front==rear+1){
				System.out.println("Queue is underflow!");
				return null;
			}
			Pair val=q[front];
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
	private static void printVerticalOrder(Node root) {
			Queue1 q=new Queue1();
			Map<Integer,Vector<Integer>> map=new TreeMap<>();
			Vector<Integer> v=null;
			if(root==null){
				System.out.println("Tree is empty!");
				return ;
			}
			int hd=0;
			q.add(new Pair(root,hd));
			while(!q.isEmpty()){
				
				Pair p=q.poll();
				hd=p.hd;
				if(map.get(hd)==null){
					map.put(hd,new Vector<>());
				}
				map.get(hd).add(p.node.key);
				if(p.node.left!=null){
					q.add(new Pair(p.node.left,p.hd-1));
				}
				if(p.node.right!=null){
					q.add(new Pair(p.node.right,p.hd+1));
				}
			}
			int infinit=9999;
			int prevhd=infinit,hdist;
			Collection<Vector<Integer>> collection=map.values();
			Iterator<Vector<Integer>> it=collection.iterator();
			while(it.hasNext()){
				Vector<Integer> vector=it.next();
				Iterator<Integer> vl=vector.iterator();
				while(vl.hasNext()){
				Integer val=vl.next();
				System.out.print(" "+val.intValue());
				}
				System.out.println();
			}
	}
	public static void main(String[] args) {
		Node root=null;
		root = newNode(1);
	    root.left = newNode(2);
	    root.right = newNode(3);
	    root.left.left = newNode(4);
	    root.left.right = newNode(5);
	    root.right.left = newNode(6);
	    root.right.right = newNode(7);
	    root.right.left.right = newNode(8);
	    root.right.right.right = newNode(9);
	    root.right.right.left= newNode(10);
	    root.right.right.left.right= newNode(11);
	    root.right.right.left.right.right= newNode(12);
	    System.out.println("Vertical order traversal is:");
	    printVerticalOrder(root);
	}
}
