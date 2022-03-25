package aa.aaa.aaa.aaaa;

//https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
//https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
//https://www.geeksforgeeks.org/iterative-postorder-traversal/
//https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
//https://www.geeksforgeeks.org/iterative-preorder-traversal/

/**
 * Preorder traversal of binary tree is
1 2 4 5 3 6 7 
       1
 2 4 5   3 6 7
   2       3
 4   5   6   7
Inorder traversal of binary tree is
4 2 5 1 6 3 7
		1
4 2 5      6 3 7
  2          3
4   5      6    7
Postorder traversal of binary tree is
4 5 2 6 7 3 1
    
       1
4 5 2     6 7 3
  2         3
4   5     6    7

---------------------------------------------------
preOrder :1 2 4 5 3 6 7
PostOrder : 4 5 2 6 7 3 1

PostOrder :                               PreOrder :
         1                                         1
 4 5 2      6 7 3                        2 4 5         3 6 7
   2          3                 
 4    5     6    7


----------------------------------------------

           1
       2        3
   4       5 6     7
 * @author rajpal
 *
 */
public class AllTreeTraversals {

}
