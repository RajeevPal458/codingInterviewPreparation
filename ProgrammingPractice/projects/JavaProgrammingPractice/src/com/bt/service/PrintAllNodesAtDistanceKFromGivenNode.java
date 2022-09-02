package com.bt.service;

public class PrintAllNodesAtDistanceKFromGivenNode {
/*
 * Given a binary tree, a target node in the binary tree, and an integer value k, print all the nodes that are at distance k from the given target node. No parent pointers are available.

BinaryTree
				20
			8      22
		4     12
			10   14
Consider the tree shown in diagram

Input: target = pointer to node with data 8. 
       root = pointer to node with data 20.
       k = 2.
Output : 10 14 22

If target is 14 and k is 3, then output 
should be "4 20"
 * */
	Node root;
	static class Node 
	{
	    int data;
	    Node left, right;
	  
	    Node(int item) 
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	private static int printkdistanceNode(Node root, Node target, int k) {
		
		if(root ==null) return -1;
		
		if(root.data == target.data) {
			printDown(root,k);
			return 0;
		}
		
		int num =printkdistanceNode(root.left, target, k);
		if(num != -1) {
			//target found in left
			if((num+1)==k)
				System.out.println(root.data);
			else 
				printDown(root.right,k-num-2);
			
			return num+1;
		}
			// target not found in left
			int num2 =printkdistanceNode(root.right, target, k);
			
			if(num2 !=0) {
				//target found in left
				if((num2+1)==k)
					System.out.println(root.data);
				else
					printDownLeft(root.left,k-num2-2);
				
				return num2+1;
			}
		return -1;
		
	}
	private static void printDown(Node root, int k) {
		// TODO Auto-generated method stub
		if(root==null || k<0) return ;
		if(k==0) System.out.println(root.data);
		
		printDown(root.left, k-1);
		printDown(root.right, k-1);
	}
	private static void printDownLeft(Node root, int k) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(root==null || k<0) return ;
				if(k==0) System.out.println(root.data);
				
				printDownLeft(root.left, k-1);
				printDownLeft(root.right, k-1);
	}
	public static void main(String[] args) {
		PrintAllNodesAtDistanceKFromGivenNode node = new PrintAllNodesAtDistanceKFromGivenNode();
		
		node.root = new Node(20);
		node.root.left = new Node(8);
		node.root.right = new Node(22);
		node.root.left.left = new Node(4);
		node.root.left.right = new Node(12);
		node.root.left.right.left = new Node(10);
		node.root.left.right.right = new Node(14);
	    Node target = node.root.left.right;
	    int k=2;
	    printkdistanceNode(node.root, target, k);
	}
}
