package com.bt.tree.mix;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class TrieInsertAndSearch {
static int max=26;
	static class Node{
		Node[] child;
		boolean isleaf;
		Node(){
			child=new Node[max];
			 this.isleaf=false;
			for(int i=0;i<max;i++)
				child[i]=null;
		}
	}
	public static void printTrie(Node root,String result){
		if(root.child==null)
			return;
		if(root.isleaf==true){
			System.out.print(result);
			System.out.println();
		}
		for(int i=0;i<max;i++){
			if(root.child[i]!=null){
				printTrie(root.child[i],result+((char)(i+'a'))+"");
			}
		}
		
	}
	public static void deleteNodes(Node root,char[] ch){
		int charlen=ch.length;
		Node ptr=root;
		Stack<Node> stack=new Stack<>();
		int i;
		for(i=0;i<charlen;i++){
			if(ptr.child[ch[i]-'a']==null){
				System.out.println("String Not Exist!");
				break;
			}
			stack.push(ptr);
			ptr=ptr.child[ch[i]-'a'];
		}
		if(i==charlen){
			System.out.println("Deletion found ");
			if(ptr.isleaf){
				while(!stack.isEmpty())
				{	
					boolean isnull=true;
					for (int j = 0; i < max; i++)
						if(ptr.child[i]!=null)
						{  
							if(j==0)
								ptr.isleaf=false;
							isnull=false;
							break;
						}
					if(isnull){
						ptr=stack.pop();
						ptr.child[ch[i-1]-'a']=null;
					}
					else
						break;
				}
			}
		}
	}
	public static String search(Node root,char[] ch){
		String result="";
		int charlen=ch.length;
		Node ptr=root;
		int i;
		for(i=0;i<charlen;i++){
			if(ptr.child[ch[i]-'a']==null)
				break;
			ptr=ptr.child[ch[i]-'a'];
		}
		if(i==charlen)
			result="Found!";
		else
			result="Not Found!";
		return result;
	}
	public static void insert(Node root,char[] ch){
		
		int strlen=ch.length;
		Node ptr=root;
		for(int i=0;i<strlen;i++){
			if(ptr.child[ch[i]-'a']==null){
				ptr.child[ch[i]-'a']=new Node();
			}
			ptr=ptr.child[ch[i]-'a'];
		}
		ptr.isleaf=true;
	}
	public static void main(String[] args) {
		
		 // Input keys (use only 'a' through 'z' and lower case)
	    String keys[] = {"the", "a", "there", "answer", "any",
	                     "by", "bye", "their"};
	 
	    Node root = new Node();
	    // Construct trie
	    for (int i = 0; i < keys.length; i++){
	    	insert(root, keys[i].toCharArray());
	    }	    
	    
	    printTrie(root,"");
	
	    // Search for different keys
	    System.out.println("  the:"+search(root, "the".toCharArray()) );
	    System.out.println("  these:"+ search(root, "these".toCharArray()) );
	    System.out.println("  their:"+ search(root, "their".toCharArray()) );
	    System.out.println("  thaw:"+ search(root, "thaw".toCharArray()));
	    System.out.println();
	    deleteNodes(root,"the".toCharArray());
	    System.out.println("Aftr Deletion!");
	    printTrie(root,"");
	    System.out.println();
	    System.out.println("  the:"+search(root, "the".toCharArray()) );
	    
	}
}
