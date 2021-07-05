package org.test.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//given list of employee so sort now based on firtname of employee if same so on lastname
public class SortEmployeeByFirstNameAndLastName {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Pal", "BV"));
		employees.add(new Employee(4, "Kamlesh", "yadav", "Pv"));
		employees.add(new Employee(2, "Nirmala", "pal", "DV"));
		employees.add(new Employee(5, "Nirmala", "singh", "nV"));
		employees.add(new Employee(3, "Kamlesh", "dube", "PS"));
		employees=employees.stream().sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName)).collect(Collectors.toList());
		employees.stream().forEach(System.out::println);     
		
	}
}
