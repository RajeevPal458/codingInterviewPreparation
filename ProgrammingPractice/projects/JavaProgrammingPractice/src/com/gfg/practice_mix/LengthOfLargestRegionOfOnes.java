package com.gfg.practice_mix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LengthOfLargestRegionOfOnes {
	static int R=4,C=5;
		static int MAX=100;
		static int initial=0;
		static int waiting=1;
		static int visited=2;
		static int NIL=-1;
		static int infinite=999999;
		static int[][] status;
		static int front,rear;
		static Possition[] queue;
		static void initializeQueue(){
			front=-1;
			rear=-1;
			queue=new Possition[MAX];
			for(int i=0;i<MAX;i++)
				queue[i]=null;
		}
		static void inQue(Possition val){
			if(rear==MAX){
				System.out.println("queue is ovrflow!");
				return;
			}
			if(front==-1)
				front=0;
			rear+=1;
			queue[rear]=val;
		}
		static Possition deQueue(){
			if(front==-1||front==rear+1){
				return null;
			}
			Possition val=queue[front];
			front+=1;
			return val;
		}
		static boolean isEmpty(){
			if(rear==-1||front==rear+1)
				return true;
			else
				return false;
		}
		
		static class Possition{
			int row,col;
			Possition(int row,int col){
				this.row=row;
				this.col=col;
			}
		}
		public static boolean isValid(int row,int col){
			if(row>=0&&row<R&&col<C&&col>=0)
				return true;
			return false;
		}
		public static int[] movex={1,0,-1,0,1,-1,-1,1};
		public static int[] movey={0,1,0,-1,1,1,-1,-1};
		
		public static ArrayList<Possition> getAdj(int row,int col,int[][] mat){
			ArrayList<Possition> adj=new ArrayList<>();
			
			if(isValid(row, col)){
				
				for(int i=0;i<movex.length;i++){
					if(isValid(row+movex[i], col+movey[i]))
						adj.add(new Possition(row+movex[i],col+movey[i]));
				}
			}
			return adj;
		}
		static int count=0;
		private static void dfsUtil(int row,int col,int[][] mat) {
			if(isValid(row, col))
			inQue(new Possition(row, col));
			status[row][col]=waiting;
			while(!isEmpty()){
				
				Possition pos=deQueue();
				count++;
				status[pos.row][pos.col]=visited;
				
				List<Possition> list=getAdj(pos.row,pos.col,mat);
				Iterator<Possition> it=list.iterator();
				while(it.hasNext()){
					Possition p=it.next();
					if((status[p.row][p.col]==initial)&&(mat[p.row][p.col]==1)){
						
						inQue(p);
						status[p.row][p.col]=waiting;
					}
				}
			}
		}
		static int maxRegion=0;
		private static void dfs(int[][] mat) {
			status=new int[R][C];
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					status[i][j]=initial;
				}
			}
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					if((mat[i][j]==1)&&(status[i][j]==initial))
					{
						dfsUtil(i,j, mat);
						if(maxRegion<count)
							maxRegion=count;
						count=0;
					}
				}
			}
		}
	
	public static void main(String[] args) {
		int[][] Mat = { {0,0,1,1,0},
						{1,0,1,1,0},
						{0,1,0,0,0},
						{0,0,0,0,1}
		 			  };
		initializeQueue();
		dfs(Mat);
		System.out.println(maxRegion);
	}
}
