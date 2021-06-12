package com.bt.tree.mix;

public class EvaluationOfExpressionTree {
	static class node{
		String info;
		node left,right;
		node(String info){
			this.info=info;
			this.left=this.right=null;
		}
	}
	public static int eval(node root){
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return Integer.parseInt(root.info);
		
		int left=eval(root.left);
		int right=eval(root.right);
		int sum=0;
		switch(root.info){
		
		case "+": sum=left+right;
					break;
		case "-": sum=left-right;
					break;
		
		case "*": sum=left*right;
					break;
		
		case "/": sum=left/right;
					break;
		
		case "%": sum=left%right;
					break;
		default: System.out.println("Operator Not Match"+root.info);
		
		}
		return sum;
	}
	public static void main(String[] args) {
		node root=null;
		root = new node("+");
	    root.left = new node("*");
	    root.left.left = new node("5");
	    root.left.right = new node("4");
	    root.right = new node("-");
	    root.right.left = new node("100");
	    root.right.right = new node("20");
	    System.out.println(eval(root));
	 
	    //delete(root);
	    root=null;
	    root = new node("+");
	    root.left = new node("*");
	    root.left.left = new node("5");
	    root.left.right = new node("4");
	    root.right = new node("-");
	    root.right.left = new node("100");
	    root.right.right = new node("/");
	    root.right.right.left = new node("20");
	    root.right.right.right = new node("2");
	 
	    System.out.println(eval(root));
	}
}
