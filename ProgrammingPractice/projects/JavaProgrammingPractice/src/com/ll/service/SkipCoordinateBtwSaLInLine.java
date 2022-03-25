package com.ll.service;

import java.util.Scanner;

import com.ll.service.LinkList.Node;

public class SkipCoordinateBtwSaLInLine {
	Scanner sc =new Scanner(System.in);
	static Node head;
	static class Node{
		int x;
		int y;
		Node next;
		public Node(int x,int y){
			this.x=x;
			this.y=y;
			this.next=null;
		}
	}
	void print(Node st){
		Node ptr=st;
		while(ptr!=null){
			System.out.print("("+ptr.x+","+ptr.y+") ");
			ptr=ptr.next;
		}
	}
	Node skipCoordinate(Node start){
		Node ptr=start,N,NN;
		if(ptr==null||ptr.next==null||ptr.next.next==null)
			return ptr;
		N=ptr.next;
		NN=N.next;
			if(ptr.y==N.y){
				while(N!=null&&NN!=null&&N.y==NN.y){
					ptr.next=NN;
					N=NN;
					NN=NN.next;
				}
			}
			else if(ptr.x==N.x){
				while(NN!=null&&N.x==NN.x){
					ptr.next=NN;
					N=NN;
					NN=NN.next;
					
				}
			}
			else{
				System.out.println("wrong linked list!");
				return start;
			}
			skipCoordinate(ptr.next);
		
	return start;	
	}
	public static void main(String[] args) {
		SkipCoordinateBtwSaLInLine ll=new SkipCoordinateBtwSaLInLine();
		head=new Node(0, 10);
		head.next=new Node(1, 10);
		head.next.next=new Node(5, 10);
		head.next.next.next=new Node(7, 10);
		head.next.next.next.next=new Node(7, 15);
		head.next.next.next.next.next=new Node(20, 15);
		head.next.next.next.next.next.next=new Node(30, 15);
		ll.print(head);
		System.out.println();
		Node res=ll.skipCoordinate(head);
		ll.print(res);
		
		
	}
}
