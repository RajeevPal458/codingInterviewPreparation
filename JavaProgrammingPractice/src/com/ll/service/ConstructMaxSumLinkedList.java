package com.ll.service;

import com.ll.service.LinkedList.Node;

public class ConstructMaxSumLinkedList {
	static LinkList.Node head1;
	static LinkList.Node head2;
	
	public void maxSumLinkedList(LinkList.Node list1,LinkList.Node list2){
		LinkList.Node res=null,res1=null,pre1=list1,pre2=list2,ptr1=list1,ptr2=list2;
		int sum1,sum2;
		
		if(list1==null)
			res=list2;
		if(list2==null)
			res=list1;
		
		while(ptr1!=null||ptr2!=null){
			sum1=0;
			sum2=0;
			while(ptr1!=null&&ptr2!=null&&ptr1.data!=ptr2.data){
				
				if(ptr1.data<ptr2.data){
					sum1 +=ptr1.data;
					ptr1=ptr1.next;
				}
				else{
					sum2 +=ptr2.data;
					ptr2=ptr2.next;
				}
				
			}
			if(ptr1==null)
				while(ptr2!=null){
					sum2 +=ptr2.data;
					ptr2=ptr2.next;
				}
			if(ptr2==null)
				while(ptr1!=null){
					sum1 +=ptr1.data;
					ptr1=ptr1.next;
				}
			if(pre1==list1 && pre2==list2){
					res=(sum1>sum2)?pre1:pre2;
					res1=(sum1>sum2)?ptr1:ptr2;
			}
			else{
					if(res1!=null)
						res1.next=(sum1>sum2)?pre1:pre2;
					res1=(sum1>sum2)?ptr1:ptr2;
			}
			
			if(ptr1!=null)
				pre1=ptr1=ptr1.next;
			if(ptr2!=null)
				pre2=ptr2=ptr2.next;
		}
		while(res!=null){
			System.out.print(res.data+"  ");
			res=res.next;
		}
		System.out.println("...........................3");
	}
	public static void main(String[] args) {
		ConstructMaxSumLinkedList mll=new ConstructMaxSumLinkedList();
		LinkList ll=new LinkList();
		ll.createList();
		head1=ll.head;
		ll.head=null;
		ll.createList();
		head2=ll.head;
		System.out.println();
		ll.printList(head1);
		System.out.println();
		ll.printList(head2);
		System.out.println();
		
		mll.maxSumLinkedList(head1,head2);
		
	}
}
