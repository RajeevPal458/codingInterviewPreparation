package org.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ListToMap {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Pal", "BV"));
		employees.add(new Employee(4, "Kamlesh", "yadav", "Pv"));
		employees.add(new Employee(2, "Nirmala", "pal", "DV"));
		employees.add(new Employee(3, "Kamal", "dube", "PS"));
		
		List<String> employees1 = new ArrayList<>();
		employees1.add("A");
		employees1.add("BA");
		employees1.add("BADC");
		employees1.add("CAD");
		
		Map<String, Employee> employeeMap=employees.stream().collect(Collectors.toMap(Employee::getCompanyName, employee->employee));
		
		employeeMap.forEach((e1,e2) -> System.out.println(":key:"+e1+":value:"+e2.getLastName()));
		
		///
		System.out.println();
		System.out.println();
		Map<Integer, List<String>> employeeMap1=employees1.stream().collect(Collectors.groupingBy(String::length, TreeMap::new , Collectors.toList()));
		
		employeeMap1.forEach((e1,e2) -> System.out.println(":key:"+e1+":value:"+e2));
		
		
		/*Map<Integer, List<String>> result = list.stream()
			    .collect(Collectors.groupingBy(
			        String::length,        // use length of string as key
			        TreeMap::new,          // create a TreeMap
			        Collectors.toList())); // the values is a list of strings
			This collects the stream by means of the overload of Collectors.groupingBy that accepts 3 arguments: the key mapper function, the supplier of the map and the downstream collector.
	
	*/
	}
}

