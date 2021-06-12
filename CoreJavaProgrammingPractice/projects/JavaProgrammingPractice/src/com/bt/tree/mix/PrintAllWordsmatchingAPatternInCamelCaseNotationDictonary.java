package com.bt.tree.mix;

public class PrintAllWordsmatchingAPatternInCamelCaseNotationDictonary {
	static int max=26;
	static class TrieNode{
		TrieNode[] child;
		boolean isleaf;
		String word;
		TrieNode(){
			isleaf=false;
			word="";
			child=new TrieNode[max];
			for(int i=0;i<max;i++){
				child[i]=null;
			}
		}
	}
	static int maxlen=-1;
	static String maxStr="";
	public static void printAllMatches(TrieNode root){
		
		if(root==null){
			return ;
		}
		if(root.isleaf==true){
			int len=root.word.length();
			if(maxlen<len){
				maxlen=len;
				maxStr=root.word;
			}
			System.out.println(":"+root.word);
		}
		for(int i=0;i<max;i++){
			if(root.child[i]!=null)
				printAllMatches(root.child[i]);
		}
	}
	public static boolean search(TrieNode root, char[] pattern){
		boolean flage=false;
		TrieNode ptr=root;
		int i;
		for(i=0;i<pattern.length;i++){
			
			if(ptr.child[pattern[i]-'A']==null)
				break;
			ptr=ptr.child[pattern[i]-'A'];
		}
		if(i==pattern.length){
			flage=true;
			System.out.println("Match Founds!");
			printAllMatches(ptr);
		}
		System.out.println("MAX String:"+maxStr);
		return flage;
	}
	public static void insert(TrieNode root,char[] ch){
		
		TrieNode ptr=root;
		TrieNode temp=null;
		for(int i=0;i<ch.length;i++){
			if(Character.isLowerCase(ch[i]))
				continue;
			if(ptr.child[ch[i]-'A']==null)
				ptr.child[ch[i]-'A']=new TrieNode();
			ptr=ptr.child[ch[i]-'A'];
		}
		ptr.isleaf=true;
		ptr.word=String.valueOf(ch);
	}
	public static void findAllWords(String[] dict,String pattern){
		
		TrieNode root=new TrieNode();
		for(int i=0;i<dict.length;i++){
			insert(root, dict[i].toCharArray());
		}
		if (!search(root, pattern.toCharArray()))
	        System.out.println("No match found");
		
	}
	public static void main(String[] args) {
		String dict[] = {"Hi", "Hello", "HelloWorld",  "HiTech", "HiGeek", 
		                 "HiTechWorld", "HiTechCity", "HiTechLab"};
		
		String pattern = "HT";
		 
	    findAllWords(dict, pattern);
	}
}
