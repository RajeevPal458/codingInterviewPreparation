package org.algo.algo;
import java.util.Arrays;

//Two Activity is said to be non conflicting if starting time of one activity is greater then finishing time of previous activity!
public class ActivityAndFinishTimeGridyAlgo {
	public void swap(int[] arr,int i,int j){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	public void findNonConflictingActivity(int[] start,int[] finish,int[] activity){
		int len=start.length;
		int min,minInd;
		for(int i=0;i<len-1;i++){
			min=i;
			for(int j=i+1;j<len;j++){
				min=(finish[min]<finish[j])?min:j;
			}
			swap(finish,i,min);
			swap(start,i,min);
			swap(activity,i,min);
		}
		System.out.println();
		System.out.println(Arrays.toString(activity));
		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(finish));
		
		int prev=0;
		System.out.print("a"+activity[prev]+" ");
		prev=finish[0];
		for(int i=1;i<len;i++){
			
			if(start[i]>prev){
				prev=finish[i];
				System.out.print("a"+activity[i]+" ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
	int[] activity={1,2,3,4,5,6,7,8};
	int[] start=   {1,0,1,4,2,5,3,4};
	int[] finish=  {3,4,2,6,9,8,5,5};
	ActivityAndFinishTimeGridyAlgo nca=new ActivityAndFinishTimeGridyAlgo();
	nca.findNonConflictingActivity(start,finish,activity);
	
	//System.out.print("a"+activity[0]+" ");
	
		
	}
}
