package org.algo.linkedList;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/// Recursive merge 
	public Node SortedMerge(Node A, Node B)
    {
     
        if(A == null) return B;
        if(B == null) return A;
         
        if(A.data < B.data)
        {
            A.next = SortedMerge(A.next, B);
            return A;
        }
        else
        {
            B.next = SortedMerge(A, B.next);
            return B;
        }
         
    }

}
