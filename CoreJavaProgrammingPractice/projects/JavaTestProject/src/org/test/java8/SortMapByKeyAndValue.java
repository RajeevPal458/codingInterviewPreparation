package org.test.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortMapByKeyAndValue {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Pal", "BV",10));
		employees.add(new Employee(4, "Kamlesh", "yadav", "Pv",10));
		employees.add(new Employee(2, "Nirmala", "pal", "DV",10));
		employees.add(new Employee(3, "Kamal", "dube", "PS",10));
		
		//Map<String, String> employeeMap=employees.stream().collect(Collectors.toMap(Employee::getCompanyName, Employee::getLastName));
		//  now sorting the map by key
		
		//employeeMap=employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(oldVal ,newVal) -> oldVal ,LinkedHashMap::new));
		
		//employeeMap.forEach((e1,e2) -> System.out.println(":key:"+e1+":value:"+e2));
		System.out.println();
		
		
		
		//Now Sorting the  map by value 
		//employeeMap=employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(oldVal ,newVal) -> oldVal ,LinkedHashMap::new));
		//employeeMap.forEach((e1,e2) -> System.out.println(":key:"+e1+":value:"+e2));
		
		
		// ---------------------------
		
		Map<String, Employee> employeeMap2=employees.stream().collect(Collectors.toMap(Employee::getCompanyName, employee -> employee));
		employeeMap2.forEach((e1,e2) -> System.out.println(":key:"+e1+":value:"+e2));
		System.out.println();
		// to work this need to be Employee class comparable
		employeeMap2=employeeMap2.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(oldVal ,newVal) -> oldVal ,LinkedHashMap::new));
		employeeMap2.forEach((e1,e2) -> System.out.println(":key:"+e1+":value:"+e2));
		
		
	}
}
