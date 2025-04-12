package java8;

import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class StreamClassPractice {
	
	static IntPredicate predicate = num -> (num%2 == 0);
	public static void main(String[] args) {
		Stream<Integer> stream=  Stream.of(1,2,3,4,5,6,7,8,9);
		boolean flag1 =stream.mapToInt(i->i).allMatch(predicate);
		System.out.println(flag1);
		
		stream=  Stream.of(1,2,3,4,5,6,7,8,9);
		boolean flag2 =stream.mapToInt(i->i).anyMatch(predicate);
		System.out.println(flag2);
		
		stream=  Stream.of(1,2,3,4,5,6,7,8,9);
		flag2 =stream.mapToInt(i->i).noneMatch(predicate);
		System.out.println(flag2);
		
		
		
		stream=  Stream.of(1,2,3,4,5,6,7,8,9);
		stream.
		
		
	}

}
