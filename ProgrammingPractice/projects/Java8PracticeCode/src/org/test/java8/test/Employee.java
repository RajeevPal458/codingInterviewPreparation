package org.test.java8.test;

public class Employee implements Comparable<Employee>{

	private int id;
	private String firstName;
	private String lastName;
	private String companyName;
	private Long salary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String firstName, String lastName, String companyName, Long salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	public String uniqueAttributes() {
		  return firstName+lastName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", companyName="
				+ companyName + ", salary=" + salary + "]";
	}
	

	@Override
	public int compareTo(Employee arg0) {
		// TODO Auto-generated method stub
		return this.getFirstName().compareTo(arg0.getFirstName());
	}
	

}
