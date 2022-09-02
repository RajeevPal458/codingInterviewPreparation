package org.test.java8.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FinedDuplicateEmployees {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Rajeev", "Pal", "BV",10l));
		empList.add(new Employee(4, "Kamlesh", "yadav", "Pv",20l));
		empList.add(new Employee(2, "Nirmala", "pal", "DV",30l));
		empList.add(new Employee(5, "Nirmala", "singh", "nV",50l));
		empList.add(new Employee(3, "Kamlesh", "dube", "PS",30l));
		empList.add(new Employee(6, "Rajeev", "Pal", "BV",10l));
		
		
		Map<String, List<Employee>> empMap=  empList.stream()
				.collect(Collectors.groupingBy(Employee::uniqueAttributes));
		
		List<Employee> duplicatesempList1  =empMap.values().stream().filter(emplist -> emplist.size()>1)
				.flatMap(Collection::stream).collect(Collectors.toList());
		duplicatesempList1.forEach(e->System.out.println(e));
		
		System.out.println("distinct employees::");
		List<Employee> distinctmpList1  =empList.stream()
				.collect(Collectors.toCollection(()-> 
				new TreeSet<>(Comparator.comparing(Employee::getFirstName).
						thenComparing(Employee::getLastName)))).stream().collect(Collectors.toList());
		distinctmpList1.forEach(e->System.out.println(e));
		System.out.println();

		  List<String> liststr = new ArrayList<String>();
	        liststr.add("one");
	        liststr.add("one");
	        liststr.add("one");
	        liststr.add("two");
	        liststr.add("three");
	        liststr.add("four");
	        liststr.add("five");
	        liststr.add("five");
	        liststr.add("six");
	        Map<String, List<String>> mapstr= liststr.stream()
	        		.collect(Collectors.groupingBy(String::new,Collectors.toList()));
	        List<String> printduplicate =mapstr.values().stream()
	        		.filter(list->list.size()>1).flatMap(Collection::stream).collect(Collectors.toList());
	        printduplicate.forEach(e->System.out.print(e+" "));
	        System.out.println(":distinct ->:");
	        List<String> removeduplicate =liststr.stream().distinct().collect(Collectors.toList());
	        removeduplicate.forEach(e->System.out.print(e+" "));
	}
}
