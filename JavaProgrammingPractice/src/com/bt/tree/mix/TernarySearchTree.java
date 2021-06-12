package com.bt.tree.mix;
public class TernarySearchTree {

	static class Node{
		char data;
		boolean isleaf;
		Node left,equal,right;
		public Node(char ch){
			this.data=ch;
			this.isleaf=false;
			this.left=this.right=this.equal=null;
		}
	}
	public static void print(Node root){
		System.out.println("sub root:");
		while(root!=null){
			System.out.print(root.data);
			root=root.equal;
		}
		System.out.println();
	}
	public static Node insert(Node root,String str){
		
		if(root==null){
			root =new Node(str.charAt(0));
		}
		
		if(str.charAt(0)<root.data){
			root.left=insert(root.left,str);
		}
		else if(str.charAt(0)>root.data){
			root.right=insert(root.right,str);
		}
		else{
			if(str.length()>1)
				root.equal=insert(root.equal,str.substring(1));
			else{
				root.isleaf=true;
			}
		}
	
		return root;
	}
	
	public static void traverseTST(Node root,String result){
		
		if(root!=null){
			
			traverseTST(root.left,result);
			result=result+root.data;
			if(root.isleaf){
				System.out.println(result);
			}
			traverseTST(root.equal,result);
		
			traverseTST(root.right,result);
		}
	}
	public static void main(String[] args) {

		 // Input keys (use only 'a' through 'z' and lower case)
	    String keys[] = {"the", "a", "there", "answer", "any",
	                     "by", "bye", "their"};
	 
	    Node root =null;
	    // Construct trie
	    for (int i = 0; i < keys.length; i++){
	    	
	        root=insert(root,keys[i]);
	       // traverseTST(root,"");
	    }
	    /*System.out.print(root.data);
    	System.out.print(root.equal.data);
    	System.out.print(root.equal.equal.data);
    	System.out.println();
    	System.out.print(root.left.data);
    	System.out.println();
    	System.out.print(root.data);
    	System.out.print(root.equal.data);
    	System.out.print(root.equal.equal.data);
    	System.out.print(root.equal.equal.equal.data);
    	System.out.print(root.equal.equal.equal.equal.data);
    	System.out.println();
    	System.out.print(root.data);
    	System.out.print(root.equal.data);
    	System.out.print(root.equal.equal.data);
    	System.out.print(root.equal.equal.equal.left.data);
    	System.out.print(root.equal.equal.equal.left.equal.data);
    	System.out.println();
    	System.out.print(root.left.data);
    	System.out.print(root.left.equal.data);
    	System.out.print(root.left.equal.equal.data);
    	System.out.print(root.left.equal.equal.equal.data);
    	System.out.print(root.left.equal.equal.equal.equal.data);
    	System.out.print(root.left.equal.equal.equal.equal.equal.data);*/
    	System.out.println();
    	
	    System.out.println("Following is traversal of ternary search tree\n");
	    traverseTST(root,"");
	    /*
	    // Search for different keys
	    System.out.println("  the:"+search(root, "the".toCharArray()) );
	    System.out.println("  these:"+ search(root, "these".toCharArray()) );
	    System.out.println("  their:"+ search(root, "their".toCharArray()) );
	    System.out.println("  thaw:"+ search(root, "thaw".toCharArray()));
	    deleteNodes(root,"the".toCharArray());
	    System.out.println("  the:"+search(root, "the".toCharArray()) );
	    */
	    
	}
}
