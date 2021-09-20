package org.test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateEmpolyee {

	public static void main(String[] args) {
		List<Employee> listEmp = getEmployeeList();
		 Map<String , Long> map =listEmp.stream().sorted(Comparator.comparing(Employee::getFirstName))
				 .collect(Collectors.groupingBy(p -> p.getFirstName(),Collectors.counting()));
		 
		 map.forEach((e1,e2)->System.out.println(e1+"::"+e2));

		 
		 // lets ----
		 java.util.List<String> list = Arrays.asList("A", "B", "B", "C", "D", "D", "Z", "E", "E");
	     Map<String,Long>  map1=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	     map1.entrySet().forEach(e->System.out.print(""+e.getKey()+"::"+e.getValue()+" , "));
	
	     Map<String , Employee>  map2 =listEmp.stream().collect(Collectors.toMap(Employee::getFirstName , emp->emp));
	
	}
	
	
	public static List<Employee> getEmployeeList(){
		List<Employee> listEmp = new ArrayList<Employee>();
		Employee  emp1 = new Employee();
		emp1.setId(1);
		emp1.setFirstName("Rajeev");
		emp1.setLastName("Pal");
		emp1.setCompanyName("chetu");
		listEmp.add(emp1);
		
		Employee  emp2 = new Employee();
		emp2.setId(2);
		emp2.setFirstName("Nirmala");
		emp2.setLastName("pal");
		emp2.setCompanyName("teacher");
		listEmp.add(emp2);
		
		Employee  emp3 = new Employee();
		emp3.setId(3);
		emp3.setFirstName("Raj");
		emp3.setLastName("yadav");
		emp3.setCompanyName("chemisty");
		listEmp.add(emp3);
		
		Employee  emp4 = new Employee();
		emp4.setId(4);
		emp4.setFirstName("Ramesh");
		emp4.setLastName("Pal");
		emp4.setCompanyName("info");
		listEmp.add(emp4);
		
		Employee  emp5 = new Employee();
		emp5.setId(5);
		emp5.setFirstName("Rajeev");
		emp5.setLastName("Pal");
		emp5.setCompanyName("chetu");
		listEmp.add(emp5);
		
		Employee  emp6 = new Employee();
		emp6.setId(6);
		emp6.setFirstName("Ramesh");
		emp6.setLastName("Pal");
		emp6.setCompanyName("tech");
		listEmp.add(emp6);
		
		Employee  emp7 = new Employee();
		emp7.setId(7);
		emp7.setFirstName("Nirmala");
		emp7.setLastName("Pal");
		emp7.setCompanyName("chetu");
		listEmp.add(emp7);
		
		return listEmp;
	}
 
}




