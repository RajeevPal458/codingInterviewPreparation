package com.bt.arrTree.mix;


public class QuickSort {
	
	Node start,end;
	static class Node{
		
		int data;
		Node next;
		Node prev;
		public Node(int data){
			this.data=data;
			this.next=this.prev=null;
		}
	}
	public Node findLast(Node node){
		while(node.next!=null)
			node=node.next;
		return node;
	}
	public Node part(Node l,Node h){
		int pivot=l.data;
		Node i=l.next;
		Node j=h;
		while(i!=null&&j!=null&&i!=j.next){
			
			while(i.data<pivot &&i!=h)
				i=i.next;
			while(j.data> pivot)
				j=j.prev;
			if(i!=j&&i!=j.next){
				int val=j.data;
				j.data=i.data;
				i.data=val;
			i=i.next;  j=j.next;
			}
			else
				i=i.next;
			
		}
		i.data=j.data;
		j.data=pivot;
		return j;
	}
	public void quickSort(Node node,Node last){
		
		if(node!=null&&last!=null&&node!=last&&node!=last.next){
			
			Node pivloc=part(node,last);
						quickSort(node,pivloc.prev);
						quickSort(pivloc.next,last);
		}
	}
	public void sort(Node node){
		Node last=findLast(node);
		quickSort(node,last);
	}
	public void printListDL(){
        //System.out.println("traverse by using start ");
        Node ptr;
        ptr=start;
        
        
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
    }
	public static void main(String[] args) {
		QuickSort ll=new QuickSort();
		ll.start=new Node(7);
		ll.start.prev=null;
		ll.start.next=new Node(1);
		ll.start.next.prev=ll.start;
		ll.start.next.next=new Node(11);
		ll.start.next.next.prev=ll.start.next;
		ll.start.next.next.next=new Node(9);
		ll.start.next.next.next.prev=ll.start.next.next;
		
		ll.printListDL();
		System.out.println();
		System.out.println("Sorted List..........");
		ll.sort(ll.start);
		//ll.printListDL();
	}
}
