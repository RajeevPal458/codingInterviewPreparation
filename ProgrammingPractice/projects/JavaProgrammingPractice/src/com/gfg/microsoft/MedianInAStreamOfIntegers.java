package com.gfg.microsoft;

import java.util.Arrays;

public class MedianInAStreamOfIntegers {
	static int minhlen=0;
	static int maxhlen=0;
	static class MinHeap{
		
		static int[] minHeap;
		public MinHeap(int[] minHeap){
			this.minHeap=minHeap;
		}
		public static void printHeap(){
			System.out.print(" Min:");
			for(int i=1;i<=minhlen;i++)
				System.out.print( minHeap[i]+" ");
		}
		public static int GetTop()
		{
			int min = -1;
			 
	        if( minhlen >= 0 )
	        {
	            min = minHeap[0];
	        }
	 
	        return min;
		}		
		public static void insert(int val){
				minHeap[++minhlen]=val;
				restoreUp(minHeap,minhlen);
		}
		public static int ExtractTop(){
			int temp=-1;
			if(minhlen>0){
			temp=minHeap[1];
			minHeap[1]=minHeap[maxhlen];
			maxhlen--;
			restoreDown(minHeap, 1,maxhlen);
			}
			return temp;
		}
		public static void restoreUp(int[] minHeap,int i){
			int par=i/2;
			int k=minHeap[i];
			
			while(minHeap[par]>k){
				minHeap[i]=minHeap[par];
				i=par;
				par=i/2;
			}
			minHeap[i]=k;
		}
		public static void restoreDown(int[] minHeap,int i,int hsize){
			int lchild=2*i,rchild=2*i+1;
			int num=minHeap[i];
			
			while(rchild<=hsize){
				
				if(minHeap[lchild]>=num&&minHeap[rchild]>=num){
					minHeap[i]=num;
					return;
				}
				else if(minHeap[lchild]>minHeap[rchild]){
					minHeap[i]=minHeap[rchild];
					i=rchild;
				}
				else{
					minHeap[i]=minHeap[lchild];
					i=lchild;
				}
				lchild=2*i;
				rchild=2*i+1;
			}
			if((lchild==hsize)&&num>minHeap[lchild])
			{
				minHeap[i]=minHeap[lchild];
				i=lchild;
			}
			minHeap[i]=num;
		}
		
	}
	static class MaxHeap{
		static int[] maxHeap;
		public MaxHeap(int[] maxHeap){
			this.maxHeap=maxHeap;
		}
		public static void printHeap(){
			System.out.print(" Max:");
			for(int i=1;i<=maxhlen;i++)
				System.out.print(maxHeap[i]+" ");
		}
		public static int GetTop()
		{
			int max = -1;
			 
	        if( maxhlen >= 0 )
	        {
	            max = maxHeap[0];
	        }
	 
	        return max;
		}
		public static void insert(int val){
				maxHeap[++maxhlen]=val;
				restoreUp(maxHeap,maxhlen);
		}
		public static int ExtractTop(){
			int temp=-1;
			if(maxhlen>0){
			temp=maxHeap[1];
			maxHeap[1]=maxHeap[maxhlen];
			maxhlen--;
			restoreDown(maxHeap, 1,maxhlen);
			}
			return temp;
		}
		public static void restoreUp(int[] maxHeap,int i){
			int par=i/2;
			int k=maxHeap[i];
			
			while(maxHeap[par]<k){
				maxHeap[i]=maxHeap[par];
				i=par;
				par=i/2;
			}
			maxHeap[i]=k;
		}
		
		public static void restoreDown(int[] maxHeap,int i,int hsize){
			int lchild=2*i;
			int rchild=2*i+1;
			int num=maxHeap[i];
			while(rchild<=hsize){
				if((maxHeap[lchild]<=num)&&(maxHeap[rchild]<=num)){
					maxHeap[i]=num;
					return;
				}
				else if(maxHeap[lchild]>maxHeap[rchild]){
					maxHeap[i]=maxHeap[lchild];
					i=lchild;
				}
				else{
					maxHeap[i]=maxHeap[rchild];
					i=rchild;
				}
				lchild=2*i;
				rchild=2*i+1;
			}
			if((lchild==hsize)&&(maxHeap[lchild]>num)){
				maxHeap[i]=maxHeap[lchild];
				i=lchild;
			}
			maxHeap[i]=num;
		}
	}
	public static int Signum(){
		int result;
		if(maxhlen>minhlen){
			result=1;
		}
		else if(maxhlen<minhlen){
			result=-1;
		}
		else{
			result=0;
		}
		return result;
	}
	public static int getMedian(int e, int m, MaxHeap l, MinHeap r)
	{
	    // Are heaps balanced? If yes, sig will be 0
	    int sig = Signum();
	    switch(sig)
	    {
	    case 1: // There are more elements in left (max) heap
	 
	        if( e < m ) // current element fits in left (max) heap
	            // Remove top element from left heap and
	            // insert into right heap
	        {
	            r.insert(l.ExtractTop());
	 
	            l.insert(e);
	            // current element fits in left (max) heap
	        }
	        else
	        {
	            // current element fits in right (min) heap
	            r.insert(e);
	        }
	 
	        
	        
	        // Both heaps are balanced
	        m = (l.GetTop()+r.GetTop())/2;
	 
	        break;
	 
	    case 0: // The left and right heaps contain same number of elements
	 
	        if( e < m ) // current element fits in left (max) heap
	        {
	            l.insert(e);
	            m = l.GetTop();
	        }
	        else
	        {
	            // current element fits in right (min) heap
	            r.insert(e);
	            m = r.GetTop();
	        }
	 
	        break;
	 
	    case -1: // There are more elements in right (min) heap
	 
	        if( e < m ) // current element fits in left (max) heap
	        {
	            l.insert(e);
	        }
	        else
	        {
	            // Remove top element from right heap and
	            // insert into left heap
	            l.insert(r.ExtractTop());
	 
	            // current element fits in right (min) heap
	            r.insert(e);
	        }
	 
	        // Both heaps are balanced
	        m =(l.GetTop()+r.GetTop())/2;
	 
	        break;
	    }
	 
	    // No need to return, m already updated
	    return m;
	}
	public static void printMeadian(int[] A,int size){
		
		int[] minHeap=new int[size+1];
		minHeap[0]=-1;
		int[] maxHeap=new int[size+1];
		maxHeap[0]=9999;
		int m=0;
		MinHeap minheap=new MinHeap(minHeap);
		MaxHeap maxheap=new MaxHeap(maxHeap);
		
		for(int i = 0; i < size; i++)
	    {
	        m = getMedian(A[i], m,maxheap,minheap);
	        minheap.printHeap();
			maxheap.printHeap();
	        System.out.print(" Median:"+m);;
	        System.out.println();
	    }
		minheap.printHeap();
		maxheap.printHeap();
		int median;
		if(maxhlen == minhlen){
			median= (minHeap[1] + maxHeap[1])/2;
	    }
	    else if(maxhlen > minhlen){
	         median=maxHeap[1];
	     }
	     else{
	    	 median=minHeap[1];
	     }
		//System.out.println("Minlen "+minhlen+"  Maxlen "+maxhlen);
		// 1 2 3 4 5           6 7 8 9 10
		System.out.println("Meadians of:"+Arrays.toString(A)+" : "+median);
	}
	public static void main(String[] args) {
		
		int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
				 //1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15
	    int size = A.length;
	    printMeadian(A, size);
	}
}
