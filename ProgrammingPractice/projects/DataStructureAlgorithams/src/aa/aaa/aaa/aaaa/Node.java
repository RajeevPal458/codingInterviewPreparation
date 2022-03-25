package aa.aaa.aaa.aaaa;

class Node
{
	int data;
	Node left, right;

	public Node()
	{
		left = right = null;
	}
	public Node(int item)
	{
		data = item;
		left = right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
	
}