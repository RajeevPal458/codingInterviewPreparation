package org.algo.linkedList;

public class Anagram {
	public static void main(String[] args) {
		 String haystack = "ABCDSGDABCSAGAABCCCCAAABAABC";
		 String needle = "ABC";
		 char [] needl = needle.toCharArray();
		 int needleLen = needle.length();
		 int found=0;
		 char hay[] = haystack.toCharArray();
		 int index =0;
		 int chMatched =0;

		 for (int i=0; i<hay.length; i++){

		  if (index >= needleLen || chMatched==0)
		   index=0;
		  System.out.print("\nchar-->"+hay[i] + ", with->"+needl[index]);

		  if(hay[i] == needl[index]){
		   chMatched++;
		   System.out.println(", matched");
		  }else {
		   chMatched=0;
		   index=0;
		   if(hay[i] == needl[index]){
		    chMatched++;
		    System.out.print("\nchar->"+hay[i] + ", with->"+needl[index]);
		    System.out.print(", matched");
		   }else
		   continue;
		  }

		  if(chMatched == needleLen){
		   found++;
		   System.out.println("found. Total ->"+found);
		  }
		  index++;
		 } 
		 System.out.println("Result Found-->"+found);
		 }
}
