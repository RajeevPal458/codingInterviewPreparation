package com.bt.stringarr.mix;
import java.util.Arrays;

public class SnakeLadderProblems {
	int MAX=50;
	queueEntry[] queue;
	int initial=1;
	int wait=2;
	int visited=3;
	int[] status;
	SnakeLadderProblems(int N){
		queue=new queueEntry[N];
		this.status=new int[N];
		for(int i=0;i<N;i++)
			status[i]=initial;
	}
	class queueEntry
	{
	    int v;     // Vertex number
	    int dist;  // Distance of this vertex from source
	    public queueEntry(int v,int dist){
	    	this.v=v;
	    	this.dist=dist;
	    }
	    public queueEntry(){}
	    	
	}
	private int getMinDiceThrows(int[] move, int N) {
		queueEntry s=null;
		int count=0;
		queueEntry e=new queueEntry(0,0);
		inQue(e);
		status[e.v]=wait;
		while(!isEmpty()){
			
			s=deQueue();
			//System.out.println(Arrays.toString(queue));
			status[s.v]=visited;
			System.out.println("Source:"+s.v+"  Distance:"+s.dist);
			count++;
			if(s.v==29)
				break;
			int v=s.v;
			for(int i=v+1;i<=v+6&&i<N;i++){
				if(status[i]==initial)
				{ 
					queueEntry e1=new queueEntry();
					e1.dist = (s.dist + 1);
					status[i]=wait;
					if(move[i]!=-1)
					 e1.v=move[i]; 
					else
						e1.v=i;
					inQue(e1);
					
				}
					
			}
			
		}
		
		return s.dist;
	}
	int front=-1,rear=-1;
	public void inQue(queueEntry val){
		if(rear==MAX){
			System.out.println("queue is ovrflow!");
			return;
		}
		if(front==-1)
			front=0;
		rear+=1;
		queue[rear]=val;
	}
	public queueEntry deQueue(){
		if(front==-1||front==rear+1){
			System.out.println("Queue is underflow!");
			return null;
		}
		queueEntry val=queue[front];
		front+=1;
		return val;
	}
	public boolean isEmpty(){
		if(rear==-1||front==rear+1)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// Board of snak ladder game.......
		//Lets N=30;
		int N=30;
		int[] move=new int[N];
		for(int i=0;i<N;i++)
			move[i]=-1;
		//Ladder
		move[2]=21;
		move[4]=7;
		move[10]=25;
		move[19]=28;
		//snake
		move[26]=0;
		move[20]=8;
		move[16]=3;
		move[18]=6;
		SnakeLadderProblems sl=new SnakeLadderProblems(N);
		System.out.println("Minimum dice trows required is:"+sl.getMinDiceThrows(move,N));
	}

}
