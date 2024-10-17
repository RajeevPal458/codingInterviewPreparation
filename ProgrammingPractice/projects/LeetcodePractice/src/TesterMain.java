public class TesterMain {
	
	public static void main(String[] args) {
		
	}

}

class Employee{
	private int salary;
	public Employee(int salary) {
		int newSalary = salary*2;
		this(salary,newSalary);
		this.salary=newSalary;
	}
	
	public Employee(int salary,int newSalary) {
		int updatesalary = salary*2;
		this.salary=updatesalary;
	}
}
