package org.leet.code;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobberIII obj = new HouseRobberIII();
		TreeNode root=new HouseRobberIII.TreeNode(5);
		root.left = new HouseRobberIII.TreeNode(3);
		root.right = new HouseRobberIII.TreeNode(6);
		root.left.left = new HouseRobberIII.TreeNode(1);
		root.left.right = new HouseRobberIII.TreeNode(4);
		
		root.left.left.right = new HouseRobberIII.TreeNode(2);
		int maxrob = obj.rob(root);
		System.out.println(maxrob);
	}
	 public int rob(TreeNode root) {
	        TreeNode ptr = root;
	        return robering(root , new HashMap<TreeNode,Integer>());
	    }
	    
	    public int robering(TreeNode root ,Map<TreeNode,Integer> dp){
	        if(root==null) return 0;
	        if(root.left==null && root.right==null) return root.val;
	        if(dp.containsKey(root)) return dp.get(root);
	        
	       System.out.println(":root:"+root.val);
	        int leftval =0;
	        int rightval=0;
	        int leftval1 =0;
	        int rightval1=0;
	        int leftRightval =0;
	        if(root.left!=null){
	              leftval1 =   robering(root.left.left,dp)+robering(root.left.right,dp);
	        }
	        if(root.right!=null){
	             rightval1 =  robering(root.right.left,dp)+robering(root.right.right,dp);
	        }
	     
	        leftval = root.val + leftval1+rightval1 ;
	        System.out.println(leftval1+"::"+rightval1+",leftval:"+leftval);
	        
	        leftRightval = robering(root.left,dp) +robering(root.right,dp) ;
	        int max = Math.max(leftval,leftRightval);
	        dp.put(root,max);
	        System.out.println(":leftRightval:"+leftRightval+":max:"+max);
	        return  max;
	    }

}
