package java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class encoraTest {
	
	public static void main(String[] args) {
		String str ="Swiss Cheese !";
		uniqueChars();
		nonRepeatingUnique();
	}
	
	
	 public static void uniqueChars() {
	        String input = "Swiss Cheese !";
	        
	        String uniqueChars = input.chars()  // Get the stream of chars from the string
	            .filter(Character::isLetterOrDigit)  // Remove non-alphanumeric characters
	            .mapToObj(c -> Character.toLowerCase((char) c))  // Convert each char to lowercase
	            .distinct()  // Keep only unique characters
	            .map(String::valueOf)  // Convert each char to a String
	            .collect(Collectors.joining());  // Join the unique characters into a single string
	        
	        System.out.println(uniqueChars);  // Output: "swiche"
	 }
	 
	 public static void nonRepeatingUnique() {
	        String input = "Swiss Cheese !";
	        // Step 1: Filter out non-alphanumeric characters and convert to lowercase
	        String result = input.chars()
	            .filter(Character::isAlphabetic)   // Remove special characters
	            .mapToObj(c -> Character.toLowerCase((char) c))   // Convert each char to lowercase
	            // Step 2: Group by character and count occurrences
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	            // Step 3: Filter out characters with a count of more than 1 (repeating characters)
	            .entrySet().stream()
	            .filter(entry -> entry.getValue() == 1)
	            .map(Map.Entry::getKey)
	            .map(String::valueOf)
	            .collect(Collectors.joining());
	        System.out.println(result);  // Output: "wch"
	    }
	 
	 public static void CharArrayToStream() {
		
		 
		 char[] arr = {'a', 'b', 'c', 'd'};

		 Stream<Character> characterStream = new String(arr)
		     .chars()                      // Convert char[] to IntStream
		     .mapToObj(c -> (char) c);     // Map int values to Character

		 characterStream.forEach(System.out::println);  
		 //========================
		 
		 
		 char[] arr1 = {'a', 'b', 'c', 'd'};

		 Stream<Character> characterStream1 = IntStream.range(0, arr1.length)
		     .mapToObj(i -> arr[i]);

		 characterStream1.forEach(System.out::println);  // Output: a b c d
		 
		 
	}

}
