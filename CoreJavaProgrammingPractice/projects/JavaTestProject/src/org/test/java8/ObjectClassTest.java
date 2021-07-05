package org.test.java8;

public class ObjectClassTest {

	public static void main(String[] args) {
		Object obj1 =new Object();
		
		Object obj2 =new Object();
		
		if(obj1 == obj2){
			System.out.println("obj1 == obj2");
		}
		
		if(obj1.equals(obj2)){
			System.out.println("obj1.equals(obj2)");
		}
	}
}
