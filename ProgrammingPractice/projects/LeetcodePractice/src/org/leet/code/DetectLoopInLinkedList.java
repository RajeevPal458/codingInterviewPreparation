package org.leet.code;

import java.util.HashSet;

public class DetectLoopInLinkedList {

	Node head; // head of list
	 
    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    // Returns true if there is a loop in linked
    // list else returns false.
    public boolean detectLoop(Node node)
    {
        Node ptr1 = node;
        Node ptr2 = node;
        
        while (ptr2!=null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			
			if(ptr1==ptr2) return true;
		}
        return false;
    }
    
    static boolean detectLoop1(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
           
            if (s.contains(h))
                return true;
 
            s.add(h);
 
            h = h.next;
        }
 
        return false;
    }
 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectLoopInLinkedList llist = new DetectLoopInLinkedList();
		 
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
 
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
 
        if (llist.detectLoop(llist.head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
        
	}

}
