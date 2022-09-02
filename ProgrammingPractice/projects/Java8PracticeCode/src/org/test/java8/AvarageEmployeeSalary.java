package org.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//find the average price of the Item (name, price, quantity) list. 
public class AvarageEmployeeSalary {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Pal", "BV",19000));
		employees.add(new Employee(4, "Kamal", "yadav", "BV",20));
		employees.add(new Employee(2, "Nirmala", "pal", "DV",25));
		employees.add(new Employee(3, "Kamal", "dube", "DV",25000));
		employees.add(new Employee(3, "Rajeev", "dube", "DV",35000));
		employees.add(new Employee(3, "Rajeev", "dube", "DV",20500));
		employees.add(new Employee(3, "Kamal", "dube", "DV",10000));
		
		
		Map<String, Double>  map =employees.stream().collect(Collectors.groupingBy(Employee::getFirstName,Collectors.averagingDouble(Employee::getSalary)));
		
		map.forEach((k,v) -> System.out.println(":key:"+k+":value:"+v));
		
	}

}
