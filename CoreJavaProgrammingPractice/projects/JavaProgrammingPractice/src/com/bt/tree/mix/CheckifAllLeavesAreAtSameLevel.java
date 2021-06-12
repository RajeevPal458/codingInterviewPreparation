package com.bt.tree.mix;

public class CheckifAllLeavesAreAtSameLevel {
	
	static class Lavel{
		int leaf;
		int level;
		Lavel(int leaf,int level){
			this.leaf=leaf;
			this.level=level;
		}
	}
	static Lavel[] arr=new Lavel[20];
	static int count=0;
	static int flage=0;
	static boolean found=true;
	static class Node{
		int key;
		Node left,right;
		Node(int key){
			this.key=key;
			this.left=this.right=null;
		}
	}
	public static void checkUtill(Node root,int level){
		if(root==null){
			return ;
		}
		if(root.left==null&&root.right==null){
			if(flage==0){
				flage=level;
			}
			else if(level!=flage){
					found=false;
			}
			arr[count++]=new Lavel(root.key, level);
			return ;
		}
		checkUtill(root.left,level+1);
		checkUtill(root.right,level+1);
	}
	static class LeafLevel{
		int leaflevel;
	}
	
	public static boolean checkUtill1(Node root,int level,LeafLevel ll){
		if(root==null){
			return true;
		}
		if(root.left==null&&root.right==null){
			
			if(ll.leaflevel==0){
				ll.leaflevel=level;
			}
			return ll.leaflevel==level;
		}
		return checkUtill1(root.left,level+1,ll)&&checkUtill1(root.right,level+1,ll);
		
	}
	
	
	
	
	public static boolean check(Node root){
		LeafLevel ll=new LeafLevel();
		ll.leaflevel=0;
		int level=0;
		return checkUtill1(root, level,ll);
	}
	
	public static void main(String[] args) {
		
		Node root = null;
		root=new Node(12);
		//root.right=new Node(20);
	    root.left = new Node(5);
	    root.left.left = new Node(3);
	    root.left.right = new Node(9);
	    root.left.left.left = new Node(1);
	    root.left.right.left = new Node(1);
	    if (check(root))
	        System.out.println("Leaves are at same level\n");
	    else
	    	System.out.println("Leaves are not at same level\n");
	}
}
/*
 *            12
 *          5   
 * 		  3   9
 * 		1   1
 * 
 * 
 * 
 * 					
 */
					
