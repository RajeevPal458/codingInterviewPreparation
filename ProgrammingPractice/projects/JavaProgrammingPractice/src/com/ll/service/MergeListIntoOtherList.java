package com.ll.service;

import java.util.Scanner;

import com.ll.service.LinkList.Node;

public class MergeListIntoOtherList {

	Scanner sc =new Scanner(System.in);
	static LinkList.Node head1;
	static LinkList.Node head2;
	/*
	 * 5 7 17 13 11 
	 * 12 10 2 4 6
	 * */
	LinkList.Node res=null;
	public LinkList.Node insertAtLast(LinkList.Node head,LinkList.Node data){
        if(head==null){
            head=new LinkList.Node(data.data);
            head.next=null;
        }
        else
        {
        	LinkList.Node ptr=head;
            while(ptr.next!=null)
                ptr=ptr.next;
            ptr.next=new LinkList.Node(data.data);
        }
        return head;
    }
	public LinkList.Node mergeAlternate(LinkList.Node list1,LinkList.Node list2){
		LinkList.Node end=list1;
		res=list1;
		if(list2==null)
			return list1;
		else if(end==null)
			return list2;
		else if(end.next==null)
		{
			end=insertAtLast(end,list2);
			mergeAlternate(end,list2.next);
		}
		else{
			end=insertAtLast(end,list2);
			mergeAlternate(list1.next,list2.next);
		}
		return res;
	}
	public static void main(String[] args) {
		MergeListIntoOtherList ll=new MergeListIntoOtherList();
		LinkList l=new LinkList();
		l.createList();
		head1=l.head;
		l.head=null;
		l.createList();
		head2=l.head;
		LinkList.Node res=ll.mergeAlternate(head1, head2);
		l.printList(res);
		
	}
}
