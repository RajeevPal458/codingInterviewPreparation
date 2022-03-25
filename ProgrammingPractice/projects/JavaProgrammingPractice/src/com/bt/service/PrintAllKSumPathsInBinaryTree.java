package com.bt.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.bt.service.GivenBinaryTreePrintAllRootToLeafPaths.Node;

public class PrintAllKSumPathsInBinaryTree {
	/*A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k.
	A path can start from any node and end at any node, i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.*/
	/*
	 * Input : k = 5  
        Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   2     6    
                       
Output :
3 2 
3 1 1 
1 3 1 
4 1 
1 -1 4 1 
-1 4 2 
5 
1 -1 5 
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
	static void printVector(Vector<Integer> v, int i)
	{
	    for (int j=i; j<v.size(); j++)
	      System.out.print( v.get(j)+" ");
	    System.out.println();
	}
	private static void printKPath(Node root, int k) {
		Vector<Integer> path=new Vector<>();
		printKPathUtil(root,path , k);
	}
	private static void printKPathUtil(Node root, Vector<Integer> path, int k) {
		if(root==null)
			return ;
		path.add(new Integer(root.data));
		printKPathUtil(root.left,path , k);
		printKPathUtil(root.right,path , k);
		int sum=0;
		for(int i=path.size()-1;i>=0;i--){
			//System.out.println("1");
			sum+=path.get(i);
			if(sum==k)
				printVector(path,i);
		}
		path.remove(new Integer(root.data));
	}
	public static void main(String[] args) {
		PrintAllKSumPathsInBinaryTree node=new PrintAllKSumPathsInBinaryTree();
		node.root = new Node(1);
	    node.root.left = new Node(3);
	    node.root.left.left = new Node(2);
	    node.root.left.right = new Node(1);
	    node.root.left.right.left = new Node(1);
	    node.root.right = new Node(-1);
	    node.root.right.left = new Node(4);
	    node.root.right.left.left = new Node(1);
	    node.root.right.left.right = new Node(2);
	    node.root.right.right = new Node(5);
	    node.root.right.right.right = new Node(2);
	 
	    int k = 5;
	    printKPath(node.root, k);
	    
	    
	}
}
