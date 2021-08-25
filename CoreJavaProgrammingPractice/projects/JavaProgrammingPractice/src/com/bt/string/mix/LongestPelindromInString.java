package com.bt.string.mix;

import java.util.Arrays;

public class LongestPelindromInString {
	
	public static void print(String[] suffixes){
		System.out.println();
		Arrays.sort(suffixes);
        System.out.println("Sorted Suffixes: ");
        //for(String sss:suffixes)System.out.println(sss);
        System.out.println("sortArrayOfStringRedixSort"+Arrays.toString(suffixes));
	}
	public static void print1(String[] peffixes){
		System.out.println();
		for(int i=0;i<peffixes.length;i++)
		{
			peffixes[i]=new StringBuffer(peffixes[i]).reverse().toString();
		}
		Arrays.sort(peffixes);
        System.out.println("Sorted peffixes: ");
        for(String sss:peffixes)System.out.println(sss);
        
	}
	public static void getSuffixOfString(String s,String[] suffixes){
		int N = s.length();
        
        System.out.println("Suffixes: ");
        for(int i=0;i<suffixes.length;++i){
            suffixes[i] = s.substring(i);
            System.out.println(suffixes[i]);
        }
	}
	public static void getPreffixOfString(String s,String[] suffixes){
		int N = s.length();
        
        System.out.println("Preffixes: ");
        for(int i=suffixes.length-1;i>=0;--i){
            suffixes[i] = s.substring(0,i);
            System.out.println(suffixes[i]);
        }
	}

	public static int lcp(String s, String ss){
        int i=0;
        for(;i<Math.min(s.length(),ss.length());++i){
            if(s.charAt(i)!=ss.charAt(i))break;
        }
        return i;
    }
	public static void lcpl(String[] suffx,String[] suffy){
		int maxlcp=0,lcp=0;
		String str="";
		int sx=0,sy=0,ex=suffx.length-1,ey=suffy.length-1;
		int min=Math.min(ex,ey);
		//System.out.println("1");
		while(sx<=min&&sy<=min){
			//System.out.print(" 2 sux:"+suffx[sx]+" suy:"+suffy[sy]+" ");
			lcp=lcp(suffx[sx],suffy[sy]);
			
			//System.out.print(" "+lcp+" ");
			//System.out.println();
			if(maxlcp<lcp)
			{
				maxlcp=lcp;
				str=suffx[sx].substring(0, lcp);
			}
			int res=suffx[sx].compareTo(suffy[sy]);
			if(res<0)
				sx++;
			else
				sy++;
		}
		
		System.out.println("LCS_LEN:"+maxlcp+" LCS "+str);
	}
	public static void countSort(String[] arr,int len,int k){
		String[] B=new String[len+1];
		int[] c=new int[30];
		Arrays.fill(c,0);
		for(int i=0;i<=len;i++)
			if(arr[i]!=null)
				c[(k<arr[i].length())?arr[i].charAt(k)-'a':0]++;
		for(int i=1;i<c.length;i++)
			c[i]+=c[i-1];
		for(int i=len;i>=0;i--){
			if(arr[i]!=null)
				B[c[(k<arr[i].length())?arr[i].charAt(k)-'a':0]-1]=arr[i];
			if(arr[i]!=null)
				c[(k<arr[i].length())?arr[i].charAt(k)-'a':0]--;
		}
		for(int i=0;i<=len;i++)
			arr[i]=B[i];
	}
	public static int maxlen(String[] arr,int len){
		int max=0,n=0;
		for(int i=0;i<len;i++){
			n=arr[i].length();
			if(max<n)
				max=n;
		}
		return max;
	}
	public static void sortArrayOfStringRedixSort(String[] arr,int len,int k){
		for(int i=k-1;i>=0;i--){
			countSort(arr,len-1,i);
		}
	}
	public static void main(String[] args) {
		String x = "adabccbabad";
		String[] suffx = new String[x.length()+1];
		String[] peffx = new String[x.length()+1];
		getSuffixOfString(x,suffx);
		/*getPreffixOfString(x,peffx);
		System.out.println();
		print(suffx);
		print1(peffx);
		lcpl(suffx, peffx);*/
		sortArrayOfStringRedixSort(suffx, suffx.length,maxlen(suffx, suffx.length));
		System.out.println("sortArrayOfStringRedixSort"+Arrays.toString(suffx));
		System.out.println();
		print(suffx);
	}
}
