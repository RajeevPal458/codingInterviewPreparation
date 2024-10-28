package org.test.java9;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/**
 * 
 Key Features:
•	Private Methods in Interfaces: These methods cannot be overridden by implementing classes and are only available to other methods in the interface.

 */
interface MyInterface {
    default void defaultMethod() {
        helperMethod();
    }

    private void helperMethod() {
        System.out.println("Helper Method");
    }
}


public class Java9FeaturesTest {

	public static void main(String[] args) {
		
	}
	
	/**
	 * Key Features:
•	Immutable: The created collections are immutable.
•	Concise: You no longer need to use Arrays.asList() or manually add elements.

	 */
	public void factorymethods() {
		List<String> list = List.of("A", "B", "C");
		Set<Integer> set = Set.of(1, 2, 3);
		Map<Integer, String> map = Map.of(1, "One", 2, "Two");

	}
	
	/**
	 New Methods in Stream API:
•	takeWhile(Predicate): Takes elements from the stream as long as the predicate is true.
•	dropWhile(Predicate): Drops elements while the predicate is true and processes the rest.
•	ofNullable(T element): Returns a stream of a single element if present, or an empty stream if null.
•	iterate(T seed, Predicate, UnaryOperator): An overload of the iterate method that supports a condition to stop.

	 */
	public void streamApi() {
		
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);
		List<Integer> result = stream.takeWhile(n -> n < 5).collect(Collectors.toList());  // [1, 2, 3, 4]
		List<Integer> result2 = stream.dropWhile(n -> n < 5).collect(Collectors.toList());  // [1, 2, 3, 4]
		
		
		String value = null;
        // ofNullable: If the value is null, it returns an empty stream
        Stream.ofNullable(value)
              .forEach(System.out::println);  // Output: (no output because it's null)
        value = "Hello, World!";
        Stream.ofNullable(value)
              .forEach(System.out::println);  // Output: Hello, World!

        
     // Generate numbers from 1 to 10 using iterate
        Stream.iterate(1, n -> n <= 10, n -> n + 1)
              .forEach(System.out::println);  // Output: 1, 2, 3, ... 10


	}
	
	/**
	 * 
	 •	ifPresentOrElse(): Executes an action if a value is present, or runs an alternative action if not.
•	or(): Returns an alternative optional if the value is not present.
•	stream(): Converts an Optional into a stream

	 */
	public void optionalApi() {
		Optional<String> optional = Optional.of("Hello");
		optional.ifPresentOrElse(
		    System.out::println,
		    () -> System.out.println("Value is not present")
		);

	}
	
	/**
	 the internal representation of the String class:
In Java 9, the internal representation of the String class was changed to store the underlying data in a byte[] array instead of a char[] array. This enhancement was part of the Compact Strings optimization introduced to improve memory efficiency, especially for strings that contain only Latin-1/ISO-8859-1 characters.

	 */
	public void StringInternal() {
        String asciiString = "Hello";  // Contains only Latin-1 characters
        String unicodeString = "こんにちは"; // Contains UTF-16 characters
        
        // Internally, 'asciiString' is stored using a byte array with 1 byte per character
        // 'unicodeString' is stored using a byte array with 2 bytes per character
        System.out.println("ASCII String: " + asciiString);
        System.out.println("Unicode String: " + unicodeString);

	}
	
	/**
	 * 
	CompletableFuture was introduced in Java 8 to handle asynchronous programming. Java 9 introduces several enhancements and new methods to this API, making it more powerful for building asynchronous pipelines.
New Methods:
•	new CompletableFuture.completedFuture(T value): Returns a completed CompletableFuture.
•	orTimeout(): Completes the future with a TimeoutException if it does not complete within a specified time.
•	completeOnTimeout(): Completes the future with a specified value if it does not complete within the specified time.
•	copy(): Returns a new CompletableFuture that has the same completion state.
Benefits:
•	Simplifies handling of timeouts in asynchronous code.
•	Easier to work with asynchronous programming patterns.

	 */
	public void CompletableFuture () {
		CompletableFuture future =CompletableFuture.completedFuture("rajeev")
				.orTimeout(12, TimeUnit.NANOSECONDS)
				.copy();
	}
}
