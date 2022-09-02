package org.test.java8;

public class Employee2 {

	private int id;
    private String name;
    private long salary;
    private GroupBy groupBy;
 
    public Employee2(int id, String name, long salary, GroupBy groupBy) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.groupBy = groupBy;
    }
 
    // setters and getters
 
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public GroupBy getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(GroupBy groupBy) {
		this.groupBy = groupBy;
	}

	@Override
    public String toString() {
        return "Employee2 [id=" + id + ", name=" + name + ", salary=" + salary + ", groupBy=" + groupBy + "]";
    }
}
