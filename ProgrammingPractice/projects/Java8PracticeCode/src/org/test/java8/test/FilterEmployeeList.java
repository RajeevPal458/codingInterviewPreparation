package org.test.java8.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterEmployeeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Rajeev", "Pal", "BV",10l));
		empList.add(new Employee(4, "Kamlesh", "yadav", "Pv",20l));
		empList.add(new Employee(2, "Nirmala", "pal", "DV",30l));
		empList.add(new Employee(5, "Nirmala", "singh", "nV",50l));
		empList.add(new Employee(3, "Kamlesh", "dube", "PS",30l));
		
		List<Employee> empListRes  =empList.stream().filter(emp->emp.getSalary() > 30).filter(emp -> emp.getFirstName().equals("Nirmala")).collect(Collectors.toList());
    
		//empListRes.forEach(emp-> System.out.println(emp));
	
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(5);
		numbers.add(4);
		numbers.add(1);
		numbers.add(6);
		numbers.add(7);
		List<Integer> squareList = numbers.stream().filter(a -> a % 2 == 0).map(n -> n * n).collect(Collectors.toList());
		squareList.forEach(a->System.out.println(a+" "));
		
		

	}

}