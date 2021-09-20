package org.test.java8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaTester {

	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Pal", "BV",10l));
		employees.add(new Employee(4, "Kamlesh", "yadav", "Pv",10l));
		employees.add(new Employee(2, "Nirmala", "pal", "DV",10l));
		employees.add(new Employee(3, "Kamal", "dube", "PS",10l));
		
		
/*		 Map<Integer, Employee> map = employees
				    .stream()
				    .distinct()
				    .collect(
				      Collectors.toMap(Employee::getId, employee -> employee));
				  System.out.println(map + "\n");

				   Get id, firstName from all employees. 
				  Map<Integer, String> map1 = employees
				    .stream()
				    .distinct()
				    .collect(
				      Collectors.toMap(Employee::getId,
				        Employee::getFirstName));
				  System.out.println(map1 + "\n");*/
		
	Map<String, Employee> empMap=	employees.stream().sorted((e1,e2) -> e1.getFirstName().compareTo(e2.getFirstName())).sorted((e1,e2) -> e1.getLastName().compareTo(e2.getLastName())).collect(Collectors.toMap(Employee::getFirstName, employee->employee ,
            (oldValue, newValue) -> oldValue, LinkedHashMap::new ));
	empMap.entrySet().stream().forEach((entry)->{System.out.println("key:"+entry.getKey()+":Value:"+entry.getValue());});
	
	//List<Employee> empList=	employees.stream().sorted((e1,e2) -> e1.getCompanyName().compareTo(e2.getFirstName())).collect(Collectors.toList());
					
	//empList.forEach(System.out::println);
		
	

   /* List < Employee > employeesSortedList1 = employees.stream()
        .sorted((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName())).collect(Collectors.toList());
   
    employeesSortedList1.forEach(System.out::println);*/

    /*List < Employee > employeesSortedList2 = employees.stream()
        .sorted(Comparator.comparingLong(Employee::getSalary)).collect(Collectors.toList()); //ascending order
    System.out.println(employeesSortedList2);
		*/

		
		
		
		
		
		
	}
}
