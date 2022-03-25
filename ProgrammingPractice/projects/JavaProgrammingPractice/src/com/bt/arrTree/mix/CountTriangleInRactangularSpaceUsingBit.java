package com.bt.arrTree.mix;

import java.util.Arrays;

public class CountTriangleInRactangularSpaceUsingBit {
	static int maxn=8;
	// 2D Binary Indexed Tree. Note: global variable
	// will have initially all elements zero
	static int[][] bit=new int[maxn][maxn];
	static int[][] mat=new int[maxn][maxn];
	// function to add a point at (x, y)
	public static void update(int x, int y)
	{
	    int y1;
	    while (x < maxn)
	    {
	        // x is the xth BIT that will be updated
	        // while y is the indices where an update
	        // will be made in xth BIT
	        y1 = y;
	        while ( y1 < maxn )
	        {
	            bit[x][y1]++;
	            y1 += ( y1 & -y1 );
	        }
	 
	        // next BIT that should be updated
	        x += x & -x;
	    }
	}
	 public static void creatMat(int x,int y){
		 mat[x][y]++;
	 }
	// Function to return number of points in the
	// rectangle (1, 1), (x, y)
	public static int query(int x1, int y)
	{
	    int res = 0, y1;
	    int x=x1;
	    while (x > 0)
	    {
	        // xth BIT's yth node must be added to the result
	        y1 = y;
	        while (y1 > 0)
	        {
	            res += bit[x][y1];
	            y1 -= y1 & -y1;
	            System.out.println("y1:"+y1);
	        }
	 
	        // next BIT that will contribute to the result
	        x -= x & -x;
	        System.out.println("x:"+x);
	    }
	    System.out.println("Query:("+x1+","+y+") :"+res);
	    
	    return res;
	}
	 
	// (x1, y1) is the lower left and (x2, y2) is the
	// upper right corner of the rectangle
	public static int pointsInRectangle(int x1, int y1, int x2, int y2)
	{
	    // Returns number of points in the rectangle
	    // (x1, y1), (x2, y2) as described in text above
	    return query(x2, y2) - query(x1 - 1, y2) -query(x2, y1 - 1) + query(x1 - 1, y1 - 1);
	}
	 
	// Returns count of triangles with n points, i.e.,
	// it returns nC3
	public static int findTriangles(int n)
	{
	    // returns pts choose 3
	    return (n * (n - 1) * (n - 2)) / 6;
	}
	 
	//driver code
	public static void main(String[] args)
	{
		for(int i=0;i<maxn;i++){
			 for(int j=0;j<maxn;j++)
				 mat[i][j]=0;
		 }
		// create matrix indicating points
		creatMat(2, 2);
		creatMat(3, 5);
		creatMat(4, 2);
		creatMat(4, 5);
		creatMat(5, 4);
		for(int i=0;i<maxn;i++)
			System.out.println(Arrays.toString(mat[i]));
		
		
		System.out.println("Create Bit");
	    //inserting points
	    update(2, 2);
	    for(int i=0;i<maxn;i++)
			System.out.println(Arrays.toString(bit[i]));
	    System.out.println();
	    
	    update(3, 5);
	    for(int i=0;i<maxn;i++)
			System.out.println(Arrays.toString(bit[i]));
	    System.out.println();
	    
	    update(4, 2);
	    for(int i=0;i<maxn;i++)
			System.out.println(Arrays.toString(bit[i]));
	    System.out.println();
	    
	    update(4, 5);
	    for(int i=0;i<maxn;i++)
			System.out.println(Arrays.toString(bit[i]));
	    System.out.println();
	    
	    update(5, 4);
	    for(int i=0;i<maxn;i++)
			System.out.println(Arrays.toString(bit[i]));
	    System.out.println();
	    
	    System.out.println("No. of triangles in the rectangle (1, 1)"+" (6, 6) are: ");
	    int points=pointsInRectangle(1, 1, 6, 6);
	    System.out.println("Points:"+points);
	    System.out.println("Triangle:"+findTriangles(points));
	    
	    System.out.println("No. of triangles in the rectangle (1, 1)"+" (6, 6) are: ");
	     points=pointsInRectangle(1, 1, 6, 6);
	        
	    System.out.println(findTriangles(points));
	    
	    update(3, 3);
	 
	    System.out.println("\nNo. of triangles in the rectangle (1, 1)"+" (6, 6) are: ");
	    points=pointsInRectangle(1, 1, 6, 6);
	    System.out.println(findTriangles( points));
	 
	}
}
