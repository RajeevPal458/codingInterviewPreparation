package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Java8Test {

	public static void main(String[] args) {
		Consumer<Integer> consumer =t -> System.out.print(t); 
		
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(4);
		list.add(4);
		list.add(8);
		list.add(9);
		list.add(0);
		list.stream().sorted()
					.limit(5)
					.skip(2)
					.distinct()
					.forEach(System.out::println);
		System.out.println("--------------");
		list.stream().sorted()
					 .limit(5)
					 .skip(2)
					 .distinct()
					 .peek(System.out::println)
					 .count();
		
		System.out.println();
		System.out.println("first --parallel process print");
		Stream.of("AAA","BBB","CCC").parallel().forEach(s->System.out.println("Output:"+s));
		System.out.println("first --parallel process print");
		Stream.of("AAA","BBB","CCC").parallel().forEachOrdered(s->System.out.println("Output:"+s));
		
		System.out.println("--------stream vs parallelStream------");
		list.stream().forEach(System.out::println);
		System.out.println("-------parallelStream-----------------");
		list.parallelStream().forEach(System.out::println);
		System.out.println("------------------------");
		
		int num1 = list.stream().findAny().get(); 
		int num2 = list.stream().findFirst().get();
		System.out.println(num1+"----------"+num2);
		//int num3 = list.stream().fin.get();
		System.out.println();

		int num3 = list.stream().reduce(0,(a,b)->a+b);
		System.out.println("----------"+num3);
		int num4 = list.stream().filter(x->x%2!=0).reduce(1,(a,b)->a*b);
		System.out.println("----------"+num4);
		
		System.out.println();

		boolean num5 = list.stream().anyMatch(x->x==3);
		System.out.println("----------"+num5);
		boolean num6 = list.stream().filter(x->x%2!=0)
									.allMatch(x->x%3==0);
		System.out.println("----------"+num6);
		boolean num7 = list.stream().filter(x->x%2!=0)
				.noneMatch(x->x==6);
		System.out.println("----------"+num7);
		System.out.println("-----chars to stream-----");
		"rajeev kumar".chars().mapToObj(x->Character.toUpperCase((char)x))
		              .forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
	}
}
