package com.gfg.practice_mix;

public class SymmetricTreeMirrorImageOfItself {
	static Node root; 
	static class Node{
		Node left;
		int data;
		Node right;
		Node(int data){
			this.left=null;
			this.right=null;
			this.data=data;
		}
		
	}
	public static void main(String[] args) {
		root        = new Node(1);
	    root.left        = new Node(2);
	    root.right       = new Node(2);
	    root.left.left  = new Node(3);
	    root.left.right = new Node(4);
	    root.right.left  = new Node(4);
	    root.right.right = new Node(3);
	    System.out.println(isSymmetric(root));
	    
	    inOrder(root);
	    convertInToMirror(root);
	    System.out.println();
	    inOrder(root);
	    
	}
	private static boolean isSymmetric(Node root) {
		// TODO Auto-generated method stub
		return isMirror(root,root);
	}
	private static boolean isMirror(Node root, Node root1) {
		// TODO Auto-generated method stub
		if(root==null&&root1==null)
			return true;
		
		if(root.data==root1.data)
			return isMirror(root.left, root1.right)&&isMirror(root.right, root1.left);
					
		return false;
	}
	public static void convertInToMirror(Node root){
		if(root==null)
			return;
		Node temp;
		convertInToMirror(root.left);
		convertInToMirror(root.right);
		temp=root.left;
		root.left=root.right;
		root.right=temp;
	}
	private static void inOrder(Node root){
		if(root==null){
			return ;
		}
		inOrder(root.left);
		System.out.print(root.data);
		inOrder(root.right);
	}
}
