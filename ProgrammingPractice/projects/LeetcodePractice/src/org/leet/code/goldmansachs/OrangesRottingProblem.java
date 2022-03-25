package org.leet.code.goldmansachs;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
public class OrangesRottingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { {2,1,1},
						{1,1,0},
						{0,1,1} };
		System.out.println(orangesRotting(arr));
	}
	
	public static int orangesRotting(int[][] arr) {
        int completed =2;
        int inque = 1;
        int initial =0;
        class Pair{
            int i;
            int j;
            Pair(int i,int j){
                this.i =i;
                this.j = j;
            }
            
            @Override
            public String toString() {
                return "Pair [i=" + i + " ,j="+j+"]";
            }
        }
        int m = arr.length;
        int n = arr[0].length;
        
        int[][] status = new int[m][n]; 
      
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                status[i][j]=initial;
            }
            
        }
        boolean flag=false;
        Queue<Pair>  queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==2){
                    queue.add(new Pair(i,j));
                    status[i][j]=inque;
                }
            }
          
            
        }
        flag=false;
        int res=-1;
        
        //System.out.println(queue+":m:"+m+":n:"+n );
        int qsize =1;
        if(queue.isEmpty())  
            res=0;
        else
        while(!queue.isEmpty()){
            Queue<Pair>  temp = new LinkedList<>();
            //System.out.println(":1:");
            while(!queue.isEmpty()){
                //System.out.println(":2:");
                Pair pair = queue.peek();
                queue.poll();
                
                int i =pair.i;
                int j = pair.j;
                status[pair.i][pair.j]=completed;
                if(i+1>=0 && i+1<m && j>=0 && j<n && arr[i+1][j]==1 && status[i+1][j]==initial ){
                    temp.add(new Pair(i+1,j));
                    status[i+1][j]=inque;
                }
                if(i>=0 && i<m && j+1>=0 && j+1<n && arr[i][j+1]==1 && status[i][j+1]==initial){
                    temp.add(new Pair(i,j+1));
                    status[i][j+1]=inque;
                }
                if(i-1>=0 && i-1<m && j>=0 && j<n && arr[i-1][j]==1 && status[i-1][j]==initial){
                    temp.add(new Pair(i-1,j));
                    status[i-1][j]=inque;
                    
                }
                if(i>=0 && i<m && j-1>=0 && j-1<n && arr[i][j-1]==1 && status[i][j-1]==initial){
                    temp.add(new Pair(i,j-1));
                    status[i][j-1]=inque;
                }
                //System.out.println(queue+":count:"+count+", i="+i+":,j:"+j);
                //System.out.println(":3:");         
                
            }
            //for(int p=0;p<m;p++)
                //System.out.println("status:"+Arrays.toString(status[p]));
            //System.out.println("temp:"+temp);
            queue=temp;
            res++;
        }
       
        
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && status[i][j]==initial){
                    res =-1;
                    //System.out.println(i+"::"+j+":st:"+status[i][j]);
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
            
        }
        
        
        return res;
    }

}
