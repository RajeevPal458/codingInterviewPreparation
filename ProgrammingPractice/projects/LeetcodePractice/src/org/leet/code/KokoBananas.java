package org.leet.code;

public class KokoBananas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] piles = {30,11,23,4,20};
		int h = 5;		
		System.out.println("::minEatingSpeed::"+minEatingSpeed(piles, h));
	}
	
	 public static int minEatingSpeed(int[] piles, int h) {
	       int k=0;
	       while(true){
	        k = k+1;  
	        int i=0;
	        int hr=0;
	        System.out.println("k:"+k);
	        while(i < piles.length){
	            int pileVal =piles[i];
	            System.out.println("i:"+i+":-pileVal-:"+pileVal);
	            while(pileVal>0){
	                hr +=1;
	                pileVal =pileVal-k; 
	                System.out.println("pileVal:"+pileVal);
	            }
	            i++;
	        }
	        if(hr ==h)
	            break;
	       }
	        return k;
	    }

}
