package com.ll.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ll.service.LinkList.Node;

public class LinkedList {
	Scanner sc =new Scanner(System.in);
	Node head;
	static class Node{
		Node prev;
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=this.prev=null;
		}
	}
	
	static class TNode 
    {
        int data;
        TNode left, right;
 
        TNode(int d) 
        {
            data = d;
            left = right = null;
        }
    }
	// insert  node in list in  sorted order 
	public void insertNodeInSortedOrder(int data){
		Node ptr;
		Node temp=new Node(data);
		if(head==null)
			this.head=temp;
		else if(data<head.data&&head!=null){
			temp.next=head;
			this.head=temp;
		}
		else{
			ptr=this.head;
			while(ptr.next!=null&&data>ptr.next.data)
				ptr=ptr.next;
			temp.next=ptr.next;
			ptr.next=temp;
		}
	}
	//Copy a linked list with next and arbit pointer
	
	public Node CopyListWithNextAndRandmointer1(Node node){
		
		Node copy=null,orig=node;
		this.head=null;
		this.createList();
		copy=this.head;
		Node orig_n,copy_n;
		while(copy!=null&&orig!=null){
			orig_n=orig.next;
			copy_n=copy.next;
			orig.next=copy;
			copy.prev=orig;
			orig=orig_n;
			copy=copy_n;
		}
		Node copy_list_node=copy;
		while(copy_list_node!=null){
			copy_list_node.prev =copy_list_node.prev.prev.next;
                    copy_list_node = copy_list_node.next; 
		}
		
		return copy;
	}
	
public Node CopyListWithNextAndRandmointer2(Node node){
		int data;
		Node org=node;
		Node org_n;
		while(org!=null){
			data=org.data;
			org_n=org.next;
			org.next=new Node(data);
			org.next.next=org_n;
			org=org_n;
		}
		
		org=node;
		while(org!=null){
			org.next.prev=org.prev.next;
			org=(org.next!=null)?org.next.next:org.next;
		}
		org=node;
		Node copy=org.next,temp=copy;
		while(org!=null){
			org.next=(org.next!=null)?org.next.next:org.next;
			copy.next = (copy.next!=null)?copy.next.next:copy.next;
			org=org.next;
			copy=copy.next;
		}
		return temp;
	}
void print(Node head)
{
    Node temp = head;
    while (temp != null)
    {
        Node prev = temp.prev;
        int randomData = (prev != null)? prev.data: -1;
        System.out.println("Data = " + temp.data +
                           ", Random data = "+ randomData);
        temp = temp.next;
    }
}
public Node CopyListWithNextAndRandmointer3(Node node){
	Node orig=node;
	Node copy;
	
	Map<Node,Node> map=new HashMap<Node,Node>();
	
	while(orig!=null){
		map.put(orig, new Node(orig.data));
		orig=orig.next;
	}
	
	orig=node;
	
	while(orig!=null){
		
		copy=map.get(orig);
		copy.next=map.get(orig.next);
		copy.prev=map.get(orig.prev);
		orig=orig.next;
	}
	this.head=map.get(node);
	return head;
}
	//Merge a linked list into another linked list at alternate positions
	public Node merge2ListAlternat(Node first,Node second){
		Node temp=null,res=null;
		Node ptr1=first,ptr2=second;
			
		res=ptr1;
		ptr1=ptr1.next;  //........
		res.next=ptr2;
		ptr2=ptr2.next;  //..............
		temp=res;
		res=res.next;
		int count=0;
		while(ptr1!=null&&ptr2!=null){
			
			
			res.next=ptr1;
			res=res.next;
			ptr1=ptr1.next;
			res.next=null;
			res.next=ptr2;
			res=res.next;
			ptr2=ptr2.next;
			res.next=null;
			count++;
		}
		System.out.println(count);
		
		return temp;
	}
	
	
	
	
	
	
	
	
	
	public int  countNodeInList(Node list){
		int count=0;
		Node ptr=list;
		while(ptr!=null)
		{
			count++;
			ptr=ptr.next;
		}
		return count;
	}
	public TNode sortedListToBST(Node start){
		
		int count=this.countNodeInList(start);
		return sortedListToBSTRec(count);
	}
	public TNode sortedListToBSTRec(int n){
		
		if(n<=0)
			return null;
		
		TNode left=sortedListToBSTRec(n/2);
		
		TNode root = new TNode(head.data);
		
		root.left=left;
		
		head=head.next;
		
		root.right = sortedListToBSTRec(n - n / 2 - 1);
		//Node Tree=new Node()
		return root;
	}
	
	public void inOrderTree(TNode root){
		if(root==null)
			return ;
		inOrderTree(root.left);
		System.out.print(" "+root.data);
		inOrderTree(root.right);
	}
	public void inOrder(Node root){
		if(root==null)
			return ;
		inOrder(root.prev);
		System.out.print(" "+root.data);
		inOrder(root.next);
	}
	
	public Node SortedArrayToBST(int arr[],int low,int high){
		int mid;
			if(low>high)
				return null;
			mid=(low+high)/2;
			
			Node root=new Node(arr[mid]);
						
			root.prev=SortedArrayToBST(arr,low,mid-1);
			root.next=SortedArrayToBST(arr,mid+1,high);
			
		return root;
	}
	
	public void detectLoop(Node node){
		
		Node store=node,slow=node,fast=node;
		
		while(slow!=null&&fast!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				removeloop(slow,node);
				break;
			}
		}
	}
	public void removeloop(Node loopNode, Node head){
		
	}
	/////../////////////////////
	/*int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
 
            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }
 
    // Function to remove loop
    void removeLoop(Node loop, Node curr) {
        Node ptr1 = null, ptr2 = null;
 
         Set a pointer to the beging of the Linked List and
         move it one by one to find the first node which is
         part of the Linked List 
        ptr1 = curr;
        while (1 == 1) {
 
             Now start a pointer from loop_node and check if it ever
             reaches ptr2 
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
 
             If ptr2 reahced ptr1 then there is a loop. So break the
             loop 
            if (ptr2.next == ptr1) {
                break;
            }
 
             If ptr2 did't reach ptr1 then try the next node after ptr1 
            ptr1 = ptr1.next;
        }
 
         After the end of loop ptr2 is the last node of the loop. So
         make next of ptr2 as NULL 
        ptr2.next = null;
    }*/
    //..................................................................................................
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
            this.insertNodeInSortedOrder(data);
        }
       /* Node loop=head,pt=loop;
        Node arr[]=new Node[15];
        int j;
        for(j=0;loop.next!=null;j++){
        	arr[j]=loop;
        	loop=loop.next;
        }
        loop.next=arr[3];
        this.head=pt;
        System.out.println("Nodes:"+j);
        //..................................................
        Node ptr;
        ptr=head;
        int count=0;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            count++;
            ptr=ptr.next;
            if(count>=15)
            	break;
        }
        
        System.out.println();
        //....................................................
*/    }
    public void printList(Node head){
        Node ptr;
        ptr=head;
        //int count=0;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
           // count++;
            ptr=ptr.next;
            //if(count>=15)
            	//break;
        }
        
        System.out.println();
    }
	//Convert a Binary Tree to a Doubly List..
    TNode res=null;
    public TNode BTLinkedList(TNode node){
    	
    	if(node==null)
    		return null;
    	BTLinkedList(node.right);
    	
    	node.right=res;
    	if(res!=null)
    		res.left=node;
    	res=node;
    	
    	BTLinkedList(node.left);
    	return res;
    }
    TNode l=null,result=null;
    int i=0;
    public TNode BTCircuLinkedList(TNode node){
    	//.................................................................
    	return result;
    }
    static void printTree(TNode node){
    	
    	if(node==null)
    		return;
    	printTree(node.left);
    	System.out.print(" "+node.data);
    	printTree(node.right);
    	
    }
    void print(TNode node){
    	TNode temp=null,ptr=node;
    	int count=0;
    	if(node==null)
    		return;
    	while(ptr!=null){
    		System.out.print(" "+ptr.data);
    		temp=ptr;
    		ptr=ptr.right;
    		count++;
    		if(count>20)
    			break;
    	}
    	count=0;
    	System.out.println();
    	System.out.println("Using left pointer ..");
    	if(temp==null)
    		return;
    	while(temp!=null){
    		System.out.print(" "+temp.data);
    		temp=temp.left;
    		count++;
    		if(count>20)
    			break;
    	}
    	System.out.println();
    }
    //.......................................................
	public static void main(String args[]){
		TNode root;
		root=new TNode(10);
		
		root.left=new TNode(5);
		root.left.left=new TNode(3);
		root.left.right=new TNode(6);
		root.left.left.left=new TNode(1);
		
		root.right=new TNode(15);
		root.right.left=new TNode(13);
		root.right.right=new TNode(18);
		root.right.right.right=new TNode(20);
		System.out.println("print Tree...........");
		printTree(root);//..........................
		LinkedList ll=new LinkedList();
		System.out.println(".....................");
		
	}
}
