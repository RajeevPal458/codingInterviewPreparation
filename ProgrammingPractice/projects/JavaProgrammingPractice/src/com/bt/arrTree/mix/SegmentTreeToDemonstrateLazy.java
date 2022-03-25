package com.bt.arrTree.mix;

import java.util.Arrays;

public class SegmentTreeToDemonstrateLazy {
	static int MAX=13;
	static int lazy[]=new int[50];
	static int st[]=new int[MAX];
	
	
	static void updateRangeUtil(int ss, int se, int us,int ue,int si, int diff)
	{
		System.out.print("start");
		System.out.println();
		if (lazy[si] != 0)
		{
			st[si] += lazy[si];
 
			System.out.print("lazy[si] != 0 "+"lazy["+si+"]"+lazy[si]);
			if (ss != se)
			{
            // We can postpone updating children we don't
            // need their new values now.
            // Since we are not yet updating children of si,
            // we need to set lazy flags for the children
            lazy[si*2 + 1]   += lazy[si];
            lazy[si*2 + 2]   += lazy[si];
			}
 
			// Set the lazy value for current node as 0 as it
			// has been updated
			lazy[si] = 0;
		}
 
		// out of range
		if (ss>se || ss>ue || se<us)
			return ;
 
		// Current segment is fully in range
		if (ss>=us && se<=ue)
		{
			// Add the difference to current node
			st[si] += (se-ss+1)*diff;
			System.out.print(" (se-ss+1)*diff "+"("+se+"-"+ss+"+1+)*"+diff);
			System.out.println();
			// same logic for checking leaf node or not
			if (ss != se)
			{
            // This is where we store values in lazy nodes,
            // rather than updating the segment tree itelf
            // Since we don't need these updated values now
            // we postpone updates by storing values in lazy[]
				lazy[si*2 + 1]   += diff;
				lazy[si*2 + 2]   += diff;
			}
			return;
		}
		System.out.println("end");
		System.out.println();
		// If not completely in rang, but overlaps, recur for
		// children,
		int mid = (ss+se)/2;
		updateRangeUtil( ss, mid, us, ue,si*2+1, diff);
		updateRangeUtil( mid+1, se, us, ue,si*2+2, diff);
 
		// And use the result of children calls to update this
		// node
		st[si] = st[si*2+1] + st[si*2+2];
	}
 
	static void updateRange(int n, int us, int ue, int diff)
	{
		updateRangeUtil(0, n-1, us, ue,0,diff);
	}
	public static int getSumUtil(int ss,int se,int from,int to,int si){
		
		if(lazy[si]!=0){
			st[si]+=(se-ss+1)*lazy[si];
			
			if(ss!=se){
				lazy[si*2+1] += lazy[si];
	            lazy[si*2+2] += lazy[si];
			}
			lazy[si]=0;
		}
		
		if(ss>=from&&se<=to)
		{ 
			//System.out.print (" SS "+ss+" SE "+se+ " si: "+si+" "+st[si]+" , ");
			return st[si];
		}
		if(ss>se||from>se||to<ss)
			return 0;
		int mid=ss+(se-ss)/2;
		//System.out.print (" si: "+si+" ");
		
		return getSumUtil(ss,mid,from,to,2*si+1)+
				getSumUtil(mid+1,se,from,to,2*si+2);
	}
	public static int getSum(int[] arr,int qs,int qe,int n){
		if(qs<0||qe>n-1||qs>qe)
			return -1;
		return getSumUtil(0,n-1,qs,qe,0);
	}
	public static int createSTUtil(int[] arr,int ss,int se,int si){
		if(ss==se)
		{
			st[si]=arr[ss];
			return arr[ss];
		}
		if(ss<0||ss>se)
			return 0;
		int mid=ss+(se-ss)/2;
		st[si]=createSTUtil(arr,ss,mid,2*si+1)+createSTUtil(arr,mid+1,se,2*si+2);
		return st[si];
		
	}
	public static void createST(int[] arr,int n){
		createSTUtil(arr,0,n-1,0);
	}
	public static void main(String[] args) {
		int arr[]={1,3,5,7,9,11};
		int len=arr.length;
		createST(arr,len);
		Arrays.fill(lazy,0);
		System.out.print("ST"+Arrays.toString(st));
		System.out.println();
		System.out.println("Sum "+getSum(arr,1,3, len));
		updateRange(len,1,3,10);
		//updateRange(len,0,2,10);
		System.out.print("Lazy Arr"+Arrays.toString(lazy));
		System.out.println();
		System.out.print("ST"+Arrays.toString(st));
		System.out.println();
		System.out.println("Sum "+getSum(arr,1,3, len));
		System.out.print("ST"+Arrays.toString(st));
	}
}
