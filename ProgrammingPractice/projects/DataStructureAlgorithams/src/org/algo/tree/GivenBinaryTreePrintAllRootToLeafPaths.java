package org.algo.tree;

import java.util.Arrays;

public class GivenBinaryTreePrintAllRootToLeafPaths {
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
	private void printPaths(Node node) {
		int path[] = new int[4];
        printPathsRecur(node, path, 0);
		
	}
	private void printPathsRecur(Node root, int[] path, int index) {
		 if(root==null)
			 return ;
		 
		 path[index]=root.data;
		 index++;
		 if(root.left==null&&root.right==null){
			 printArray(path,path.length);
			 path[index]=0;
			 return;
		 }
		 
		printPathsRecur(root.left, path, index);
		printPathsRecur(root.right, path,index);
	}
	void printArray(int ints[], int len) 
	 {
	        int i;
	        for (i = 0; i < len; i++) 
	        {
	            System.out.print(ints[i] + " ");
	        }
	        System.out.println("");
	}
	public static void main(String[] args) {
		GivenBinaryTreePrintAllRootToLeafPaths tree=new GivenBinaryTreePrintAllRootToLeafPaths();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
         
        /* Let us test the built tree by printing Insorder traversal */
        tree.printPaths(tree.root);
	}
}
