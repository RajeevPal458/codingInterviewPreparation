package org.algo.linkedList;

import org.algo.linkedList.LinkedList.Node;

public class ReverseSingleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList();
		list.createList();
		
		 reverseLinkedList(list.head);
	}

	private static void reverseLinkedList(Node head) {
		// 1 2 3 4 5
		Node ptr= head;
		Node next = null;
		Node pre=null;
		
		while (ptr!=null) {
			 next = ptr.next;
			 ptr.next =pre;
			 pre = ptr;
			 ptr= next;
		}
		
		LinkedList list = new LinkedList();
		list.print(pre);
		
	}

	

}
