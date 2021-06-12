package com.gfg.microsoft;

public class FunctionToCheckIfASinglyLinkedListIsPalindrome {

	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
		
	}
	public static boolean isPelindrome(Node head){
		
		Node slow=head,mid=null,slow_prev=null,fast=head,second=null,first=null;
		
		while(fast!=null&&fast.next!=null){
			
			fast=fast.next.next;
			
			slow_prev=slow;
			slow=slow.next;
		}
		
		if(fast!=null){
			mid=slow;
			slow=slow.next;
		}
		slow_prev.next=null;
		second=slow;
		first=head;
		System.out.println("fist half ");
		printList(first);
		System.out.println("second half before reverse");
		printList(second);
		Node rev_second=reverse(second);
		
		System.out.println("second half before reverse");
		printList(rev_second);
		
		boolean flage=compareLists(first, rev_second);
		System.out.println(flage);
		
		return flage;
	}
	
	public static boolean compareLists(Node first,Node second){
		
		while(second!=null&&first!=null){
			
			if(first.data!=second.data)
				return false;
			first=first.next;
			second=second.next;
		}
		if(second!=null||first!=null)
			return false;
		
		return true;
	}
	public static Node reverse(Node node){
		
		Node first=null,second=node,temp=null;
		
		while(second!=null&&second.next!=null){
			
			temp=second.next;
			second.next=first;
			first=second;
			second=temp;
		}
		if(second!=null&&second.next==null)
			second.next=first;
		
		return second;
	}
	public static void printList(Node node){
		if(node==null)
		{
			System.out.println("List is Empty! ");
			return ;
		}
		else{
			Node ptr=node;
			while(ptr!=null){
				
				System.out.print(ptr.data+" ");
				ptr=ptr.next;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node head=new Node(2);
		
		head.next=new Node(3);
		head.next.next=new Node(4);
		head.next.next.next=new Node(5);
		head.next.next.next.next=new Node(4);
		head.next.next.next.next.next=new Node(3);
		head.next.next.next.next.next.next=new Node(2);
		
		System.out.println("List is before reverse!");
		printList(head);
		//System.out.println("List is after reverse!");
		//printList(reverse(head));
		
		if(isPelindrome(head))
			System.out.println("List is pelindrome!");
		else
			System.out.println("List is not pelindrome!");
	}
}
