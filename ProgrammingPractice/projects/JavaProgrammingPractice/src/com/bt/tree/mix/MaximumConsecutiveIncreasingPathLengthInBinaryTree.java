package com.bt.tree.mix;

public class MaximumConsecutiveIncreasingPathLengthInBinaryTree {

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
	private static int maxConsecutivePathLengthUtil(Node root,int count) {
		int maxleft=0,maxright=0,max;
		if((root.left==null)&&(root.right==null)||(root.left.key==root.key+1)&&(root.right.key==root.key+1)){
			return count;
		}
		if((root.left!=null)&&(root.left.key==root.key+1))
			maxleft=maxConsecutivePathLengthUtil(root.left,count+1);
		if((root.right!=null)&&(root.right.key==root.key+1))
			maxright=maxConsecutivePathLengthUtil(root.right,count+1);
		
		max=Math.max(maxleft, maxright);
		return max;
	}
	private static int maxConsecutivePathLength(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		int count=1;
		return maxConsecutivePathLengthUtil(root,count);
	}
	public static void main(String[] args) {
		Node root =null;
		root = newNode(10);
	    root.left = newNode(11);
	    root.right = newNode(9);
	    root.left.left = newNode(13);
	    root.left.right = newNode(12);
	    root.right.left = newNode(13);
	    root.right.right = newNode(8);
	 
	    System.out.println("Maximum Consecutive Increasing Path Length is "+maxConsecutivePathLength(root));
	 
	}

}
