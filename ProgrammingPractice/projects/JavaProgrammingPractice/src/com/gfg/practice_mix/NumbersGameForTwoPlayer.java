package com.gfg.practice_mix;

import java.util.Arrays;

public class NumbersGameForTwoPlayer {
static int N=20;
static int[] nums;
static Factors[] factArr;

	public NumbersGameForTwoPlayer(){
		nums=new int[N];
		factArr=new Factors[N];
	}
	static class Factors{
		int factor;
		Factors next;
		public Factors(int factor){
			this.factor=factor;
			this.next=null;
		}
	}
	// Add all Factors into Factors Array
	public static void addFactorsInToFactorsArray(){
		
		for(int i=0;i<N;i++){
			factArr[i]=findFactorsOfANumber(nums[i]);
			//System.out.println("1");
		}
		
	}
	static Factors ptr;
	public static Factors findFactorsOfANumber(int num){
		ptr=null;
		int self=num;
		boolean flage=false;
		for(int i=2;num>1;i++){
			//System.out.println("2:"+num+" i:"+i);
			while(num!=0&&num%i==0){
				num=num/i;
				flage=true;
				//System.out.println("3");
			}
			if(flage){
				if(i!=self&&i!=1)
					addInToList(i);
				flage=false;
			}
			//System.out.print("             "+num);
		}
		return ptr;
	} 
	private static void addInToList(int i) {
		// TODO Auto-generated method stub
		Factors temp=new Factors(i);
		temp.next=ptr;
		ptr=temp;
		//System.out.println("4");
	}
	static int count=0;
	public static void printList(Factors start){
		if(start==null)
			return ;
		else{
			//System.out.println("5");
			Factors p=start;
			while(p!=null){
				System.out.print(p.factor+" ");
				p=p.next;
			}
		}
		System.out.println();
	}
	public static void printFactors(){
		
		for(int i=0;i<N;i++){
			System.out.print("num"+nums[i]+"  :");
			printList(factArr[i]);
			System.out.println();
		}
	}
	public static void gamePlay(int[] nus){
		// Two players are A & B;
		// A will Win if Total Factors are odd bec A start to play game
		// B will win if Total Factors are even bec game ends with B and A will not gate any of  prime 
		int count=0;
		/*for(int i=0;i<N;i++){
			
			
		}*/
	}

	public static void main(String[] args) {
		new NumbersGameForTwoPlayer();
		for(int i=2;i<N+2;i++){
			nums[i-2]=i;
		}
		System.out.println(Arrays.toString(nums));
		addFactorsInToFactorsArray();
		System.out.println();
		printFactors();
		//System.out.println("1");
	}
}
