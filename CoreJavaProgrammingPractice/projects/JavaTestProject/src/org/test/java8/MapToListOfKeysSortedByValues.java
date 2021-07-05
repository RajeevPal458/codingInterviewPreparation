package org.test.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToListOfKeysSortedByValues {
	
	public static void main(String[] args) {
		
		Map<String, String> countByType = new HashMap<>();
		
		countByType.put("Rajeev", "pal");
		countByType.put("kamlesh", "yadav");
		countByType.put("prakash", "singh");
		countByType.put("munnu", "lal");
		countByType.put("pram", "bal");
		
		
		
		
		List<String> mapkeys=countByType.entrySet()
        .stream()
        .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())) // custom Comparator
        .map(e -> e.getKey())
        .collect(Collectors.toList());
		
		System.out.println();
		
		List<String> mapkeys1=countByType.entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByValue()) // custom Comparator
		        .map(e -> e.getKey())
		        .collect(Collectors.toList());
		
		List<String> mapkeys3=countByType.entrySet()
		        .stream()
		        .sorted(Comparator.comparing(Map.Entry::getValue)) // custom Comparator
		        .map(e -> e.getKey())
		        .collect(Collectors.toList());
		
		
		System.out.println();
		mapkeys.forEach(System.out::println);
		
		System.out.println();
		mapkeys1.forEach(System.out::println);
		
		System.out.println();
		mapkeys3.forEach(System.out::println);
		
		
		
	}

}
