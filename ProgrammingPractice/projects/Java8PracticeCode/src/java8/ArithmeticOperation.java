package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArithmeticOperation {


	  public static void main(String []args){
		  
		  int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		  Stream<int[]> stream = Stream.of(array);
		  
		// Creating a list of Strings 
        List<String> list = Arrays.asList("1", "2", "3", 
                                          "4", "5"); 
        list.stream().flatMapToInt(num -> IntStream.of(Integer.parseInt(num))). 
        forEach(System.out::println); 
        System.out.println("----");
        list.stream().map(num -> Integer.parseInt(num)). 
        forEach(System.out::println);
	        
	     int arr[] = {10,20, 5, 25,30,30};  
	     
	     int sum=Stream.of(arr).flatMapToInt(num->IntStream.of(num)).sum();
	     System.out.println("sum-> "+sum);
	     int sum2=Arrays.stream(arr).sum();
	     
	     int sum3=IntStream.range(0, arr.length).mapToObj(i->arr[i])
	     .mapToInt(i->i).sum();
	     
	     int sum4 =IntStream.of(arr).sum();
	     
	     System.out.println("sum-> "+sum+" , sum-> "+sum2+" , sum-> "+sum3+" , sum4-> "+sum4);
	     
	     String[] strarr = {"RED","GREEN","YELLO","PINK","WHITE","BLACK"};
	     
	     char charAny=Arrays.stream(strarr).map(st->st.charAt(0)).findAny().get();
	     System.out.println("charAny ->"+charAny);
	     char charFirst=Arrays.stream(strarr).map(st->st.charAt(0)).findFirst().get();
	     System.out.println("charFirst ->"+charFirst);
	     char charLast=Arrays.stream(strarr).map(st->st.charAt(0)).reduce((first,second)->second).get();
	     System.out.println("charLast ->"+charLast);
	     
	     Stream<String> strObject= Stream.of(strarr);
	     
			
	  }
	  // get the sum of even numbers
	  private static void sumOfEvenNumbers(Set<Integer> numbers){
		int evenSum = 0;
	    //TODO your code/implementation logic here
		evenSum =numbers.stream().collect(Collectors.summingInt(Integer::valueOf));
		
		System.out.println("Sum of even numbers = " + evenSum);
		System.out.println("-----------------------------------------------------------------------1");
		evenSum =numbers.stream().reduce(0,(a, b) -> a + b);
		
		System.out.println("Sum of even numbers = " + evenSum);
		System.out.println("-----------------------------------------------------------------------2");
		
		evenSum =numbers.stream().mapToInt(Integer::valueOf).sum();
		
		System.out.println("Sum of even numbers = " + evenSum);
		System.out.println("-----------------------------------------------------------------------3");
		
		
	  }

}
