package org.test.java17;

import java.util.random.RandomGeneratorFactory;
import java.util.stream.IntStream;

/**
 * 
 * 
 * In Java 17, strong encapsulation of internal APIs is enforced by default, meaning it is no longer possible 
 * to access internal JDK APIs using reflection without explicitly enabling it. 
 * This continues the trend started in Java 9 with Project Jigsaw.
Key Features:
	•	JDK internals are no longer accessible by default.
	•	Access to JDK internals can be enabled using command-line flags, but this is discouraged.



 */
public class Java17FeatureTest {

	
	public static void main(String[] args) {
	
	
	}
	
	/**
	 * Key Features:
		•	Multi-line string literals enclosed in triple quotes (""").
		•	Preserves line breaks and indentation.
		•	Eliminates the need for escaping quotes or newlines within string literals.

	 */
	public static void multilineStringLiteral(){
		String json = """
			    {
			        "name": "John",
			        "age": 30
			    }
			    """;
		System.out.println(json);
	}
	
	/**
	 
	 Key Features:
		•	Immutable data holders: Fields are implicitly final and cannot be modified after creation.
		•	Generated methods: The compiler automatically generates methods like equals(), hashCode(), and toString() for records.
		•	Compact syntax: A more compact syntax than traditional classes.

	 
	 */
	public record Point(int x, int y) {}
	
	/**
	 * •	Match patterns and types within switch cases
	 * @param obj
	 * @return
	 */
	static String formatterPatternSwitch(Object obj) {
	    return switch (obj) {
	        case Integer i -> String.format("int %d", i);
	        case Long l    -> String.format("long %d", l);
	        case Double d  -> String.format("double %f", d);
	        case String s  -> String.format("String %s", s);
	        default        -> obj.toString();
	    };
	}
	
	/**
	 *  it’s easier to use different algorithms interchangeably, and it also offers better support for stream-based programming:
	 * Legacy random classes, such as java.util.Random, SplittableRandom and SecureRandom now extend the new RandomGenerator interface.
	 * @param algorithm
	 * @param streamSize
	 * @return
	 */
	public IntStream getPseudoInts(String algorithm, int streamSize) {
	    // returns an IntStream with size @streamSize of random numbers generated using the @algorithm
	    // where the lower bound is 0 and the upper is 100 (exclusive)
	    return RandomGeneratorFactory.of(algorithm)
	            .create()
	            .ints(streamSize, 0,100);
	}

	
	/**
	 * Sealed classes, which were in preview in previous releases, are now a standard feature in Java 17. 
	 * Sealed classes allow developers to control which other classes or interfaces can extend or implement them.
	 */
	public abstract sealed class Shape permits Circle, Rectangle {}

	public final class Circle extends Shape {
	    // Circle implementation
	}

	public final class Rectangle extends Shape {
	    // Rectangle implementation
	}

}
