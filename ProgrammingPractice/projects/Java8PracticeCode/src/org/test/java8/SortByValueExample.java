package org.test.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortByValueExample {

	public static void main(String[] argv) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("b", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("c", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("e", 2);
        unsortMap.put("e", 9);

        //System.out.println("Original...");
        //System.out.println(unsortMap);

        //sort by values, and reserve it, 10,9,8,7,6...
        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                        
        //Alternative way
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result);
        System.out.println(result2);
        
        Map<String,Integer> lhm= unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey((x,y)->x.compareTo(y))).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(old,newv)->old ,LinkedHashMap::new));
        
        System.out.println("sorted map-------------------------------------");
        lhm.forEach((key,value)->System.out.println("key:"+key+",value:"+value));
        

    }
}