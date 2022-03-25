package org.algo.tree;

import org.algo.tree.PrintAllKSumPathsInBinaryTree.Node;

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
	private static void printkdistanceNode(Node root2, Node target, int i) {
		
	}
	public static void main(String[] args) {
		PrintAllNodesAtDistanceKFromGivenNode node=new PrintAllNodesAtDistanceKFromGivenNode();
		
		node.root = new Node(20);
		node.root.left = new Node(8);
		node.root.right = new Node(22);
		node.root.left.left = new Node(4);
		node.root.left.right = new Node(12);
		node.root.left.right.left = new Node(10);
		node.root.left.right.right = new Node(14);
	    Node target = node.root.left.right;
	    printkdistanceNode(node.root, target, 2);
	}
}
