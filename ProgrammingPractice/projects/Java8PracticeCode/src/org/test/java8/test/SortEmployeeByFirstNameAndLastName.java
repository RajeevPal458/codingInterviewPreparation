package org.test.java8.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//given list of employee so sort now based on firtname of employee if same so on lastname
public class SortEmployeeByFirstNameAndLastName {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Pal", "BV",10l));
		employees.add(new Employee(4, "Kamlesh", "yadav", "Pv",10l));
		employees.add(new Employee(2, "Nirmala", "pal", "DV",10l));
		employees.add(new Employee(3, "Kamal", "dube", "PS",10l));
		
		employees=employees.stream().sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName)).collect(Collectors.toList());
		employees.stream().forEach(System.out::println);     
		
	}
}
