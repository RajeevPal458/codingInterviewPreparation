package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MultiplyArrayElementStream {

	public static void main(String[] args) {
		
		int[] arr1 = {7, 10, 4, 3, 20, 15};
		
		int list =Arrays.stream(arr1)
				.filter(num->num%2==0)
				.map(n->(n+5))
				.reduce((a,b)->a*b).getAsInt();
		System.out.println(list);
		
		// Converting int array to stream 
        int arr[] = { 1, 2, 3, 4, 5 }; 
        
        Stream<Integer> st=Stream.of(arr).flatMapToInt(i->IntStream.of(i)).boxed();
        Stream<Integer> st1 = IntStream.of(arr).boxed(); 
        Stream<Integer> st3 = Arrays.stream(arr).boxed();
        Stream<Integer> st4 = IntStream.range(0, arr.length)
        						.mapToObj(i->arr[i])
        						.mapToInt(i->i).boxed();
        IntStream stm = IntStream.of(arr); 
  
        stm.forEach(a -> System.out.print("  "+a + " ")); 
        System.out.println();
        //=============================
        		
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream()
              .map(s -> s + "") // Convert integer to String
              .filter(s -> s.startsWith("1"))
              .forEach(System.out::println);
        
        //=============================
        System.out.println();
        List<Integer> myList1 = Arrays.asList(1,1,1,2,2,2,3,4,4,5);
        Set<Integer> set = new HashSet<>();
        myList1.stream()
               .filter(n -> !set.add(n))
               .forEach(System.out::println);
        //==========================
        List<Integer> myList2 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList2.stream()
              .findFirst()
              .ifPresent(System.out::println);
        
        //===============================
        
        List<Integer> myList3 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        long count =  myList3.stream()
                            .count();
        System.out.println(count); 
        //========================
        List<Integer> myList4 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int max =  myList4.stream()
                         .max(Integer::compare)
                         .get();
        System.out.println(max); 
        //====================================================
        //7. Given a String, find the first non-repeated character in it using Stream functions?
        
        String input = "JJava articles are Awesome";
        
        Character result = input.chars() // Stream of String       
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result); 
        
        //===================================
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
 
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
         
        // Concatenated the list1 and list2 by converting them into Stream
 
        concatStream.forEach(str->System.out.print(str + " "));
         
        // Printed the Concatenated Stream
         
        //====================================
//        names.stream()
//        .map(String::toUpperCase)
//        .collect(Collectors.toList());
        
        //https://blog.devgenius.io/java-8-real-time-coding-interview-questions-and-answers-fce01f3c4080
        
        
        long sum=Arrays.stream(arr1)
				.map(i ->(int)Math.sqrt(i))
				.map(number->performComputation(number))
				.reduce(0,Integer::sum);
        
        System.out.println(sum);  
        
        
        
	}
	public static int performComputation(int number)
	{
		int sum=0;
		for (int i = 1; i < 1000000; i++) {
			int div=(number/i);
			sum+=div;
			
		}
		return sum;
	}

}
