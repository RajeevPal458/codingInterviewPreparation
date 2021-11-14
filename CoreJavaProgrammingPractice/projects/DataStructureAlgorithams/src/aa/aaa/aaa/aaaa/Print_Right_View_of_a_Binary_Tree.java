package aa.aaa.aaa.aaaa;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
public class Print_Right_View_of_a_Binary_Tree {

//Java program to print right view of binary tree

//A binary tree node

//class to access maximum level by reference

	Node root;
	int max_level = 0;

	// Recursive function to print right view of a binary tree.
	void rightViewUtil(Node node, int level) {

		// Base Case
		if (node == null)
			return;

		// If this is the last Node of its level
		if (max_level < level) {
			System.out.print(node.data + " ");
			max_level = level;
		}

		// Recur for right subtree first, then left subtree
		rightViewUtil(node.right, level + 1);
		rightViewUtil(node.left, level + 1);
	}
	
	void rightView(Node root)
    {
        if (root == null) {
            return;
        }
 
        Queue<Node> q = new LinkedList<>();
        q.add(root);
 
        while (!q.isEmpty()) {
 
            // get number of nodes for each level
            int n = q.size();
 
            // traverse all the nodes of the current level
            for (int i = 0; i < n; i++) {
                Node curr = q.peek();
                q.remove();
 
                // print the last node of each level
                if (i == n - 1) {
                    System.out.print(curr.data);
                    System.out.print(" ");
                }
 
                // if left child is not null add it into
                // the
                // queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
 
                // if right child is not null add it into
                // the
                // queue
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
	
	// Driver program to test the above functions
	public static void main(String args[]) {
		Print_Right_View_of_a_Binary_Tree tree = new Print_Right_View_of_a_Binary_Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		
		tree.rightViewUtil(tree.root,1);

		}
}

//This code has been contributed by Mayank Jaiswal

