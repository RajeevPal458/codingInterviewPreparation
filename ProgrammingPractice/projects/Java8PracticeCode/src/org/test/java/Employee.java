package org.test.java;

import java.util.ArrayList;
import java.util.List;

final class Employee {
	 
    private final String name;
    private final List<Address> address;

    public Employee(String name, List<Address> address) {
        super();
        this.name = name;
        this.address = new ArrayList<Address>(address);
    }

    //provide getter method only

    public List<Address> getAddress() {
        List<Address> add = null;
        if(this.address != null) {
            add = new ArrayList<>(this.address);
        }
        return add;
    }
    
    
    
    
    @Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}

	public static void main(String[] args) {
		
    	Address add = new Address("rasulabad",32);
    	Address add1 = new Address("kanpur",31);
    	List<Address> list = new ArrayList<>();
    	
    	list.add(add);
    	list.add(add1);
    	
    	
    	Employee emp = new Employee("rajeev", list);
    	list.add(new Address("bat", 21));
    	
    	
    	System.out.println(emp);
	}
} 