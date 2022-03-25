package com.bt.string.mix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class SuffixTreeUsingUkkonensAlgorithms_Stage1 {
	static int MAX=26;
	static int front,rear;
	static Node[] queue;
	static Node root=null;
	static class Node{
		String data;
		Node[] child;
		public Node(){
			this.data=null;
			child=new Node[MAX];
			for(int i=0;i<MAX;i++){
				child[i]=null;
			}
		}
	}
	static void initializeQueue(){
		front=-1;
		rear=-1;
		queue=new Node[MAX];
		for(int i=0;i<MAX;i++)
			queue[i]=null;
	}
	static void inQue(Node val){
		if(rear==MAX){
			System.out.println("queue is ovrflow!");
			return;
		}
		if(front==-1)
			front=0;
		rear+=1;
		queue[rear]=val;
	}
	static Node deQueue(){
		if(front==-1||front==rear+1){
			System.out.println("Queue is underflow!");
			return null;
		}
		Node val=queue[front];
		front+=1;
		return val;
	}
	static boolean isEmpty(){
		if(rear==-1||front==rear+1)
			return true;
		else
			return false;
	}
	public static Node newNode(String str){
		Node node=new Node();
		node.data=str;
		return node;
	}
	public static void insert(String string,int i,int j){
		if(string==null){
			return ;
		}
		String str=string.substring(i,j+1);
		Node temp=newNode(str);
		if(i==j){
			    if(root==null){
			    	root=newNode("");
			    	root.child[0]=temp;
			    }
			    else{
			    	for(int k=0;k<MAX;k++)
			    		if(root.child[k]==null)
			    			root.child[k]=temp;
			    }
		}
		else{
			for(int p=0;p<MAX&&root.child[p]!=null;p++){
				Node n=root.child[p];
				String st=n.data;
				if(st.startsWith(str.charAt(i)+""));
				{ int l;
					String s="";
					for(l=1;l<=st.length()&&l<=str.length();l++){
						if(st.substring(0,l).equals(str.substring(0,l)))
							s +=st.substring(0,l);
						else
							break;
					}
					if((s!=null)&&(s.length()==st.length())&&(str.length()>s.length())){
						root.child[p].data=s;
					}
					else if((s!=null)&&(s.length()!=str.length())&&(s.length()!=st.length())){
						root.child[p].data=s;
					    for(int k=0;k<MAX;k++)
					    	if(root.child[p].child[k]==null)
					    	{
					    		root.child[p].child[k]=newNode(st.substring(l,st.length()));
					    		root.child[p].child[k+1]=newNode(str.substring(l,str.length()));
					    	}
					}
				}
				
				
			}
			
			
			
		}
		
	}
	public static void generateSuffix(String str,int len){
		
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				insert(str, j, i);
			}
		}
	}
	private static void printSuffix() {
		boolean status[]=new boolean[MAX];
		for(int i=0;i<MAX;i++)
			status[i]=false;
		inQue(root);
		while(!isEmpty()){
			Node source=deQueue();
			for(int i=0;i<MAX&&source.child[i]!=null;i++){
				System.out.println(source.child[i].data);
				inQue(source.child[i]);
			}
		}
	}
	public static void main(String[] args) {
		String str="xyzx";
		generateSuffix(str,str.length());
		printSuffix();
	}
}
