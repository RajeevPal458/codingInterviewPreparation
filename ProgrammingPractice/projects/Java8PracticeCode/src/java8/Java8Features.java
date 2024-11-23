package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java8.model.Employee;

/**
 * average salary between age group like 20-30
 * sum of salary of same Age
 * find count of number of employees of same name and sort by name 
 * given List of names find count of each same names.
 * 
 * group by - multiple fields
   Grouping by designation and Gender two properties and need to get the count.
 
 * Count of employee having same gender and designation.group by gender and designation
 *  // Grouping by designation and Gender two properties with Pair.of()
 *  
 * Get id, firstName from all employees.
 * Id,Employee
 * Map<String, Employee> empMap sort by fname and lname in same order
 * sort employees by name
 * sort by salary - comparing
 * 
 *  Map to List of keys sorted by values
 * 
 * @author rajee
 *
 */
public class Java8Features {
	
	public static void main(String[] args) {
		
		
		List<Employee> empList = getEmployeeList();
		
		Function<Employee, AgeGroup> finFunction = new Function<Employee, AgeGroup>() {

			@Override
			public AgeGroup apply(Employee t) {
				// TODO Auto-generated method stub
				if(t.getAge()>=20&&t.getAge()<24)
					return AgeGroup.TWENTIES;
				else if(t.getAge()>=24&&t.getAge()<30)
					return AgeGroup.FOURTIES;
				else 
					return AgeGroup.SIXTIES;
			}
		
		};
		
		Map<AgeGroup,Long> map =empList.stream()
				.collect( Collectors.groupingBy(finFunction,
						Collectors.counting()));
		
		map.forEach((key,value)->System.out.println(key+"  , "+value));
		
		Map<Integer, Double> map2 = empList.stream().
				collect(Collectors.groupingBy(Employee::getAge,
						Collectors.summingDouble(Employee::getSalary)));
		map2.forEach((key,value)->System.out.println(key+"  , "+value));
		
		Map<String, Long> map3 = empList.stream().
				collect(Collectors.groupingBy(Employee::getName,
						 TreeMap::new
						,Collectors.counting()));
//				.entrySet().stream().sorted(Map.Entry.comparingByKey())
//				.collect(Collectors.toMap(Map.Entry::getKey, 
//						Map.Entry::getValue,(oldval,newval)->
//				newval,LinkedHashMap::new));
		
		map3.forEach((key,value)->System.out.println(key+"  , "+value));
		
		System.out.println("---------------------------");
		List<String> names = getListString();
		Map<String, Long> map4 = names.stream().
				collect(Collectors.groupingBy(String::new,
						Collectors.counting()));
		
		map4.forEach((key,value)->System.out.println(key+"  , "+value));
		
		System.out.println("frequency of each char in string --------");
		
		String str = "codecuriousbyrajeevkumarpal";
		Map<Character, Long> map0 =str.chars().mapToObj(i->(char)i)
				//.map(c->Character.valueOf(c))
				.collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()));
		
		map0.forEach((key,value)->System.out.println(key+"  , "+value));

		Map<Character, Long> map1 =IntStream.range(0, str.length()).mapToObj(i->str.charAt(i))
					//.map(m->Character.valueOf(m))
					.collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()));
		System.out.println("other way--");		
		map0.forEach((key,value)->System.out.println(key+"  , "+value));

		System.out.println("----------------------");
		Map<String,Map<String,Long>> map5 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDesignation,
						Collectors.groupingBy(Employee::getGender,
								Collectors.counting())));
		
		System.out.println(map5);
		
		System.out.println("----------------------");
		Map<String, List<Employee>> map6 = empList.stream().
				collect(Collectors.groupingBy(Employee::getGroup));
		System.out.println("designation gender -"+map6);
		
//		System.out.println("----------------------");
//		Map<String, List<Employee>> map7 = empList.stream().
//				collect(Collectors.groupingBy(Pair.of(Employee::getDesignation,Employee::getGender)));
//		System.out.println(map7);
		
		Map<Integer,String> map8 = empList.stream().
				collect(Collectors.toMap(Employee::getId, Employee::getName));
	
		System.out.println(map8);
		
		Map<Integer,Employee> map9 = empList.stream().
				collect(Collectors.toMap(Employee::getId, Function.identity(),(old,nv)->old,LinkedHashMap::new));
	
		System.out.println(map9);
		
		List<Employee> emplist = empList.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
		System.out.println("sorted by salary emplist:-"+emplist);
		
		
		
		Map<Integer,Employee> mapToSort = empList.stream().
				collect(Collectors.toMap(Employee::getId, Function.identity()));
	    System.out.println("--------------------001");
		
		Map<String, String> mappair = getmapkeys();
		
		mappair.entrySet().stream()
		.sorted(Comparator.comparing(Map.Entry::getValue,
				Comparator.reverseOrder()))
		.forEachOrdered(e->System.out.println(e.getKey()+" , "+e.getValue()));
		
		Comparator<Employee> compareByName = Comparator
                .comparing(Employee::getName,Comparator.reverseOrder()
                		)
                .thenComparing(Employee::getAge);
	// employees.sort(Comparator.comparing(Employee::getName)
    //    .thenComparing(Comparator.comparing(Employee::getSalary).reversed()));
	
//	SELECT *
//		FROM Employee
//		ORDER BY name ASC, salary DESC;
		testMain2();
	}
	
	public static List<String> getListString(){
		List<String> names = new ArrayList<String>();
		names.add("rajeev");
		names.add("kamlesh");
		names.add("rajeev");
		names.add("Rinku");
		names.add("pradeep");
		names.add("rajeev");
		names.add("kamlesh");
		names.add("pradeep");
		names.add("rajeev");
		return names;
	}
	
	public static List<Employee> getEmployeeList(){
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Rajeev", "Manager","mal" ,300000,32));
		employees.add(new Employee(4, "Kamlesh", "Manager", "mal",200000,28));
		employees.add(new Employee(2, "Kamlesh", "AssocDev", "mal",50000,22));
		employees.add(new Employee(3, "Rajeev", "AssocDev", "mal",60000,24));
		employees.add(new Employee(5, "Seeta", "Hr", "femal",40000,20));
		employees.add(new Employee(6, "Seeta", "AssocHr", "femal",20000,20));
		employees.add(new Employee(7, "Geeta", "Hr", "femal",15000,24));
		employees.add(new Employee(8, "Geeta", "AssocHr", "femal",120000,22));
		
		
//		List<Employee1> employeesList = new ArrayList<>();
//		 
//        employeesList.add(new Employee1(101, "Glady", "Manager", "Male", 25_00_000));
//        employeesList.add(new Employee1(102, "Vlad", "Software Engineer", "Female", 15_00_000));
//        employeesList.add(new Employee1(103, "Shine", "Lead Engineer", "Female", 20_00_000));
//        employeesList.add(new Employee1(104, "Nike", "Manager", "Female", 25_00_000));
//        employeesList.add(new Employee1(105, "Slagan", "Software Engineer", "Male", 15_00_000));
//        employeesList.add(new Employee1(106, "Murekan", "Software Engineer", "Male", 15_00_000));
//        employeesList.add(new Employee1(107, "Gagy", "Software Engineer", "Male", 15_00_000));
// 
        
		
		return employees;
	}
	
	public static Map<String, String> getmapkeys(){
		Map<String, String> countByType = new HashMap<>();
		
		countByType.put("Rajeev", "pal");
		countByType.put("Kamlesh", "yadav");
		countByType.put("Prakash", "singh");
		countByType.put("Curious", "lal");
		countByType.put("Prakash", "bal");
		countByType.put("Curious", "pal");
		countByType.put("Kisan", "yadav");
		countByType.put("Mission", "lal");
		countByType.put("Taj", "bal");
		return countByType;
	}

	
	
	public static void testMain2(){
	   System.out.println();
	   System.out.println();
	   System.out.println("--------------testMain2 Start------------------");
	   Integer arr[] = {10,20, 5, 25,30,30};  
	   List<Integer> numbers = new ArrayList<>(Arrays.asList(arr)); 
	   Optional<Integer> num = numbers.stream().findAny();
	   Optional<Integer> num1= numbers.stream().findFirst();
	   System.out.println(":any num:"+num.get()+" , first :num1:"+num1.get());
	   sumOfEvenNumbers(numbers);
	}
	// get the sum of even numbers
	private static void sumOfEvenNumbers(List<Integer> numbers){
		int evenSum = 0;
		System.out.println("sumOfEvenNumbers -start - "+numbers);
		evenSum =numbers.stream().filter(num->num%2==0).collect(Collectors.summingInt(Integer::valueOf));
		
		System.out.println("Sum of even numbers = " + evenSum);
		System.out.println("-----------------------------------------------------------------------1");
		int sum =numbers.stream().reduce(0,(a, b) -> a + b);
		System.out.println("sum : "+sum);
		BinaryOperator<Integer> num;
		System.out.println("-----------------------------------------------------------------------1");
		sum =numbers.stream().reduce(0,Integer::sum);
		System.out.println("Sum1 : "+sum);
		
		System.out.println("-----------------------------------------------------------------------1");
		int min =numbers.stream().reduce(0,Integer::min);
		System.out.println("min : "+min);
		
		System.out.println("-----------------------------------------------------------------------1");
		min =numbers.stream().reduce(Integer::min).get();
		System.out.println("min 1 : "+min);
		
		System.out.println("-----------------------------------------------------------------------1");
		int max =numbers.stream().reduce(0,Integer::max);
		System.out.println("max : "+max);
		
		System.out.println("-----------------------------------------------------------------------1");
		max =numbers.stream().reduce(Integer::max).get();
		System.out.println("max 1 : "+max);
		
		System.out.println("-----------------------------------------------------------------------1");
		int mult =numbers.stream().reduce((a,b)->a*b).get();
		System.out.println("mult : " + mult);
		
		System.out.println("-----------------------------------------------------------------------2");
		
		evenSum =numbers.stream().mapToInt(i->i).sum();
		
		System.out.println("Sum of even numbers = " + evenSum);
		System.out.println("-----------------------------------------------------------------------3");
		int min3 =numbers.stream().mapToInt(Integer::valueOf).min().getAsInt();
		
		int max3 =numbers.stream().mapToInt(Integer::valueOf).max().getAsInt();
		
		double avg3 =numbers.stream().mapToInt(Integer::valueOf).average().getAsDouble();
		
		System.out.println("Min : "+min3+"  max : "+max3+" avg3 : "+avg3);
		
		
		
	}

}
class MyComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


enum AgeGroup {
    TWENTIES,
    FOURTIES,
    SIXTIES,
   
}