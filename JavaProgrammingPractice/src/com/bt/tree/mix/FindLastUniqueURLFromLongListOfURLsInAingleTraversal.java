package com.bt.tree.mix;

public class FindLastUniqueURLFromLongListOfURLsInAingleTraversal {

	static int max = 256;
	//LList Node
	static class DLLNode{
	    String data;
	    DLLNode next;
	    DLLNode(){
	    	this.data="";
	    	this.next=null;
	    }
	}
	 
	// trie node
	static class TrieNode
	{
	    TrieNode[] child;
	    boolean isLeaf;
	    String data;
	    TrieNode(){
	    	this.isLeaf=false;
	    	child=new TrieNode[max];
	    	this.data="";
	    }
	}
	 
	/* Given a reference (pointer to pointer) to the
	   head of a list and an int, inserts a new node
	   on the front of the list. */
	public static void pushData(DLLNode head, String data)
	{
		int prelen;
	    DLLNode temp = new DLLNode();
	    	temp.data=data;
	    int currlen=temp.data.length();
	    if(head.next!=null){
	    	prelen=head.next.data.length();
	    	
	    	if(currlen>prelen){
	    		temp.next=head.next;
	    		head.next=temp;
	    	}
	    }
	    else
	    	head.next=temp;
	}
	 
	/* Function to delete a node in a Doubly Linked List.
	   head_ref --> pointer to head node pointer.
	   del  -->  pointer to node to be deleted. */
	public static void deleteNode(DLLNode head, String del)
	{
	    // base case
	    if (head== null || del == null)
	        return;
	 
	    // If node to be deleted is head node
	    DLLNode ptr=head,temp;
	    
	    while(ptr.next!=null&&ptr.next.data!=del)
	    	ptr=ptr.next;
	    if(ptr.next==null)
	    	return;
	    else if(ptr.next.data==del)
	    	ptr.next=ptr.next.next;
	}
	 
	// If not present, inserts key into trie
	// If the key is prefix of trie node, just marks leaf node
	public static void insert(TrieNode root, char[] key, DLLNode head)
	{
	    int index;
	    TrieNode pCrawl = root;
	 
	    for (int level = 0; level < key.length; level++)
	    {
	        index = (int)key[level];
	        if (pCrawl.child[index]==null)
	        	pCrawl.child[index] = new TrieNode();
	 
	        pCrawl = pCrawl.child[index];
	    }
	 
	    if (pCrawl.isLeaf)
	    {
	        // cout << "Duplicate Found " << key << endl;
	        // delete from linked list
	        if (pCrawl.data!=null)
	            deleteNode(head, pCrawl.data);
	        pCrawl.data=null;
	    }
	    else
	    {
	        // mark last node as leaf
	        pCrawl.isLeaf = true;
	 
	        // insert to linked list
	       pushData(head, String.valueOf(key));
	        pCrawl.data=String.valueOf(key);
	    }
	}
	public static void printList(DLLNode root){
		if(root==null)
			return ;
		else{
			DLLNode ptr=root;
			while(ptr!=null){
				
				System.out.println(ptr.data);
				ptr=ptr.next;
			}
		}
	}
	// Driver function
	public static void main(String[] args)
	{
	   String urls[] = {
	        "http://www.geeksforgeeks.org",
	        "http://www.contribute.geeksforgeeks.org",
	        "http://quiz.geeksforgeeks.org",
	        "http://qa.geeksforgeeks.org",
	        "http://practice.geeksforgeeks.org",
	        "http://code.geeksforgeeks.org",
	        "http://quiz.geeksforgeeks.org",
	        "http://practice.geeksforgeeks.org",
	        "http://code.geeksforgeeks.org",
	        "http://quiz.geeksforgeeks.org",
	        "http://qa.geeksforgeeks.org",
	        "http://practice.geeksforgeeks.org"
	        };
	 
	    TrieNode root = new TrieNode();
	 
	    // Start with the empty list
	    DLLNode head = new DLLNode();
	    int n = urls.length;
	 
	    // Construct Trie from given URLs
	    for (int i = 0; i < n; i++)
	        insert(root, urls[i].toCharArray(), head);
	 
	    // head of linked list will point to last
	    // distinct URL
	    //printList(head);
	    
	    System.out.println(head.next.data);
	}
}
