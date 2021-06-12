package com.bt.string.mix;

public class CheckAllRowsOfMtrxAreCircularRotationsOfEachOther {

	public static boolean checkCirculerRotation(int[][] mat,int row,int col){
		boolean flage=true;
		int arr[]={1,2,3};
			String str=new String();
			for(int j=0;j<col;j++){
				str=str.concat(mat[0][j]+"");
			}
			
			int count=0;
			str=str.concat(str);
			String newrow=new String();
			for(int i=1;i<row;i++){
				
				for(int j=0;j<col;j++){
					newrow=newrow.concat(mat[i][j]+"");
				}
				System.out.println(newrow);
				/*int y;
				for(int x=0;x<=str.length()-col;x++){
					y=x+col;
					String pqr=str.substring(x,y);
					if(pqr.equals(newrow))
						count++;
				}*/
				if(!str.contains(newrow))
					flage=false;
				
				newrow="";
			}
		//return (count==col-1)?true:false;
		return flage;
	}
	public static void main(String[] args) {
		int mat[][]={{1,2,3},{2,3,1},{3,1,2}};
		System.out.println(checkCirculerRotation(mat,3,3));
	}
}
