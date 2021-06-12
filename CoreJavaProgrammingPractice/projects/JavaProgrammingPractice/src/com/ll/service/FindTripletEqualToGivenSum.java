package com.ll.service;

import java.util.Arrays;

public class FindTripletEqualToGivenSum {
	static LinkList.Node head1,head2,head3;
	
	
	public void insersionSort(){
		
	}
	int Arr[]=new int[3];
	public int[] findTriplet(LinkList.Node list1,LinkList.Node list2,LinkList.Node list3,int val){
		int sum=0;
		while(list1!=null){
			LinkList.Node ptr2=list2,ptr3=list3;
			while(ptr2!=null&&ptr3!=null){
				sum=list1.data+ptr2.data+ptr3.data;
				if(sum==val){
					Arr[0]=list1.data;
					Arr[1]=ptr2.data;
					Arr[2]=ptr3.data;
					return Arr;
				}
				else if(sum>val){
					ptr2=ptr2.next;
				}
				else{
					ptr3=ptr3.next;
				}
			}
		}
		Arr[0]=0;
		return Arr;
	}
	/*
	 * 3  1 4 2 6
	 * 2 5 8 9 11
	 * 23 18 12 7 4 2 
	 * */
	
	public static void main(String[] args) {
		
		FindTripletEqualToGivenSum ft=new FindTripletEqualToGivenSum();
		LinkList l=new LinkList();
		l.createList();
		head1=l.head;
		l.head=null;
		l.createList();
		head2=l.head;
		l.head=null;
		l.createList();
		head3=l.head;
		int [] res=ft.findTriplet(head1, head2, head3, 30);
		System.out.println(Arrays.toString(res));
		
	}
}
