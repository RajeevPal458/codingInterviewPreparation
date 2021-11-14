package org.algo.linkedList;

import java.util.Scanner;

public class LinkList {
	Scanner sc =new Scanner(System.in);
	Node head;
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public Node deleteMNodeAfterN(Node head,int M,int N){
		
		Node curr = head, t;
	    int count;
	 
	    // The main loop that traverses through the whole list
	    while (curr!=null)
	    {
	        // Skip M nodes
	        for (count = 1; count<M && curr!=null; count++)
	            curr = curr.next;
	 
	        // If we reached end of list, then return
	        if (curr ==null)
	            return null;
	 
	        // Start from next node and delete N nodes
	        t = curr.next;
	        for (count = 1; count<=N && t!=null; count++)
	        {
	            Node temp = t;
	            t = t.next;
	        }
	        curr.next = t; // Link the previous list with remaining nodes
	 
	        // Set current pointer for next iteration
	        curr = t;
	    }
	    return head;
	}
	Node reverse1(Node head, int k){
		
		Node first=null,second=head,temp=null,ptr=null;
		
		for(int count=1;count<=k&&second!=null;count++){
			
			temp=second.next;
			second.next=first;
			first=second;
			second=temp;
		}	
		if(second==null)
			return first;
		else{
			ptr=first;
			while(ptr.next!=null){
			ptr=ptr.next;
			}
		}
		ptr.next=reverse1(second,k);
		return first;
	}
	Node reverse(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
 
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverse(next, k);
 
       // prev is now head of input list
       return prev;
    }                   
	Node kAltReverse1(Node node, int k){
		Node current = node;
        Node next = null, prev = null;
        int count = 0;
 
        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
 
        /* 2) Now head points to the kth node.  So change next 
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }
 
        /* 3) We do not want to reverse next k nodes. So move the current 
         pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
 
        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }
 
        /* 5) prev is new head of the input list */
        return prev;
	}
	Node kAltReverse(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;
 
        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
 
        /* 2) Now head points to the kth node.  So change next 
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }
 
        /* 3) We do not want to reverse next k nodes. So move the current 
         pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
 
        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }
 
        /* 5) prev is new head of the input list */
        return prev;
    }
	public Node reverseUtill(Node sec,Node prev){
		Node temp;
		if (sec.next == null) {
            head = sec;
            sec.next = prev;
            return null;
        }
		temp=sec.next;
		
		sec.next=prev;
		
		reverseUtill(temp,sec);
		return head;
	}
	public void reverseListRec1(Node start){
		Node first,second;
		if(start==null)
			return ;
		first=start;
		second=first.next;
		
		if(second==null)			
		return ;
		reverseListRec1(second);
		first.next.next=first;
		first.next=null;
		
		head=second;
	}
	public Node reverseList(Node start){
		Node pre=null,next=start,temp;
		
		while(next!=null){
			temp=next.next;
			next.next=pre;
			pre=next;
			next=temp;
		}
		start=pre;
		return start;
	}
	public void deleteNode(int data){
        if(head==null){
            System.out.println("Node not present with data="+data);
        }
        else if(head.data==data){
            head=null;
        }
        else{
            Node ptr=head;
            
            while(ptr.next!=null&&ptr.next.data!=data)
                ptr=ptr.next;
            if(ptr.next.data==data){
                Node temp=ptr.next;
                ptr.next=temp.next;
            }
            else{
                System.out.println("Node not present with data="+data);
            }
        }
    }
    public void removeNode(){
        
        System.out.println("enter data to be deleted !");
        int data=Integer.parseInt(sc.next());
        deleteNode(data);
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
	
	public static void main(String args[]){
		LinkList ll=new LinkList();
		ll.createList();
		/*ll.printList(ll.head);
		ll.head=ll.reverseList(ll.head);
		ll.printList(ll.head);
		Node res=ll.reverseUtill(ll.head,null);
		ll.printList(res);
		res=ll.kAltReverse(ll.head,3);
		ll.printList(res);*/
		Node res=ll.kAltReverse1(ll.head,2);
		ll.printList(res);
		/*res=ll.deleteMNodeAfterN(ll.head,2,2);
		ll.printList(res);*/
		
	}
}
