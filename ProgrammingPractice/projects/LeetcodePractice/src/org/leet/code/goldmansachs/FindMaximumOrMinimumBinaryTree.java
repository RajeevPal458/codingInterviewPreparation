package org.leet.code.goldmansachs;

class Node {
    int data;
    Node left, right;
 
    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}
public class FindMaximumOrMinimumBinaryTree {
	Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FindMaximumOrMinimumBinaryTree tree = new FindMaximumOrMinimumBinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);
 
        // Function call
        System.out.println("Maximum element is "
                           + tree.findMax(tree.root));
	}
	private int findMax(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		
		int rootval = root.data;
		int rootLeft = findMax(root.left);
		int rootRight = findMax(root.right);
		
		if(rootLeft>rootval)
			rootval = rootLeft;
		if(rootRight > rootval )
			rootval = rootRight;
		
		return rootval;
	}

}
