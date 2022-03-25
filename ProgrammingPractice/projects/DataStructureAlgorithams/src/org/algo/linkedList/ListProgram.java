package org.algo.linkedList;

import java.util.Scanner;

public class ListProgram {
	
	Scanner sc =new Scanner(System.in);
	Node head;
	static class Node{
		int data;
		Node next,prev;
		public Node(int data){
			this.data=data;
			this.next=this.prev=null;
		}
	}
	NodeDL start,end;
	static class NodeDL{
        int data;
        NodeDL prev;
        NodeDL next;
        public NodeDL(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
	public void insertAtStart(int data){
        if(head==null){
            head=new Node(data);
            head.next=null;
        }
        else
        {
            Node temp=new Node(data);
            temp.next=head;
            head=temp;
        }
    }
    public void insertAtLast(int data){
        if(head==null){
            head=new Node(data);
            head.next=null;
        }
        else
        {
            Node ptr=head;
            while(ptr.next!=null)
                ptr=ptr.next;
            ptr.next=new Node(data);
        }
    }
    public void createList(){
        
        System.out.println("enter number of element in Linked List ");
        int n=Integer.parseInt(sc.next());
        int data;
        if(n<=0)
            System.out.println("entry of element is wrong !\n");
        else
        for(int i=1;i<=n;i++){
            System.out.println("enter data of Node ");
            data=Integer.parseInt(sc.next());
            insertAtLast(data);
        }
    }
    public void printList(Node head){
        Node ptr;
        ptr=head;
        
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            
            ptr=ptr.next;
        }
        
        System.out.println();
    }
	//Sublist Search (Search a linked list in another list)
    public boolean searchSubListInOtherList(Node list,Node subList){
    	boolean flage=false;
    	Node _list=list,temp;
    	Node _sublist=subList;
    	int listval,sublistval;
    	while(_list!=null){
    		temp=_list;
    		
    		while(temp!=null&&_sublist!=null){
        		if(temp.data==_sublist.data){
        			temp=temp.next;
        			_sublist=_sublist.next;
        		}
        		else{
        			break;
        		}
        	}
    		if(_sublist==null)
    		{
    			flage=true;
    			break;
    		}
    		else
    		{
    			_sublist=subList;
    			_list=_list.next;
    		}
    	}
    	return flage;
    }
    /*Partitioning a linked list around a given value and keeping the original order
    Input : 1->4->3->2->5->2->3, 
    x = 3
    Output: 1->2->2->3->3->4->5*/
    public Node partitionList(Node node,int k){
    	Node ptr=node;
    	Node lessh=null,lessl=null,equalh=null,equall=null,greaterh=null,greaterl=null;
    	int data;
    	while(ptr!=null){
    		data=ptr.data;
    		if(data<k){
    			if(lessh==null)
    			{
    				lessh=lessl=ptr;
    			}
    			else
    			{
    				lessl.next=ptr;
    				lessl=lessl.next;
    			}
    		}
    		else if(data==k){
    			if(equalh==null)
    			{
    				equalh=equall=ptr;
    			}
    			else
    			{
    				equall.next=ptr;
    				equall=equall.next;
    			}
    		}
    		else{
    			if(greaterh==null)
    			{
    				greaterh=greaterl=ptr;
    			}
    			else
    			{
    				greaterl.next=ptr;
    				greaterl=greaterl.next;
    			}
    		}
    		ptr=ptr.next;
    	}
    	if(greaterl!=null)
    		greaterl.next=null;

    	if(lessh==null){
    		if(equalh==null)
    			return greaterh;
    			equall.next=greaterh;
    			return equalh;
    	}
    	if(equalh==null){
    		lessl.next=greaterh;
    		return lessh;
    	}
    	
    	lessl.next=equalh;
    	equall.next=greaterh;
    	return lessh;
    }
    //..............................................................
    public void insertAtLastDL(int data){
        NodeDL tmp=new NodeDL(data);
        if(start==null)
            start=end=tmp;
        else
        {
            NodeDL ptr=start;
            while(ptr.next!=null)
                ptr=ptr.next;
            tmp.prev=end;
            end=tmp;
            ptr.next=tmp;
        }
    }
    public void createListDL(){
        
        System.out.println("enter number of element in Linked List ");
        int n=Integer.parseInt(sc.next());
        int data;
        if(n<=0)
            System.out.println("entry of element is wrong !\n");
        else
        for(int i=1;i<=n;i++){
            System.out.println("enter data of Node ");
            data=Integer.parseInt(sc.next());
            insertAtLastDL(data);
        }
    }
   /* Find pairs with given sum in doubly linked list
    
    Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
    x = 7
    Output: (6, 1), (5,2)*/
    public void pairWithGivenSumDL(NodeDL node,int x){
    	NodeDL first=node,second;
    	int sum;
    	while(first!=null){
    		
    		second=first.next;
    		while(second!=null){
    			sum=first.data+second.data;
    			if(sum==x){
    				System.out.println("("+first.data+","+second.data+")");
    			}
    			second=second.next;
    		}
    		first=first.next;
    	}
    }
    public NodeDL findLast(NodeDL node){
    	while(node.next!=null)
    		node=node.next;
    	return node;
    }
    public void pairWithGivenSumDL1(NodeDL node,int x){
    	NodeDL first=node,last=findLast(node);
    	int sum;
    	while(first!=last&&last.next!=first){
    		sum=first.data+last.data;
    		if(sum<x){
    			first=first.next;
    		}
    		else if(sum>x){
    			last=last.prev;
    		}
    		else{
    			System.out.println("("+first.data+","+last.data+")");
    			last=last.prev;
    			first=first.next;
    		}
    	}
    	
    }
    //Unrolled Linked List | Set 1 (Introduction)
    
    
    
	public static void main(String args[]){
		NodeDL first,sec;
		ListProgram ll=new ListProgram();
		ll.createListDL();
		ll.pairWithGivenSumDL(ll.start,7);
		
	}
}
