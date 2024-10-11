package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Given List of names 
 * name contains firstName/MiddleName  and lastName
 * if lastName contains more duplicates will come at end
 * if two name lastName have same duplicates char then print names
 * alphabetical order by lastNmes 
 * others alphabetical order by name
 * @author rajee
 *
 */
public class SortNamesByLastNames {

	public static void main(String[] args) {
		List<String> listNames = new ArrayList<>();
		listNames.add("rajeev pal");
		listNames.add("kamlesh yadav");
		listNames.add("ravish chamar");
		listNames.add("pankaj kushwasa");
		
		listNames =listNames.stream().sorted((n1,n2)->{
			String[] n1arr =n1.split(" ");
			String[] n2arr =n2.split(" ");
			int countn1= repeatedChar(n1arr[1]);
			int countn2= repeatedChar(n2arr[1]);
			if(countn1>countn2) {
				return +1;
			}
			if(countn1<countn2) {
				return -1;
			}
			if(countn1==countn2){
				return n1arr[1].compareTo(n2arr[1]);
			}
			return n1.compareTo(n2);
		}).toList();
		System.out.println(listNames);
	}
	
	public static int repeatedChar(String str) {
		int[] num = new int[256];
		for(int i=0;i<str.length();i++) {
			num[str.charAt(i)]++;
		}
		int count=0;
		for(int i=0;i<256;i++) {
			if(num[i]>1) count++;
		}
		return count;
	}

}
