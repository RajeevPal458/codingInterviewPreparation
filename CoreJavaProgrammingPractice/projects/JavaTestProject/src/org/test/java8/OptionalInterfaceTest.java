package org.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalInterfaceTest {

	public static void main(String[] args) {
		Employee employee1 =new Employee(5, "sarvesh", "Pal", "AirForce");
		Employee employee2=null;
	
		Optional<Employee> optional1 = Optional.ofNullable(employee2);
		Optional<Employee> optional2 = Optional.ofNullable(employee1);
		
		System.out.println("orElse with empty object "+optional1.orElse(new Employee(6, "pink", "color", "pinkolor")).getFirstName());
		System.out.println("orElse with non empty object "+optional2.orElse(new Employee(7, "dog", "animal", "dogAnimal")).getFirstName());
		
		System.out.println("orElseGet with empty object "+optional1.orElseGet(()->new Employee(6, "pink", "color", "pinkolor")).getFirstName());
		System.out.println("orElseGet with non empty object "+optional2.orElseGet(()->new Employee(7, "dog", "animal", "dogAnimal")).getFirstName());
		
	}
}
