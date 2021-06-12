package com.bt.service;

import java.util.Vector;

import com.bt.service.RemoveAllNodesWhichDontLieInAnyPathWithSumGreaterEqulK.Node;

public class PrintAllThePathsFromRootWithSpecifiedSumInBT{
	
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
	private static void printPaths(Node root, int k) {
		int sum=0;
		Vector<Integer> v=new Vector<>();
		printPathsUtill(root,k,v);
	}
	private static void printPathsUtill(Node root, int k,Vector<Integer> v){
		if(root==null)
			return ;
		v.add(root.data);
		int sum=0;
		for(int i=0;i<v.size();i++)
			sum+=v.get(i);
		if(sum==k)
		{
			for(int i=0;i<v.size();i++)
				System.out.print(" "+v.get(i));
			System.out.println();
		}
		printPathsUtill(root.left,k,v);
		printPathsUtill(root.right,k,v);
		v.remove(v.size()-1);
	}
	public static void main(String[] args) {
		root  = new Node(10);
	    root.left  = new Node(28);
	    root.right = new Node(13);
	 
	    root.right.left   = new Node(14);
	    root.right.right  = new Node(15);
	 
	    root.right.left.left   = new Node(21);
	    root.right.left.right  = new Node(22);
	    root.right.right.left  = new Node(23);
	    root.right.right.right = new Node(24);
	 
	    int sum = 38;
	 
	    printPaths(root, sum);
	}
}
/*
 * 
 * 
 * Input : 
Input : sum = 8, 
        Root of tree
         1
       /   \
     20      3
           /    \
         4       15    
        /  \     /  \
       6    7   8    9           
Output :
Path: 1 3 4

Input : sum = 38,
        Root of tree
          10
       /     \
     28       13
           /     \
         14       15
        /   \     /  \
       21   22   23   24
Output : Path found: 10 28 
        Path found: 10 13 15  
 */