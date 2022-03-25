package org.algo.tree;

import org.algo.tree.GivenBinaryTreePrintAllRootToLeafPaths.Node;

public class MaxPathSumInBinaryTree {
	//Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

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
	class Res {
	    public int val;
	}
	int findMaxUtil(Node node, Res res)
    {
		if(node==null)
			return 0;
		int l=findMaxUtil(node.left,res);
		int r=findMaxUtil(node.right,res);
		
		int max_single=Math.max(Math.max(l,r)+node.data,node.data);
		
		int max_top= Math.max(max_single,l+r+node.data);
		
		res.val=Math.max(res.val,max_top);
		return max_single;
    }
 
    int findMaxSum() {
        return findMaxSum(root);
    }
 
    // Returns maximum path sum in tree with given root
    int findMaxSum(Node node) {
 
        // Initialize result
        // int res2 = Integer.MIN_VALUE;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
 
        // Compute and return result
        findMaxUtil(node, res);
        return res.val;
    }
	
	public static void main(String[] args) {
		MaxPathSumInBinaryTree tree=new MaxPathSumInBinaryTree();
		
	        tree.root = new Node(10);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(8);
	        tree.root.left.left = new Node(2);
	        tree.root.left.right = new Node(12);
	        tree.root.left.right.left = new Node(5);
	        tree.root.right.right = new Node(2);
	        tree.root.right.right.left = new Node(10);
	        tree.root.right.right.right = new Node(4);
	        System.out.println("maximum path sum is : " +
	                            tree.findMaxSum());
	        /*
	        
	        10
	      2     8
	   2   12       2
	     5        10   4
	                   
	                   */
	}
}
