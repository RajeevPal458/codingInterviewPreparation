package org.leet.code;

public class MinTrieLengthAfterInsertingStringArray {

	static class Node{
		Node[] child = new Node[26];
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "aaaa" , "aaaa" , "aaab" , "aabc" , "bbb", "bbcd" } ;
		
		findMinTrieLength(arr);
	}
	
	public static int findMinTrieLength(String[] arr) {
		int result =0;
		
		Node node = new Node();
		
	
		for(int i=0;i<arr.length;i++) {
			createTrie(arr[i] , node);
		}
		
		
		
		return result;
	}

	private static void createTrie(String str, Node node) {
		// TODO Auto-generated method stub
		boolean flag=true;
		--
		for(int i=0; i<str.length() ; i++) {
			int index = str.charAt(i)-'a' ;
			if(node.child[index]==null) {
				node.child[index]  = new Node();
			}else {
				while (node.child[index]!=null) {
					node = node.child[index];
				}
				node.child[index]  = new Node();
			}
			
		}
		
	}

	

}
