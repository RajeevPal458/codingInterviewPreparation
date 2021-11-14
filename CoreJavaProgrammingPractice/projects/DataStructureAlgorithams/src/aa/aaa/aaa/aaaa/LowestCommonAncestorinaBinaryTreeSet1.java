package aa.aaa.aaa.aaaa;

//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class LowestCommonAncestorinaBinaryTreeSet1 {
	
	private Node lca(Node node,int a ,int b) {
		// TODO Auto-generated method stub
		if(node==null) return null;
		
		if(node.data==a || node.data==b) return node;
		
		Node lca_left = lca(node.left, a, b);
		Node lca_right = lca(node.right, a, b);
		
		if(lca_left!=null && lca_right!=null){
			return node;
		}
		
		return (lca_left!=null)?lca_left:lca_right;
		
	}
	
	public static void main(String[] args) {
		/* creating a binary tree and entering the nodes */
		Node root;
		LowestCommonAncestorinaBinaryTreeSet1 tree = new LowestCommonAncestorinaBinaryTreeSet1();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		Node lca = tree.lca(root,4,6);
		System.out.println(":lowest common ancester in binary tree data:"+lca.data);
	}
}
