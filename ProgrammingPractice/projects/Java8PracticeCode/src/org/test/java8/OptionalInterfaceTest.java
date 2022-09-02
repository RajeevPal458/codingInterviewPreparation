package org.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalInterfaceTest {

	public static void main(String[] args) {
		Employee employee2=null;
		Employee employee1 =new Employee(5, "sarvesh", "Pal", "AirForce",10);
	
		Optional<Employee> optional1 = Optional.ofNullable(employee2);
		Optional<Employee> optional2 = Optional.ofNullable(employee1);
		
		System.out.println("orElse with empty object "+optional1.orElse(new Employee(6, "pink", "color", "pinkolor",10)).getFirstName());
		System.out.println("orElse with non empty object "+optional2.orElse(new Employee(7, "dog", "animal", "dogAnimal",10)).getFirstName());
		
		System.out.println("orElseGet with empty object "+optional1.orElseGet(()->new Employee(6, "pink", "color", "pinkolor",10)).getFirstName());
		System.out.println("orElseGet with non empty object "+optional2.orElseGet(()->new Employee(7, "dog", "animal", "dogAnimal",10)).getFirstName());
		
		if(optional1.isPresent()) {
			System.out.println("optional1 is empty");
		}else {
			System.out.println("optional1 non empty");
		}
		if(optional2.isPresent()) {
			System.out.println("optional1 non empty");
		}else {
			System.out.println("optional1 is empty");
		}
	}
}
