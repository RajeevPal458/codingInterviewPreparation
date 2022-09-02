package org.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByMultipleFieldsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating List and adding Employees values.
        List<Employee1> employeesList = new ArrayList<>();
 
        employeesList.add(new Employee1(101, "Glady", "Manager", "Male", 25_00_000));
        employeesList.add(new Employee1(102, "Vlad", "Software Engineer", "Female", 15_00_000));
        employeesList.add(new Employee1(103, "Shine", "Lead Engineer", "Female", 20_00_000));
        employeesList.add(new Employee1(104, "Nike", "Manager", "Female", 25_00_000));
        employeesList.add(new Employee1(105, "Slagan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee1(106, "Murekan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee1(107, "Gagy", "Software Engineer", "Male", 15_00_000));
 
        // group by - multiple fields
        // Grouping by designation and Gender two properties and need to get the count.
 
        Map<String, Map<String, Long>> multipleFieldsMap = employeesList.stream()
                .collect(
                        Collectors.groupingBy(Employee1::getDesignation, 
                                Collectors.groupingBy(Employee1::getGender, 
                                        Collectors.counting())));
 
        // printing the count based on the designation and gender.
        System.out.println("Group by on multiple properties" + multipleFieldsMap);
        
     // Example 2
     // group by - multiple fields
     // Grouping by designation and Gender two properties and need to get the count.
      
     Map<String, Map<String, List<Employee1>>> multipleFieldsMapList = employeesList.stream()
             .collect(
                     Collectors.groupingBy(Employee1::getDesignation, 
                             Collectors.groupingBy(Employee1::getGender)));
      
     // printing the count based on the designation and gender.
     System.out.println("Group by on multiple properties and Map key as List" + multipleFieldsMapList);
     
     // Creating List and adding Employees values.
     List<Employee2> employeesList2 = new ArrayList<>();

     employeesList2.add(new Employee2(101, "Glady", 25_00_000, new GroupBy("Manager", "Male")));
      
     employeesList2.add(new Employee2(102, "Vlad", 15_00_000, new GroupBy("Software Engineer", "Female")));
     employeesList2.add(new Employee2(103, "Shine", 20_00_000, new GroupBy("Lead Engineer", "Female")));
     employeesList2.add(new Employee2(104, "Nike", 25_00_000, new GroupBy("Manager", "Female")));
     employeesList2.add(new Employee2(105, "Slagan", 15_00_000, new GroupBy("Software Engineer", "Male")));
     employeesList2.add(new Employee2(106, "Murekan", 15_00_000, new GroupBy("Software Engineer", "Male")));
     employeesList2.add(new Employee2(107, "Gagy", 15_00_000, new GroupBy("Software Engineer", "Male")));

     // Example 1
     // group by - multiple fields
     // Grouping by designation and Gender two properties and need to get the count.

     Map<GroupBy, Long> multipleFieldsMap1 = employeesList2.stream()
             .collect(Collectors.groupingBy(Employee2::getGroupBy, Collectors.counting()));

     // printing the count based on the designation and gender.
     System.out.println("Group by on multiple properties" + multipleFieldsMap1);

    
     //5. Grouping By Using Apache Commons Pair.of()
     //If you have only two fields and do not wish to use the Record or Another class with the Group by properties then we can use the Pair.of() from apache commons library.
     
  // Example 3
  // group by - multiple fields
  // Grouping by designation and Gender two properties with Pair.of()
   
 // Map<Pair<String, String>, Long> multipleFieldsMapPair = employeesList.stream()
         // .collect(Collectors.groupingBy(e -> Pair.of(e.getDesignation(), e.getGender()), Collectors.counting()));
   
  // printing the count based on the designation and gender.
  //System.out.println("Group by on multiple fields with Pair - " + multipleFieldsMapPair);
	}

}
