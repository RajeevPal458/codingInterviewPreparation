package org.algo.tree;

public class RootToLeafPathSumEqualToAGivenNumber {

	Node root;
	static class Node 
	{
	    int data;
	    Node left, right;
	  
	    Node(int item) 
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	 /**  boolean haspathSum(Node node, int sum) 
    {
        if (node == null)
            return (sum == 0);
        else
        {
            boolean ans = false;
  
             //otherwise check both subtrees 
            int subsum = sum - node.data;
            if (subsum == 0 && node.left == null && node.right == null)
                return true;
            if (node.left != null)
                ans = ans || haspathSum(node.left, subsum);
            if (node.right != null)
                ans = ans || haspathSum(node.right, subsum);
            return ans;
        }
    }
	 * */
	private boolean haspathSum(Node root, int sum) {

		if(root==null)
			return false;
		sum=sum-root.data;
		if(root.left==null&&root.right==null)
			if(sum==0)
				return true;
			else
				return false;
		return haspathSum(root.left,sum)||haspathSum(root.right,sum);
	}
	 public static void main(String args[]) 
	    {
	        int sum = 21;
	         
	        /* Constructed binary tree is
	              10
	             /  \
	           8     2
	          / \   /
	         3   5 2
	        */
	        RootToLeafPathSumEqualToAGivenNumber tree=new RootToLeafPathSumEqualToAGivenNumber();
	        tree.root = new Node(10);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(2);
	        tree.root.left.left = new Node(3);
	        tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(2);
	  
	        if (tree.haspathSum(tree.root, sum))
	            System.out.println("There is a root to leaf path with sum " + sum);
	        else
	            System.out.println("There is no root to leaf path with sum " + sum);
	    }
	
}
