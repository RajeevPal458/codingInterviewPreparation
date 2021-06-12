package com.bt.arrTree.mix;

import java.util.Arrays;

public class TwoDimensionalBinaryIndexedTreeOrFenwickTree {
	static int N=4; // N-->max_x and max_y
	 
	// A structure to hold the queries
	static class Query
	{
	    int x1, y1; // x and y co-ordinates of bottom left
	    int x2, y2; // x and y co-ordinates of top right
	}
	 
	// A function to update the 2D BIT
	public static void updateBIT(int BIT[][], int x, int y, int val)
	{
	    for (; x <= N; x += (x & -x))
	    {
	        // This loop update all the 1D BIT inside the
	        // array of 1D BIT = BIT[x]
	        for (; y <= N; y += (y & -y))
	            BIT[x][y] += val;
	    }
	    return;
	}
	 
	// A function to get sum from (0, 0) to (x, y)
	public static int getSum(int BIT[][], int x, int y)
	{
		System.out.println("get sum:"+x+" "+y);
	    int sum = 0;
	 
	    for(; x > 0; x -= x&-x)
	    {
	        // This loop sum through all the 1D BIT
	        // inside the array of 1D BIT = BIT[x]
	        for(; y > 0; y -= y&-y)
	        {
	        	System.out.println("(x,y)"+x+" "+y+" BIT[x][y] "+BIT[x][y]);
	            sum += BIT[x][y];
	        }
	    }
	    return sum;
	}
	 
	// A function to create an auxiliary matrix
	// from the given input matrix
	public static void constructAux(int mat[][], int aux[][])
	{
	    // Initialise Auxiliary array to 0
	    for (int i=0; i<=N; i++)
	        for (int j=0; j<=N; j++)
	            aux[i][j] = 0;
	 
	    // Construct the Auxiliary Matrix
	    for (int j=1; j<=N; j++)
	        for (int i=1; i<=N; i++)
	            aux[i][j] = mat[N-j][i-1];
	 
	    return;
	}
	 
	// A function to construct a 2D BIT
	public static void construct2DBIT(int mat[][], int BIT[][])
	{
	    // Create an auxiliary matrix
	    int[][] aux=new int[N+1][N+1];
	    constructAux(mat, aux);
	    
	    System.out.println("Auxiliary matrix");
	    for(int i=0;i<=N;i++)
			System.out.println(Arrays.toString(aux[i]));
	    
	    // Initialise the BIT to 0
	    for (int i=1; i<=N; i++)
	        for (int j=1; j<=N; j++)
	            BIT[i][j] = 0;
	    
	    for (int i=1; i<=N; i++)
	    {
	    	for (int j=1; j<=N; j++)
	        {
	            // Creating a 2D-BIT using update function
	            // everytime we/ encounter a value in the
	            // input 2D-array
	        	System.out.println("Get Sum:");
	            int v1 = getSum(BIT, i, j);
	            System.out.println("v1:"+v1);
	            int v2 = getSum(BIT, i, j-1);
	            System.out.println("v2:"+v2);
	            int v3 = getSum(BIT, i-1, j-1);
	            System.out.println("v3 "+v3);
	            int v4 = getSum(BIT, i-1, j);
	            System.out.println("v4 "+v4);
	            // Assigning a value to a particular element
	            // of 2D BIT
	            System.out.println(" aux["+i+"]["+j+"]: " +aux[i][j]);
	            updateBIT(BIT, i, j, aux[i][j]-(v1-v2-v4+v3));
	            
	            for(int k=0;k<=N;k++)
	    			System.out.println(Arrays.toString(BIT[k]));
	            System.out.println();
	        }
	    }
	 
	    return;
	}
	 
	// A function to answer the queries
	public static void answerQueries(Query q[], int m, int BIT[][])
	{
	    for (int i=0; i<m; i++)
	    {
	        int x1 = q[i].x1 + 1;
	        int y1 = q[i].y1 + 1;
	        int x2 = q[i].x2 + 1;
	        int y2 = q[i].y2 + 1;
	 
	        int ans = getSum(BIT, x2, y2)-getSum(BIT, x2, y1-1)-
	                  getSum(BIT, x1-1, y2)+getSum(BIT, x1-1, y1-1);
	 
	        System.out.println("Query("+q[i].x1+","+ q[i].y1+"," +q[i].x2+","+ q[i].y2+")Ans:" +ans);
	    }
	    return;
	}
	 
	// Driver program
	public static void main(String[] args)
	{
	    int mat[][] = {{1, 2, 3, 4},
	                    {5, 3, 8, 1},
	                    {4, 6, 7, 5},
	                    {2, 4, 8, 9}};
	 System.out.println("given Matrix:");
	 for(int i=0;i<N;i++)
			System.out.println(Arrays.toString(mat[i]));
	    // Create a 2D Binary Indexed Tree
	    int[][] BIT=new int[N+1][N+1];
	 System.out.println("Construct Bit:");
	    construct2DBIT(mat, BIT);
	 System.out.println("BIT:>>>>>>>>>>>>>>>>>>");
	    for(int i=0;i<N;i++)
			System.out.println(Arrays.toString(BIT[i]));
	    /* Queries of the form - x1, y1, x2, y2
	    y  For example the query- {1, 1, 3, 2} means the sub-matrix-
	    |
	 - -|------------------------x
	 3  |       1 2 3 4  2 4 5 1             Sub-matrix
	 2  |       5 3 8 1  4 6 3 2              {1,1,3,2}      --->     3 8 1
	 1  |       4 6 7 5  8 7 8 3                                        6 7 5
	 0  |       2 4 8 9  9 5 1 4
	    |
	  --|------ 0 1 2 3 ----> x
	    |
	    y
	    
	    Hence sum of the sub-matrix = 3+8+1+6+7+5 = 30
	 
	    */
	    Query q1=new Query();
	    q1.x1=1;q1.y1=1;q1.x2=3;q1.y2=2;
	    Query q2=new Query();
	    q1.x1=2;q1.y1=3;q1.x2=3;q1.y2=3;
	    Query q3=new Query();
	    q1.x1=1;q1.y1=1;q1.x2=1;q1.y2=1;
	    Query[] q = {q1,q2,q3};
	    int m =q.length;
	 
	    System.out.println("Ans Queries>>>>>>>>>>>>>");
	    answerQueries(q, m, BIT);
	 
	}
	
}
