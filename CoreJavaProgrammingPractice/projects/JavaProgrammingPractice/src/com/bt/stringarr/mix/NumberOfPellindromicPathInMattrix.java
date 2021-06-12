package com.bt.stringarr.mix;

public class NumberOfPellindromicPathInMattrix {

	public boolean checkPelindrome(char[] path,int index){
		for(int i=0,j=index;i<=index&&j>=0;i++,j--)
			if(path[i]!=path[j])
				return false;
		return true;
	}
	/*public boolean isSafe(char[] path,int index){
		
	}*/
	public void printPath(char[] path,int index){
		for(int i=0;i<index;i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	public void pelindromicPath(char[][] ch,char[] path,int strw,int stcl,int index,int row,int col){
			
		if(stcl==col+1&&index>row+col){
			if(this.checkPelindrome(path, index-1)){
				printPath(path, index);
			}
			return;
		}
		if(strw>row||stcl>col)
			return;
		
			if(strw<=row&&stcl<=col)
				path[index]=ch[strw][stcl];
			
			pelindromicPath(ch,path,strw,stcl+1,index+1,row,col);
			pelindromicPath(ch,path,strw+1,stcl,index+1,row,col);
			
	}
	public static void main(String[] args) {
		String[] str={"aaab","baaa","abba"};
		int len=str.length;
		char[][] arr=new char[len][];
		char[] path=new char[len+str[0].length()];
		for(int i=0;i<len;i++){
			arr[i]=str[i].toCharArray();
		}
		NumberOfPellindromicPathInMattrix ppm=new NumberOfPellindromicPathInMattrix();
		ppm.pelindromicPath(arr,path,0,0,0,len-1, str[0].length()-1);
		
	}
}
