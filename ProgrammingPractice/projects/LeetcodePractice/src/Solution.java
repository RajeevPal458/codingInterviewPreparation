import java.io.*;
import java.util.*;


public class Solution {
	int[] pathx= {1,0};
    int[] pathy= {0,1};
    int m;
    int n;
    int[][] mat;
    public Solution(int m,int n,int[][] mat){
        this.m=m;
        this.n=n;
        this.mat = mat;
    }
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public boolean isSafe(boolean[][] visited,int i,int j) {
        return (i>=0&&i<m &&j>=0 && j<n && !visited[i][j] && mat[i][j]==1);
    }
    public void bfs() {
        
        Queue<Pair> queue = new LinkedList<Pair>();
        Pair[][] pred = new Pair[m][n];
        boolean[][] status = new boolean[m][n];
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int i=curr.x;
            int j=curr.y;
            status[i][j]=true;
            if(i==m-1 && j==n-1){
                break;
            }
            for (int k=0;k<pathx.length;k++) {
            	int nextx=i+pathx[k];
                int nexty=j+pathy[k];
                if (isSafe(status,nextx,nexty)) {
                	 pred[nextx][nexty] = new Pair(i,j);
                     queue.add(new Pair(nextx, nexty));
                }
            }
        }
        
        int[][] result = new int[m][n];
        
        Pair pre = new Pair(m-1, n-1);
		do {
			result[pre.x][pre.y]=1;
			if(pre.x==0 && pre.y==0) {
				break;
			}
			Pair Node = pred[pre.x][pre.y];
			pre = Node;
			if(pre.x<0 || pre.y<0) break;
		}while(true);
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
    }
static Scanner sc = new Scanner(System.in) ;
    public static void main(String[] args) {
     
       int R = Integer.parseInt(sc.nextLine());
       int C = Integer.parseInt(sc.nextLine());
       int[][] mat = new int[R][C];
   
       for(int i=0;i<R;i++){
           String[] col = sc.nextLine().split(" ");
           for(int j=0;j<C;j++){
               mat[i][j] = Integer.parseInt(col[j]);
           }
       }
       Solution solution = new Solution(R,C,mat);
       solution.bfs();
    }
}