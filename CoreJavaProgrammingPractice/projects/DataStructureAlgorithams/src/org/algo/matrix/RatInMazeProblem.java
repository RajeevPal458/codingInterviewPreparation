package org.algo.matrix;

public class RatInMazeProblem {
	static StringBuffer sb;
	public RatInMazeProblem(){
		sb=new StringBuffer();
	}
	public static boolean isSafe(int[][] arr,int n,int i,int j){
		boolean flage=false;
		if((i<n&&j<n)&&(arr[i][j]==1))
			flage=true;
		
		return flage;
	}
	/*if(isSafe(arr, n, row+1,col)){
							sb.append("D");
							if(ratMove(arr,n,row+1,col));
								return true;
						}
						if(isSafe(arr, n,row, col+1)){
							sb.append("R");
							if(ratMove(arr,n,row,col+1))
								return true;;
						}
						
				return false;	
	 * */
	public static boolean ratMove(int[][] arr,int n,int row,int col){
		if(isSafe(arr, n, row+1,col)){
			sb.append("D");
			if(ratMove(arr,n,row+1,col));
				return true;
		}
		if(isSafe(arr, n,row, col+1)){
			sb.append("R");
			if(ratMove(arr,n,row,col+1))
				return true;;
		}
		
		return false;
	}
	public static void main(String[] args) {
		int[][] arr={{1,1,0,0},
					 {1,1,1,1},
					 {0,1,0,1},
					 {0,1,1,1}
					 };
		int n=4;
		RatInMazeProblem rmp=new RatInMazeProblem();
		boolean ispresent = ratMove(arr, n,0,0);
		System.out.println("Rate Reaches To Dest: "+ispresent);
	}
}
