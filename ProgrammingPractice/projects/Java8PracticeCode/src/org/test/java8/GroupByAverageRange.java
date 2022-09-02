package org.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByAverageRange {

	enum AgeGroup {
	    TWENTIES,
	    THIRTIES,
	    FORTIES,
	    FIFTIES;
	   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Function<Employee3, AgeGroup> employee2Group = e -> {
		    if(e.getAge() >= 20 && e.getAge() < 30)
		        return AgeGroup.TWENTIES;
		 
		    return null;
		};
		
		List<Employee3> employees = new ArrayList<Employee3>();

		Map<AgeGroup, Double> avgByAgeGroup = employees.stream()
		    .collect(Collectors.groupingBy(employee2Group, Collectors.averagingDouble(Employee3::getSalary)));

		System.out.println(avgByAgeGroup.get(AgeGroup.TWENTIES));;
		
		Map<Double,Double> ageGroup= employees.stream().collect(Collectors.groupingBy(e->Math.ceil(e.getAge()/10.0),Collectors.summingDouble(e->e.getSalary())));
	    System.out.println(ageGroup);
		
	}

}
