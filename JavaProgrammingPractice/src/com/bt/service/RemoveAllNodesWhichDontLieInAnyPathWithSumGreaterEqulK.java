package com.bt.service;

import java.util.Stack;

import com.bt.service.RootToLeafPathSumEqualToAGivenNumber.Node;

public class RemoveAllNodesWhichDontLieInAnyPathWithSumGreaterEqulK {
	
	static Node root;
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
	// print the tree in LVR (Inorder traversal) way.
	private static void print(Node root) {
		 if (root != null)
		 {
		     print(root.left);
		     System.out.print(" "+root.data+" ");
		     print(root.right);
		 }
	}
	private static Node pruneUtill(Node root, int k,int sum) {
		/*Base Case*/
		   if (root == null)  return null;
		   /* Update Sum*/
		   sum = sum + (root.data);
		 /* Recursively prune left and right subtrees*/
		   root.left = pruneUtill(root.left, k, sum);
		   root.right = pruneUtill(root.right, k, sum);
		 /* If maximum is smaller than k, and this is a leaf node
		    then it must be deleted*/
		   if (sum < k  && root.left==null && root.right==null)
		   {
		         root = null;
		   }
		   return root;

	}
	private static Node prune(Node root, int k) {
		return pruneUtill(root,k,0);
	}
	
	public static void main(String[] args) {
		RemoveAllNodesWhichDontLieInAnyPathWithSumGreaterEqulK tree=new RemoveAllNodesWhichDontLieInAnyPathWithSumGreaterEqulK();
		
		int k = 45;
	    root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.left.left.left = new Node(8);
	    root.left.left.right = new Node(9);
	    root.left.right.left = new Node(12);
	    root.right.right.left = new Node(10);
	    root.right.right.left.right = new Node(11);
	    root.left.left.right.left = new Node(13);
	    root.left.left.right.right = new Node(14);
	    root.left.left.right.right.left = new Node(15);
	 
	    System.out.println("Tree before truncation\n");
	    print(root);
	    System.out.println();
	    Node prone = prune(root, k); // k is 45
	    if(prone==null)
	    	System.out.println("4");
	    print(prone);
	 
	}
}
/*
 * Consider the following Binary Tree
          1 
      /      \
     2        3
   /   \     /  \
  4     5   6    7
 / \    /       /
8   9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 20, the tree should be changed to following
(Nodes with values 6 and 8 are deleted)
          1 
      /      \
     2        3
   /   \        \
  4     5        7
   \    /       /
    9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 45, the tree should be changed to following.
      1 
    / 
   2   
  / 
 4  
  \   
   9    
    \   
     14 
     /
    15 
 * 
 * 
 */