package com.bt.arrTree.mix;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	int id;
	String name;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Employee o) {
		return this.id-o.getId();
	}
	 public static class NameComparator implements Comparator<Employee>{
	        @Override
	        public int compare(Employee c1, Employee c2) {
	            return c1.name.compareTo(c2.name);
	        }
	 }
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
