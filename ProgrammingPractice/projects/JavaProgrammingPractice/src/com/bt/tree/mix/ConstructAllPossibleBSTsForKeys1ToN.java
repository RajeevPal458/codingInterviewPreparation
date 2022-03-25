package com.bt.tree.mix;
import java.util.Scanner;
import java.util.Vector;

public class ConstructAllPossibleBSTsForKeys1ToN {
	static class Node{
		int key;
		Node left,right;
		Node(int key){
			this.key=key;
			this.left=this.right=null;
		}
	}
	
	public static void proOrderTraversal(Node root){
		if(root==null)
			return ;
		System.out.print(root.key+" ");
		proOrderTraversal(root.left);
		proOrderTraversal(root.right);
	}
	public static Vector<Node> constructAllTrees(int start,int end){
		Vector<Node> list=new Vector<>();
		
		if(start>end){
			list.add(null);
			return list;
		}
		
		for(int i=start;i<=end;i++){
			
			Vector<Node> leftSubTree=constructAllTrees(start, i-1);
			
			Vector<Node> rightSubTree=constructAllTrees(i+1, end);
			
			for(int j=0;j<leftSubTree.size();j++){
				
				Node left=leftSubTree.get(j);
				
				for(int k=0;k<rightSubTree.size();k++){
					Node right=rightSubTree.get(k);
					
					Node node = new Node(i);
					node.left=left;
					node.right=right;
					list.add(node);
				}
			}
		}
		
		return list;
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Vector<Node> allBsts;
		System.out.println("please enter possitive number:");
		int n=Integer.parseInt(sc.nextLine());
		allBsts=constructAllTrees(1,n);
		
		for(int i=0;i<allBsts.size();i++){
			proOrderTraversal(allBsts.get(i));
			System.out.println();
		}
	}
}
