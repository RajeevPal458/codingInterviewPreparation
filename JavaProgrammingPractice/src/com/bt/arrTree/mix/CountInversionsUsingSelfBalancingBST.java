package com.bt.arrTree.mix;

public class CountInversionsUsingSelfBalancingBST {

	static class Node{
		int key,size,height;
		Node left,right;
	}
	public static int getBalance(Node node){
		if(node==null)
			return 0;
		return (getHeight(node.left)-getHeight(node.right));
	}
	public static int getHeight(Node node){
		if(node==null)
			return 0;
		return (node.height);
	}
	public static int getSize(Node node){
		if(node==null)
			return 0;
		return (node.size);
	}
	public static Node newNode(int key){
		Node temp=new Node();
		temp.height=1;
		temp.size=1;
		temp.key=key;
		temp.left=null;
		temp.right=null;
		return temp;
	}
	public static Node leftRotate(Node node){
		
		Node temp=node.right;
		node.right=temp.left;
		temp.left=node;
		
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		
		temp.height=Math.max(getHeight(temp.left),getHeight(temp.right))+1;
		
		node.size=getSize(node.left)+getSize(node.right)+1;
		temp.size=getSize(temp.left)+getSize(temp.right)+1;
		return temp;
	}
	public static Node rightRotate(Node node){
		Node temp=node.left;
		node.left=temp.right;
		temp.right=node;
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		
		temp.height=Math.max(getHeight(temp.left),getHeight(temp.right))+1;
		
		node.size=getSize(node.left)+getSize(node.right)+1;
		temp.size=getSize(temp.left)+getSize(temp.right)+1;
		return temp;
	}
	public static Node insert(Node node,int key,Result res){
		if(node==null){
			return newNode(key);
		}
		
		if(key<node.key){
			
			node.left=insert(node.left, key, res);
			res.invCount=res.invCount+getSize(node.right)+1;
		}
		else
			node.right=insert(node.right, key, res);
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		node.size=getSize(node.left)+getSize(node.right)+1;
		
		int balance=getBalance(node);
		
		// Left Left Case
	    if (balance > 1 && key < node.left.key)
	        return rightRotate(node);
	 
	    // Right Right Case
	    if (balance < -1 && key > node.right.key)
	        return leftRotate(node);
	 
	    // Left Right Case
	    if (balance > 1 && key > node.left.key)
	    {
	        node.left =  leftRotate(node.left);
	        return rightRotate(node);
	    }
	 
	    // Right Left Case
	    if (balance < -1 && key < node.right.key)
	    {
	        node.right = rightRotate(node.right);
	        return leftRotate(node);
	    }
	    /* return the (unchanged) node pointer */
	    return node;
	}
	static class Result{
		int invCount;
	}
	public static int getInvCount(int[] arr,int n){
		Node root=null;
		Result result=new Result();
		result.invCount=0;
		for (int i=0; i<n; i++){	 
		     // Note that address of result is passed as insert
		     // operation updates result by adding count of elements
		     // greater than arr[i] on left of arr[i]
		     root= insert(root,arr[i],result);
		}
		return result.invCount;
	} 
	public static void main(String[] args) {
		int arr[] = {1,20,6,4,5};
		int n=arr.length;
		
		System.out.println(getInvCount(arr,arr.length));
	}
}
