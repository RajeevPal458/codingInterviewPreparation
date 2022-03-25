package aa.aaa.aaa.aaaa;


public class DiameterOfBinaryTree {
	
	static class Node{
		int key;
		Node left,right;
		Node(int key){
			this.key=key;
			this.left=this.right=null;
		}
	}
	public static int diameter(Node root){
		
		if(root==null)
			return 0;
		
		int left=depth(root.left);
		int right=depth(root.right);
		
		int ldiameter=diameter(root.left);
		int rdiameter=diameter(root.right);
		
		return 1+Math.max(left+right, Math.max(ldiameter, rdiameter));
	}
	public static int depth(Node  root){
		if(root==null)
			return 0;
		return 1+Math.max(depth(root.left),depth(root.right));
	}
	public static void main(String[] args) {
		  Node root = new Node(1);
		  root.left        = new Node(2);
		  root.right       = new Node(3);
		  root.left.left  = new Node(4);
		  root.left.right = new Node(5);
		 
		  System.out.println("Diameter of the given binary tree is:" +diameter(root));
		  
	}
}
