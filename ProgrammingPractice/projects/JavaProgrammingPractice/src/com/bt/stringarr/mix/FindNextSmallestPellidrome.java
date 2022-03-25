package com.bt.stringarr.mix;
import java.util.Arrays;
import java.util.Scanner;

public class FindNextSmallestPellidrome {
	boolean flage=true;
	public boolean isAsccending(int[] arr){
		for(int i=0;i<arr.length-1;i++)
			if(arr[i+1]!=arr[i]+1)
				return false;
		return true;
	}
	public boolean checkPelindrome(char[] arr,int index){
		for(int i=0,j=index;i<=index&&j>=0;i++,j--)
			if(arr[i]!=arr[j])
				return false;
		return true;
	}
	int carry=0;
	public void addToLeftInArray(int[] arr,int left){
		carry=1;
		for(int i=left;i>=0;i--){
			if(carry!=0)
			{
				int nxt=arr[i]+carry;
				if(nxt>=10)
				{
					arr[i]=nxt%10;
					carry=1;
				}
				else{
					arr[i]=nxt;
					carry=0;
				}
			}
			
		}
	}
	public void addToRightInArray(int[] arr,int right){
		carry=1;
		for(int i=right;i<arr.length;i++){
			if(carry!=0)
			{
				int nxt=arr[i]+carry;
				if(nxt>=10)
				{
					arr[i]=nxt%10;
					carry=1;
				}
				else{
					arr[i]=nxt;
					carry=0;
				}
			}
			
		}
	}
	boolean even=false;
	public void nextPelindrome(int num){
		int[] arr;
		char[] n=(num+"").toCharArray();
		int nlen=n.length;
		arr=new int[nlen];
		for(int i=0;i<nlen;i++){
			arr[i]=n[i]-'0';
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<nlen;i++){
			if(arr[i]!=9)
			{ flage=false;break;}
		}
		if(flage)
		{ 
			for(int i=0;i<=nlen;i++)
				if(i==0||i==nlen)
					System.out.print("1");
				else
					System.out.print("0");
			System.out.println();
			return;
		}
		
		if(nlen%2==0)
			even=true;

		int mid=(nlen%2==0)?nlen/2-1:nlen/2;
		int left,right;
		if(this.checkPelindrome(n, nlen-1)){
			right=mid+1;
			if(even){
				left=mid;
				this.addToLeftInArray(arr, left);
				this.addToRightInArray(arr, right);
			}
			else if(!even){
				if(arr[mid]+1>=10){
					left=mid-1;
					arr[mid]=(arr[mid]+1)%10;
					this.addToLeftInArray(arr, left);
					this.addToRightInArray(arr, right);
				}
				else
					arr[mid]+=1;
			}
			
		}
		else{
			if(this.isAsccending(arr)){
				
				
				System.out.println("true");
			}
			else
				System.out.println("false");
				
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number to get Next smallest pellindrome!");
		int[] arr;
		
		int num=Integer.parseInt(sc.nextLine());
		
		//arr=new int[num.length];
		FindNextSmallestPellidrome np=new FindNextSmallestPellidrome();
		np.nextPelindrome(num);
		
		
	}
}
