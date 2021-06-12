package com.bt.tree.mix;
public class ImplementaPhoneDirectory {

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
	public static void displayContactsUtil(Node curNode,String prefix){
		if(curNode==null)
			return ;
		if(curNode.isleaf==true){
			System.out.println(":"+prefix);
		}
		for(int i=0;i<max;i++){
			
			if(curNode.child[i]!=null){
				displayContactsUtil(curNode.child[i],prefix+(char)(i+'a'));
			}
		}
	}
	public static void displayContacts(Node root,char[] str){
		
		Node curNode=null;
		Node prevNode=root;
		String prefix="";
		int n=str.length;
		if(root==null){
			System.out.println("No such type data are available!");
			return ;
		}
		
		for(int i=0;i<n;i++){
			
			prefix+=str[i];
			
			curNode=prevNode.child[str[i]-'a'];
			
			if(curNode==null){
				System.out.println("No Results Found for: "+  prefix);
				i++;
				break;
			}
			
			System.out.println("Suggestions based on: "+ prefix+ ": are ");
			 displayContactsUtil(curNode, prefix);
			 
			 prevNode=curNode;
		}
	}
	public static void insert(Node root,char[] arr){
		
		int n=arr.length;
		Node ptr=null;
		ptr=root;
		for(int i=0;i<n;i++){
			if(ptr.child[arr[i]-'a']==null){
				ptr.child[arr[i]-'a']=new Node();
			}
			ptr=ptr.child[arr[i]-'a'];
		}
		ptr.isleaf=true;
	}
	public static void main(String[] args) {
		String keys[] = {"the", "a", "there", "answer", "tany",
                "by", "thbye", "their"};

		Node root = new Node();
		// Construct trie
		for (int i = 0; i < keys.length; i++){
			insert(root, keys[i].toCharArray());
		}	    
		displayContacts(root,"the".toCharArray());
	}
}
