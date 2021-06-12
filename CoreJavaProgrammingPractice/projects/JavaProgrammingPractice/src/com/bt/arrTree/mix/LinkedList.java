package com.bt.arrTree.mix;
import java.util.Scanner;


public class LinkedList{
	Scanner sc =new Scanner(System.in);
    
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
	public NodeDL partition(NodeDL node){
		NodeDL fast=node,slow=node;
		if(fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		NodeDL temp=slow;
		slow.next=null;
		
		return temp;
	}
	public NodeDL merge(NodeDL first,NodeDL second){
		if(first==null) return second;
		
		if(second==null) return first;
			
		if(first.data<second.data){
			first.next=merge(first.next,second);
			first.next.prev=first;
			first.prev=null;
			return first;
		}
		else{
			second.next=merge(first,second.next);
			second.next.prev=second;
			second.prev=null;
			return second;
		}
		
		
	}
	public NodeDL mergeSort(NodeDL node){
		if(node==null || node.next==null)
			return node;
		NodeDL sec=partition(node);
					mergeSort(node);
					mergeSort(sec);
		return merge(node,sec);
	}
	public void insertAtStartDL(int data){
        if(start==null)
            start=end=new NodeDL(data);
        else
        {
            NodeDL temp=new NodeDL(data);
            start.prev=temp;
            temp.next=start;
            start=temp;
        }
    }
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
            insertAtStartDL(data);
        }
    }
    public void printListDL(){
        System.out.println("traverse by using start ");
        NodeDL ptr;
        ptr=start;
        
        
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println("traverse by using end ");
        ptr=end;
        
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.prev;
        }
    }
/*    public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		ll.start=new LinkedList.NodeDL(7);
		ll.start.prev=null;
		ll.start.next=new LinkedList.NodeDL(1);
		ll.start.next.prev=ll.start;
		ll.start.next.next=new LinkedList.NodeDL(11);
		ll.start.next.next.prev=ll.start.next;
		ll.start.next.next.next=new LinkedList.NodeDL(9);
		ll.start.next.next.next.prev=ll.start.next.next;
		
		ll.printListDL();
		System.out.println("Sorted List..........");
		
		ll.mergeSort(ll.start);
		ll.printListDL();
	
	}
 */   
}
