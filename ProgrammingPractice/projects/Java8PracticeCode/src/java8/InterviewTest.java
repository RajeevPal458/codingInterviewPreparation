package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java8.model.Student;

/**
 * Find 2nd highest integer number from unsorted array.
i.e., int[] arr = {7, 10, 4, 3, 20, 15}
Output: 15

 * @author rajee
 *
 *
 *Stream API: From array of integers
- Remove even numbers
- Add 5 to remaining elements
- Find multiplication of all the numbers.

i.e.,
Input: int[] arr = {7, 10, 4, 3, 20, 15}
Output: 1920
 */
public class InterviewTest {

	public static void main(String[] args) {
		
		Map<Integer, String> map =new HashMap<>();


		//map.merge(1, 1, (a,b)->a+","+b);
		
		
		//a -> return a;
		
		/**
		 * optional
		 * tx class amount 
		 * emp tx 
		 * 
		 * 
		 */
		int[] arr = {20,7, 10, 4, 3, 20, 15};
		int max =secondHighest(arr,arr.length,2);
		System.out.println("Max-"+max);
		int max2 =secondHighest2(arr,arr.length);
		System.out.println("second Highest -"+max2);
		
		int[] arr1 = {7, 10, 4, 3, 20, 15};
		
		int list =Arrays.stream(arr1)
				.filter(num->num%2==0)
				.map(n->(n+5))
				.reduce(1,(a,b)->a*b);
		System.out.println(list);
		
		
		System.out.println("find the first non repeated char using java8");
		String str = "geeksforgeeks";
		
		str.chars().mapToObj(x->(char)x)
		.collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()==1)
		.findFirst()
		.ifPresent(entry->System.out.println("1 First Non Repeated Char-"+entry.getKey()));
			
		IntStream.range(0,str.length()).mapToObj(i->str.charAt(i))
		.collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()==1)
		.findFirst()
		.ifPresent(entry->System.out.println("2 First Non Repeated Char-"+entry.getKey()));
			
		
		System.out.println("---average mark of all students using java8---");
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("Rajeev","hindi",85));
		students.add(new Student("kamlesh","hindi",80));
		students.add(new Student("pankaj","hindi",79));
		students.add(new Student("monu","hindi",82));
		students.add(new Student("deepak","hindi",60));
		students.add(new Student("mukesh","hindi",73));
		students.add(new Student("raman","hindi",55));
		students.add(new Student("Rajeev","hindi",90));
		ToIntFunction<Double> fun = new ToIntFunction<Double>() {
			@Override
			public int applyAsInt(Double value) {
				// TODO Auto-generated method stub
				return value.intValue();
			}
		};
		double average =students.stream().map(std->std.getMarks())
		.mapToInt(val->val.intValue()).average().getAsDouble();
		System.out.println("average -- "+average);
		
		
		System.out.println("check given string is pelindrome---");
		String str1 = "radar";
		String str2 = "apple";
		//IntStream.of(1,2,3,4,5,6).forEach(i->System.out.print(i+" "));;
		boolean isStr1Pelindrome = IntStream.range(0, str1.length()/2)
		.allMatch(i->str1.charAt(i)==str1.charAt(str1.length()-i-1));
		
		boolean isStr2Pelindrome = IntStream.range(0, str2.length()/2)
				.allMatch(i->str2.charAt(i)==str2.charAt(str2.length()-i-1));
		
		System.out.println("isStr1Pelindrome-"+isStr1Pelindrome +" isStr2Pelindrome-"+isStr2Pelindrome);
		
		
		System.out.println("Check if Two Strings Are Anagrams in Java");
		
		String str3="geeks";
		String str4="skege";
		
		
		
	}
	// using two varriables
	// handle duplicates
	private static int secondHighest2(int[] arr, int n) {
		int max =arr[0];
		int secondmx=-1;
		for(int i=1;i<n-1;i++) {
			if(arr[i]>max) {
				secondmx =max;
				max =arr[i];
			}
		}
		
		return secondmx;
	}
	//for duplicates it will not work
	private static int secondHighest(int[] arr, int n,int k) {
		int count=0;
		while(count++<k) {
			for(int i=0;i<n-1;i++) {
				if(arr[i]>arr[i+1]) {
					swap(arr,i,i+1);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr[n-2];
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j] =temp;
	}

	
	
	
	
	
	
}
