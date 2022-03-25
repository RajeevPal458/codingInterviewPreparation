package aa.aaa.aaa.aaaa;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/print-left-view-binary-tree/
public class Print_Left_View_of_a_Binary_Tree {

//Java program to print left view of binary tree

/* Class containing left and right child of current
node and key value*/
	Node root;
	static int max_level = 0;

	// recursive function to print left view
	/*
	 *      12
	 *  10      30
	 *       25    40
	 */
	void leftViewUtil(Node node, int level)
	{
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	// function to print left view of binary tree
    private static void printLeftView(Node root)
    {
        if (root == null)
            return;
 
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
 
        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
 
            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
 
                // Print the left most element at
                // the level
                if (i == 1)
                    System.out.print(temp.data + " ");
 
                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);
 
                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }
	// A wrapper over leftViewUtil()
	void leftView()
	{
		leftViewUtil(root, 1);
	}

	/* testing for example nodes */
	public static void main(String args[])
	{
		/* creating a binary tree and entering the nodes */
		Print_Left_View_of_a_Binary_Tree tree = new Print_Left_View_of_a_Binary_Tree();
		tree.root = new Node(12);
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);

		tree.leftView();
	}
}

