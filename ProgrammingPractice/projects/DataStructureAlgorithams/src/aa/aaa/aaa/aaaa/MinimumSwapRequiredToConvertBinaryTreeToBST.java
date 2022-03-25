package aa.aaa.aaa.aaaa;
import java.util.Arrays;
import java.util.Comparator;

public class MinimumSwapRequiredToConvertBinaryTreeToBST {

	static int[] inorder=null;
	static int i=0;
	public static void inOrderTraversal(int[] arr,int child,int len){
		System.out.println(child);
		
		if(len==1){
			inorder=arr;
			return;
		}
		if(child>=len){
			return;
		}
		inOrderTraversal(arr,2*child+1,len);
		inorder[i++]=arr[child];
		inOrderTraversal(arr,2*child+2,len);
	}
	public static int swapToSortArray(int[] inOrder,int[] arr,int len){
		class Pair{
			int val;
			int preIndex;
			Pair(int val,int preIndex){
				this.val=val;
				this.preIndex=preIndex;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Val:"+val+" PreIndex :"+preIndex+"";
			}
		}
		Pair[] move=new Pair[len];
		for(int i=0;i<len;i++){
			move[i]=new Pair(inOrder[i],i);
		}
		Arrays.sort(move,new Comparator<Pair>() {

			@Override
			public int compare(Pair a0, Pair a1) {
				// TODO Auto-generated method stub
				if(a0.val>a1.val)
					return 1;
				else if(a0.val<a1.val)
					return -1;
				else
					return 0;
			}
		});
		boolean vist[]=new boolean[len];
		Arrays.fill(vist, false);
		int res=0;
		System.out.println(Arrays.toString(move));
		for(int i=0;i<len;i++){
			
			if(vist[i]||move[i].preIndex==i)
				continue;
			int j=i;
			int count=0;
			while(!vist[j]){
				vist[j]=true;
				count++;
				j=move[j].preIndex;
			}
			res+=(count-1);
		}
		return res;
	}
	public static void findMinimumSwap(int[] arr,int n){
		
		inOrderTraversal(arr, 0, n);
		System.out.println(":"+Arrays.toString(inorder));
		int ans=swapToSortArray(inorder,arr,n);
		System.out.println("Minimum swap required:"+ans);
	}
	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 11 };
		int len=arr.length;
		inorder=new int[len];
		findMinimumSwap(arr, len);
		
	}
}
