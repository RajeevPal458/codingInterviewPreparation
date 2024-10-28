public class TesterMain {
	
	public static void main(String[] args) {
		
	}

}

class Person{
	private int salary;
	public Person(int salary) {
		this.salary=salary;
	}
}

class Employee extends Person{
	private int salary;
	public Employee(int salary) {
		super(salary);
		int newSalary = salary*2;
		this.salary=newSalary;
	}
	
	
}
