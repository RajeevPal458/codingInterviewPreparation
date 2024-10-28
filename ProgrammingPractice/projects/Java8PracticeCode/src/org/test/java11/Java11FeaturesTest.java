package org.test.java11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class Java11FeaturesTest {

	public static void main(String[] args) {
		
	}
	
	/**
	 * Stream.toList() was introduced in Java 10. This method provides a more concise way to collect 
	 * elements from a stream into an immutable List. Unlike Collectors.toList(), which creates a mutable list, 
	 * Stream.toList() returns an unmodifiable list, ensuring that the list cannot be modified after 
	 * it is created.
	 */
	public void toListMethod() {
        var list = Stream.of("Java", "Python", "JavaScript")
                .toList();
        System.out.println(list);
	}
	
	/**
	 * Java 11 extends the use of the var keyword to lambda expressions. Previously introduced in Java 10, var could only be used in local variable declarations. In Java 11, it can now be used in lambda parameters to infer types.
	 */
	public void varInLAmda() {
		Stream.of("Java", "Python", "JavaScript").filter((var str)->str.startsWith("J"))
		.forEach(System.out::println);
	}
	
	/**
	 * 
	 * 
	 New String Methods:
•	isBlank(): Checks if a string contains only whitespace or is empty.
•	strip(): Removes leading and trailing whitespace (similar to trim() but more Unicode-aware).
•	stripLeading(): Removes leading whitespace.
•	stripTrailing(): Removes trailing whitespace.
•	lines(): Returns a stream of lines extracted from the string.
•	repeat(int count): Repeats the string a specified number of times.

	 */
	public void newStringMethods() {
		String str = "   Hello World   ";
	System.out.println(str.isBlank());          
	System.out.println(str.strip());           
	str = "   Hello World   ";
	System.out.println(str.stripLeading());
	System.out.println(str.stripTrailing());
	System.out.println(str.repeat(3));         

	String multiLineString = "Hello, World!\nWelcome to Java.\nEnjoy coding!";
	        
	 // Using lines() to process each line in the string
	 multiLineString.lines()
	                       .forEach(System.out::println);
	}
	
	/**
	 * 
	 Files.readString() and Files.writeString()
		Java 11 introduced methods to simplify reading and writing strings from/to files. These methods help reduce boilerplate code and make working with files more intuitive.

	 */
	public void filesNewMethods() {
		try {
			Path path = Paths.get("example.txt");
			// Write a string to the file
			Files.writeString(path, "Hello, World!");
			// Read the content of the file
			String content = Files.readString(path);
			System.out.println(content);  // Outputs: Hello, World!
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * 
	 New Optional Methods:
•	isEmpty(): Returns true if the optional is empty, false otherwise (complementing isPresent()).
•	stream(): Converts an Optional into a stream.

	 */
	public void OptionalEnhancements() {
		Optional<String> optional = Optional.of("Hello");
		optional.ifPresentOrElse(System.out::println, () -> System.out.println("Value not present"));

		Stream<String> stream= optional.isEmpty()?Stream.of(""):optional.stream();
	}

}
