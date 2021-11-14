package org.algo.matrix;

//https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
public class InplaceRotateSquareMatrixby90Degrees {

 int N =4;
	//An Inplace function to
	//rotate a N x N matrix
	//by 90 degrees in
	//anti-clockwise direction
	public  void rotateMatrix(int mat[][])
	{ 
			//REVERSE every row
			for(int i=0;i<N;i++){
				int k=N-1;
				for(int j=0;j<N/2;j++){
					int temp = mat[i][j];
					mat[i][j]=mat[i][k];
					mat[i][k] = temp;
					k--;
				}
			}
			//1 2 3 4 5
			//5 4  3 2 1
			displayMatrix(mat);
			
			//Performing Transpose
			for(int i=0;i<N;i++){ 
				for(int j=i;j<N;j++){
					int temp = mat[i][j];
					mat[i][j] = mat[j][i];
					mat[j][i] = temp;
				}
			}
		
	}
	
	//Function to print the matrix
	public  void displayMatrix(int mat[][])
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" "+ mat[i][j]);
	
			System.out.println();
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void  main(String[] args)
	{
		// Test Case 1
		int mat[][] = {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
		};
	
		// Tese Case 2
		/* int mat[N][N] = {
							{1, 2, 3},
							{4, 5, 6},
							{7, 8, 9}
						};
		*/
	
		// Tese Case 3
		/*int mat[N][N] = {
						{1, 2},
						{4, 5}
					};*/
	
		InplaceRotateSquareMatrixby90Degrees  rotater = new InplaceRotateSquareMatrixby90Degrees();
		rotater.displayMatrix(mat);
		
		rotater.rotateMatrix(mat);
	
		// Print rotated matrix
		rotater.displayMatrix(mat);
		}
}
