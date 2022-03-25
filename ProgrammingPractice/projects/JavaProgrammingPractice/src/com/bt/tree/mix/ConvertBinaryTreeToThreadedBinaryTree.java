package com.bt.tree.mix;

public class ConvertBinaryTreeToThreadedBinaryTree {

	static class Node{
		int key;
		Node left,right;
		boolean isThreaded;
		Node(int key){
			this.key=key;
			this.left=left;
			this.right=right;
			this.isThreaded=false;
		}
	}
	
	public static Node predesessor(Node root){
		Node ptr=root;
		if(root==null)
			return root;
		while(ptr.left!=null)
			ptr=ptr.left;
		return ptr;
	}
	
	public static void inOrder(Node root){
		if(root==null)
			return ;
		Node ptr=predesessor(root);
		
		while(ptr!=null){
			
			System.out.print(ptr.key);
			
			if(ptr.isThreaded){
				ptr=ptr.right;
			}
			else{
				ptr=predesessor(ptr.right);
			}
			
		}
	}
	public static Node createThreaded(Node root){
		
		if(root==null)
			return null;
		if(root.left==null && root.right==null)
			return root;
		if(root.left!=null)
		{
			Node ptr=createThreaded(root.left);
			ptr.right=root;
			ptr.isThreaded=true;
		}	
		
		if(root.right==null)
			return root;
		return createThreaded(root.right);
	}
	public static void main(String[] args) {
		Node root=null;
		root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	 
	   createThreaded(root);
	   System.out.println("Inorder traversal of creeated threaded tree is");
	    inOrder(root);
	}
}
