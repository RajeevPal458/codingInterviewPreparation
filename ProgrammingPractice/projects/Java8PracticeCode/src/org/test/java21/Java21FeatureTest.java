package org.test.java21;
class Shape{
	
}
class Circle extends Shape {

	public String radius() {
		// TODO Auto-generated method stub
		return null;
	}

}
class Rectangle  extends Shape {

	public String width() {
		// TODO Auto-generated method stub
		return null;
	}

	public String height() {
		// TODO Auto-generated method stub
		return null;
	}

}
/**
 * ##{@link #clone()}
 * ***
 * 
 * '''
 * 
 * '''
 */
public class Java21FeatureTest {

	public static void main(String[] args) {
		newStringMethods();
	}
	
	/**
	 * 	•	String::repeat(int count): Repeats the string a specified number of times.
		•	String::stripIndent(): Removes the common leading whitespace from each line.
		•	String::translateEscapes(): Translates Unicode escape sequences in strings.

	 */
	public static void newStringMethods() {
		String str ="java";
		String indented = """
		        Hello
		            World
		        """.stripIndent(); 
		System.out.println(str.repeat(3));
		System.out.println(indented);
		
		String escaped = "Line1\nLine2".translateEscapes(); 
		System.out.println(escaped);
	}
	
	
	/**
	 * ### pattern matching with type cast
	 * ```
	 * The instanceof operator can now use type patterns, allowing developers to check the type and cast in a single step.
	 * ```
	 * @param obj
	 */
	public static void patternMatching(Object obj) {
		if (obj instanceof String s) {
		    System.out.println(s.toUpperCase());  // Implicitly casts to String
		}

	}
	/**
	 * now we can match subclasses in switch cases
	 * @param shape
	 * @return
	 */
	public static String formatShape(Shape shape) {
	    return switch (shape) {
	        case Circle c -> "Circle with radius: " + c.radius();
	        case Rectangle r -> "Rectangle with width: " + r.width() + " and height: " + r.height();
	        default -> "Unknown shape";
	    };
	}

	
}


