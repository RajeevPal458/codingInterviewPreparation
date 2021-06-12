package com.bt.tree.mix;

public class CountBSTNodesThatLieInAGivenRange {

	static class Node{
		int key;
		Node left,right;
		Node(int key){
			this.key=key;
			this.left=left;
			this.right=right;
		}
	}
	public static int getCount(Node root,int l,int h){
		if(root==null)
			return 0;
		if (root.key == h && root.key == l)
	        return 1;
		if(root.key>=l&&root.key<=h)
			return 1+getCount(root.left,l,h)+getCount(root.right, l, h);
		else if (root.key < l)
	         return getCount(root.right, l, h);
	 
	    // Else recur for left child
	    else return getCount(root.left, l, h);
	}
	public static void main(String[] args) {
		
		Node root        = new Node(10);
	    root.left        = new Node(5);
	    root.right       = new Node(50);
	    root.left.left  = new Node(1);
	    root.right.left = new Node(40);
	    root.right.right = new Node(100);
	    /* Let us constructed BST shown in above example
	          10
	        /    \
	      5       50
	     /       /  \
	    1       40   100   */
	    int l = 5;
	    int h = 45;
	    System.out.println("Count of nodes between "+l+" To "+h+" is "+getCount(root, l, h));
	    
	}
}
