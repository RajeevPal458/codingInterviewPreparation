package org.test.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByNameTest {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Pal", "BV"));
		employees.add(new Employee(4, "Kamlesh", "yadav", "Pv"));
		employees.add(new Employee(2, "Nirmala", "pal", "DV"));
		employees.add(new Employee(5, "Nirmala", "singh", "nV"));
		employees.add(new Employee(3, "Kamlesh", "dube", "PS"));
		
		Map<String, Long> employeeFirstNameCount=employees.stream().
				sorted(Comparator.comparing(Employee::getFirstName)).
				collect(Collectors.groupingBy(p -> p.getFirstName(), Collectors.counting()));
		employeeFirstNameCount.forEach((k,v) -> System.out.println(":k:"+k+":v:"+v));
		
	}
}
