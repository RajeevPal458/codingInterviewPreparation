package aa.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArithmeticOperation {


	  public static void main(String []args){
		  
	     Integer arr[] = {10,20, 5, 25,30,30};  
	     
	     Set<Integer> numbers = new HashSet<>(Arrays.asList(arr)); 
	     
	     Optional<Integer> num = numbers.stream().findAny();
			Optional<Integer> num1= numbers.stream().findFirst();
			
			System.out.println(":num:"+num+":num1:"+num1);
			
			
	     
	     sumOfEvenNumbers(numbers);
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
