package com.ll.service;

import java.util.Scanner;

import com.ll.service.LinkedList.Node;

public class UnRolledLinkedList {
	Scanner sc=new Scanner(System.in);
	Node head;
	static class Node{
		int numElement;
		int arr[];
		Node next;
		public Node(int arr[],int numElement){
			this.numElement=numElement;
			this.arr=arr;
			this.next=null;
		}
	}
	Node1 start;
	static class Node1{
		int data;
		Node1 next;
		public Node1(int data){
			this.data=data;
			this.next=null;
		}
	}
	public void insertAtLast(int num){
		int arr[]=ElemForANode(num);
        if(head==null){
            head=new Node(arr,num);
            head.next=null;
        }
        else
        {
            Node ptr=head;
            while(ptr.next!=null)
                ptr=ptr.next;
            ptr.next=new Node(arr,num);
        }
    }
	
	public int[] ElemForANode(int num){
		int array[]=new int[num];
		for(int i=0;i<num;i++){
			System.out.println("please enter data for a node:");
            int data=Integer.parseInt(sc.next());
            array[i]=data;
		}
		return array;
	} 
	public void createList(){
        System.out.println("enter number of element in UnRooledLinked List ");
        int n=Integer.parseInt(sc.next());
        int m;
        if(n<=0)
            System.out.println("entry of element is wrong !\n");
        else
        for(int i=1;i<=n;i++){
        	System.out.println("How many element you want to insert for node:"+i);
            m=Integer.parseInt(sc.next());
            this.insertAtLast(m);
        }
        
	}
    public void printList(Node head){
        Node ptr;
        ptr=head;
        while(ptr!=null){
        	
        	for(int i=0;i<ptr.numElement;i++)
        		System.out.print(ptr.arr[i]+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }
    ////////////////////////////////////////////////////////////////////
    public void insertAtLastSimple(int data){
        if(start==null){
            start=new Node1(data);
            start.next=null;
        }
        else
        {
            Node1 ptr=start;
            while(ptr.next!=null)
                ptr=ptr.next;
            ptr.next=new Node1(data);
        }
    }
	public void createSimpleList(){
        
        System.out.println("enter number of element in Linked List ");
        int n=Integer.parseInt(sc.next());
        int data;
        if(n<=0)
            System.out.println("entry of element is wrong !\n");
        else
        for(int i=1;i<=n;i++){
            System.out.println("enter data of Node ");
            data=Integer.parseInt(sc.next());
            this.insertAtLastSimple(data);
        }
    }
    public void printListSimple(Node1 head){
        Node1 ptr;
        ptr=head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }
    //////////////////////////////////////////////////////////////////////
    //Subtract Two Numbers represented as Linked Lists...............
    public int length(Node1 list){
    	int count=0;
    	while(list!=null){
    		count++;
    		list=list.next;
    	}
    	return count;
    }
    public Node1 findSmaller(Node1 first1,Node1 second1){
    	Node1 first=first1,second=second1;
    	Node1 res=null;
    	if(length(first)>length(second))
    		res=second1;
    	else if(length(first)<length(second))
    		res=first1;
    	else{
    		while(first!=null&&second!=null){
    			if(first.data<second.data)
    				res=first1;
    			else
    				res=second1;
    		}
    	}
    	return res;
    }
    public Node1 reverseList(Node1 node){
    	
    	Node1 temp=null,pre=null,sec=node;
    	
    	while(sec!=null){
    		temp=sec.next;
    		sec.next=pre;
    		pre=sec;
    		sec=temp;
    	}
    	return pre;
    }
    public Node1 subtractSmallerFrmLargeList(Node1 first,Node1 second){
    	
    	Node1 small=this.findSmaller(first, second);
    	Node1 larg;
    	if(small==first)
    		larg=second;
    	else
    		larg=first;
    	int borrow=0,s,l;
    	Node1 result=null,ret=null, smallrev=this.reverseList(small),largrev=this.reverseList(larg);
    	Node1 sub;
    	this.printListSimple(smallrev);
    	this.printListSimple(largrev);
    	System.out.print("Small: ");this.printListSimple(small);System.out.print("large: ");this.printListSimple(larg);
    	
    	
    	if(small==null)
    	ret=larg;
    	while(smallrev!=null&&largrev!=null){
    		l=largrev.data-borrow;
    		borrow=0;
    		s=smallrev.data;
    		if(l>=s)
    			sub=new Node1(l-s);
    		else{
    			sub=new Node1(l-s+10);
    			borrow=1;
    		}
    		if(result==null)
				result=ret=sub;
			else
			{
				result.next=sub;
				result=result.next;
			}
    		smallrev=smallrev.next;
    		largrev=largrev.next;
    	}
    	while(largrev!=null){
    		l=largrev.data-borrow;
    		result.next=new Node1(l);
    		borrow=0;
    		result=result.next;
    		largrev=largrev.next;
    	}
    	return this.reverseList(ret);
    	
    }
    /////////////////////////////////////////////////////////////////////////
    //Rearrange a given list such that it consists of alternating minimum maximum elements
    public Node1 merge(Node1 first,Node1 second){
    	Node1 res;
    	if(first==null)
    		return second;
    	if(second==null)
    		return first;
    	if(first.data<second.data){
    		res=first;
    		first.next=merge(first.next,second);
    		
    	}
    	else{
    		res=second;
    		second.next=merge(first, second.next);
    	}
    	return res;
    }
    public Node1 split(Node1 first){
    	Node1 temp, slow=first,fast=first;
    	while(fast.next!=null&&fast.next.next!=null){
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	temp=slow.next;
    	slow.next=null;
    	return temp;
    }
    public Node1 sortListByMergeSort(Node1 node){
    	
    	if(node==null||node.next==null)
    		return node;
    	Node1 sec=split(node);
    	Node1 f=sortListByMergeSort(node);
    	Node1 s=sortListByMergeSort(sec);
    	
    	return merge(f,s);
    }
    public Node1 rearrangeList(Node1 node){
    	if(node==null||node.next==null)
    		return node;
    	int mid=this.length(node)/2;
    	Node1 res=null,_res=null,ptr,_ptr,last,_last;
    	
    	ptr=node;
    	while(mid>1){
    		ptr=ptr.next;
    		mid--;
    	}
    	last=ptr.next;
    	ptr.next=null;
    	ptr=node;
    	System.out.println("last.......");
    	this.printListSimple(last);
    	
    	System.out.println("ptr.......");
    	this.printListSimple(ptr);
    	System.out.println();
    	while(last!=null&&ptr!=null){
    		_last=last.next;
    		_ptr=ptr.next;
    		if(res==null){
    			res=_res=ptr;
    		}
    		else{
    			res.next=ptr;
    			res=res.next;
    		}
    		res.next=last;
			res=res.next;
			ptr=_ptr;
			last=_last;
    	}
    	if(ptr!=null)
    	{
    		res.next=ptr;
    		res=res.next;
    	}
    	if(last!=null)
    	{
    		res.next=last;
    		res=res.next;
    	}
    	res.next=null;
    	return _res;
    }
    //.......................................
    static int sum=0;
    public static  int convert(Node1 list,int i){
    	
    	if(list.next!=null){
    		i=convert(list.next, i);
    	}
    	sum +=list.data * (int)Math.pow(2,i);
    	return i+1;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
    	Node1 first,second;
    	UnRolledLinkedList ll=new UnRolledLinkedList();
    	ll.createSimpleList();
    	System.out.println("Entered List is:......");
    	ll.printListSimple(ll.start);
    	convert(ll.start,0);
    	System.out.println(sum);
    	
	}
	
}
