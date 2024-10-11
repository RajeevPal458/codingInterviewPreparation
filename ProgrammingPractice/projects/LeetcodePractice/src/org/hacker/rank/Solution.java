package org.hacker.rank;
import java.io.*;
import java.util.*;


public class Solution {
    int[] pathx= {1,0,-1,0};
    int[] pathy= {0,1,0,-1};
    int sortestPath=Integer.MAX_VALUE;
   char wall ='#';
   int m,n;
   Node[][] pred=null;
   public Solution(int R,int C){
       this.m=R;
       this.n=C;
   }
   class Node implements Comparable<Node>{
       int x;
       int y;
       int dist;
       public Node(int x,int y, int dist){
           this.x=x;
           this.y=y;
           this.dist=dist;
       }
       
       @Override
       public int compareTo(Node other) {
           return Integer.compare(this.dist, other.dist);
       }
       @Override
       public String toString(){
           return dist+" ";
       }
   }
   
   public int[] getMin(int[][] temp,boolean[][] status){
       int min=Integer.MAX_VALUE;
       int x=-1;
       int y=-1;
       
       for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
               if( !status[i][j] && temp[i][j]<min){
                   min=temp[i][j];
                   x=i;
                   y=j;
               }
           } 
       }
       return new int[]{x,y};
   }
   
   public boolean isSafe(boolean[][] visited,int i,int j) {
       return (i>=0&&i<m &&j>=0 && j<n && !visited[i][j]);
   }
   public int shortestPath(char[][] mat,int x,int y,char target){
       
       int minDistance=Integer.MAX_VALUE;
       int[][] pathlen = new int[m][n];
       pred = new Node[m][n];
       for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
               pathlen[i][j]=Integer.MAX_VALUE;
               pred[i][j] = new Node(-1, -1,0);
           } 
       }
       boolean[][] visited = new boolean[m][n];
       pathlen[x][y] = 0;
       
       while(true){
           int[] curr = getMin(pathlen,visited);
           int i=curr[0];
           int j=curr[1];
           if(i<0) break;
           visited[i][j] = true;
           if(mat[i][j]==target){
               if(minDistance>pathlen[i][j]){
                   minDistance = pathlen[i][j];
               }
               if(minDistance==0) return minDistance;
           }
           
           for(int k=0;k<pathx.length;k++){
               int nextx=i+pathx[k];
               int nexty=j+pathy[k];
               if(isSafe(visited,nextx,nexty)){ 
                   if(mat[nextx][nexty]==wall){
                       if(pathlen[i][j]+1 < pathlen[nextx][nexty]){
                           pathlen[nextx][nexty] = pathlen[i][j]+1;
                           pred[nextx][nexty] = new Node(i,j,0);
                       }
                   }else{
                       pathlen[nextx][nexty] = pathlen[i][j];
                       pred[nextx][nexty] = new Node(i,j,0);
                   }
                   
               }
           }
       }
       return minDistance;
   }
     
   public int borderDist(char[][] mat,int x,int y){
     
       int minDistance=Integer.MAX_VALUE;
       int[][] pathlen = new int[m][n];
       for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
               pathlen[i][j]=Integer.MAX_VALUE;
           } 
       }
       boolean[][] visited = new boolean[m][n];
       pathlen[x][y] = 0;
       
       while(true){
           int[] curr = getMin(pathlen,visited);
           int i=curr[0];
           int j=curr[1];
           if(i<0) break;
           visited[i][j] = true;
           if((i<=0||j<=0||i>=m-1||j>=n-1 )){
               if(minDistance>pathlen[i][j]){
                   minDistance = pathlen[i][j];
               }
               if(minDistance==0) return minDistance;
           }
           
           for(int k=0;k<pathx.length;k++){
               int nextx=i+pathx[k];
               int nexty=j+pathy[k];
               if(isSafe(visited,nextx,nexty)){ 
                   if(mat[nextx][nexty]==wall){
                       if(pathlen[i][j]+1 < pathlen[nextx][nexty]){
                           pathlen[nextx][nexty] = pathlen[i][j]+1;
                       }
                   }else{
                       pathlen[nextx][nexty] = pathlen[i][j];
                   }
                   
               }
           }
       }
       return minDistance;
   }
   public List<Node> getShortestPath(char[][] mat,int s1, int s2, int d1, int d2) {
		List<Node> list = new ArrayList<Node>();
		Node pre = new Node(d1, d2,0);
		do {
			list.add(pre);
			mat[pre.x][pre.y]='.';
			if(pre.x==s1 && pre.y==s2) {
				break;
			}
			Node Node = pred[pre.x][pre.y];
			pre = Node;
			if(pre.x<0 || pre.y<0) break;
		}while(true);
		
		return list;
	}
   
   static Scanner sc = new Scanner(System.in) ;
   public static void main(String[] args) {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       String[] input1 = sc.nextLine().split(" ");
       int R = Integer.parseInt(input1[0]);
       int C = Integer.parseInt(input1[1]);
       char[][] mat = new char[R][C];
       int[] src = new int[2];
       int[] dest = new int[2];
       char target = ' ';
       for(int i=0;i<R;i++){
           String col = sc.nextLine();
           for(int j=0;j<C;j++){
               mat[i][j] = col.charAt(j);
               if(mat[i][j]=='S'){
                   src[0]=i;src[1]=j;
               }
               if(mat[i][j]=='P'){
                   target =mat[i][j];
                   dest[0]=i;dest[1]=j;
               }
           }
       }
       Solution solution = new Solution(R,C);
       int path =solution.shortestPath(mat,src[0],src[1],target);
       List<Node> sortestPath = solution.getShortestPath(mat,src[0],src[1],dest[0],dest[1]); 
       System.out.println(sortestPath);
       int minWallsToBorder = solution.borderDist(mat,src[0],src[1]);
       
       System.out.println("path:"+path+" minWallsToBorder: "+minWallsToBorder);
       if(path==Integer.MAX_VALUE)
           System.out.println("DOOMED");
       else
           System.out.println(path+minWallsToBorder);
       
   }


}