package com.bt.tree.mix;
import java.util.Vector;

public class DiameterOfAnNAryTree {
	static final int MAX=26;
	static class Node{
		char data;
		Vector<Node> child;
		Node(char data){
			this.data=data;
			child=new Vector<>();
		}
	}
/*public static int diameter(Node root){
		
		if(root==null)
			return 0;
		int left,right=0,size=root.child.size(),lmax=-1,rmax=-1;
		for(int i=0;i<size;i++){
			left=right;
			right=Math.max(left, depth(root.child.get(i)));
			if(lmax<left)
				lmax=left;
			if(rmax<right)
				rmax=right;
		}
		int maxdiam=0;
		for(int i=0;i<size;i++)
			maxdiam=Math.max(maxdiam, diameter(root.child.get(i)));
		
		return 1+Math.max(lmax+rmax,maxdiam);
	}
	public static int depth(Node  root){
		if(root==null)
			return 0;
		int max=0;
		for(int i=0;i<root.child.size();i++){
			max=Math.max(max, depth(root.child.get(i)));
		}
		return 1+max;
	}*/
	public static int depthOfTree(Node ptr)
	{
	    // Base case
	    if (ptr==null)
	        return 0;
	 
	    int maxdepth = 0;
	 
	    // Check for all children and find
	    // the maximum depth
	    for(int i=0;i<ptr.child.size();i++){
	    	maxdepth=Math.max(maxdepth, depthOfTree(ptr.child.get(i)));
		}
	 
	    return maxdepth + 1;
	}
	 
	// Function to calculate the diameter
	// of the tree
	public static int diameter(Node ptr)
	{
	    // Base case
	    if (ptr==null)
	        return 0;
	 
	    // Find top two highest children
	    int max1 = 0, max2 = 0;
	    for(int i=0;i<ptr.child.size();i++){
	        int h = depthOfTree(ptr.child.get(i));
	        if (h > max1){
	           max2 = max1; max1 = h;
	        }
	        else if(h > max2)
	           max2 = h;
	    }
	 
	    // Iterate over each child for diameter
	    int maxChildDia = 0;
	    for(int i=0;i<ptr.child.size();i++)
	        maxChildDia = Math.max(maxChildDia, diameter(ptr.child.get(i)));
	 
	    return Math.max(maxChildDia, max1 + max2 + 1);
	}
	public static void main(String[] args) {
		
		Node root = new Node('A');
	    root.child.add(new Node('B'));
	    root.child.add(new Node('F'));
	    root.child.add(new Node('D'));
	    root.child.add(new Node('E'));
	    root.child.get(0).child.add(new Node('K'));
	    root.child.get(0).child.add(new Node('J'));
	    root.child.get(2).child.add(new Node('G'));
	    root.child.get(3).child.add(new Node('C'));
	    root.child.get(3).child.add(new Node('H'));
	    root.child.get(3).child.add(new Node('I'));
	    root.child.get(0).child.get(0).child.add(new Node('N'));
	    root.child.get(0).child.get(0).child.add(new Node('M'));
	    root.child.get(3).child.get(2).child.add(new Node('L'));
	 
	    System.out.println("Diameter Of N-Array Tree:"+diameter(root));
	    
	}
}
