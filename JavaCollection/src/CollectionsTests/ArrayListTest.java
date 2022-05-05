package CollectionsTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArrayListTest {

	public static void main(String[] args) {
		//specificSizedArrayList();
		//genericArrayList();
		//iterateArrayList();
		//createArrayList();
		//addArrayListElements();
		//arrayListToArray();
		//synchronizedArrayList();
		//removeDuplicateElements(); 
		compareArrayList();
	}

	// Create an array list with specified size
	public static void specificSizedArrayList() {
		ArrayList<Object> ar = new ArrayList<Object>(15);// This will create an array with initial size 15.
		System.out.println(ar.size());
		ar.add(10);
		ar.add(20);
		System.out.println(ar.size());
	}
	
	// Create ArrayList with Generic data types
	public static void genericArrayList() {
		ArrayList<String> ar = new ArrayList<String>();// This will create an array list which takes only String values
		ar.add("Hello");
		ar.add("World!");
		//ar.add(10); // This will give error because ar is of type String while we are trying to add int data type
		System.out.println(ar.get(0)+" "+ar.get(1));
	}
	
	// Iterate ArrayList
	public static void iterateArrayList() {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("Java");
		ar.add("Ruby");
		ar.add("Python");
		ar.add("C#");
		System.out.println("*** Using for loop ***");
		// Iterate using for loop
		for(int i = 0; i < ar.size(); i++ )
			System.out.println(ar.get(i));
		System.out.println("*** Using for each ***");
		// Iterate using for-each loop
		for(String ele: ar)
			System.out.println(ele);
		System.out.println("*** Using lambda expression ***");
		// Iterate using lambda function
		ar.stream().forEach(ele->{System.out.println(ele);});
		System.out.println("*** Using Iterator ***");
		// Iterate using Iterator
		Iterator<String> itr = ar.iterator();
		while(itr.hasNext()) {
			String ele = itr.next();
			System.out.println(ele);
		} 
	}
	

	
	// copy elements of one ArrayList to other ArrayList
	public static void createArrayList() {
		ArrayList<String> ar = new ArrayList<>();
		ar.add("Java");
		ar.add("Ruby");
		ar.add("Python");
		ar.add("C#");
		
		ArrayList<String> ar1 = new ArrayList<String>(ar);// Here we are creating one new copy of ArrayList ar into ar1.
		Iterator<String> itr = ar1.iterator();
		while(itr.hasNext()) {
			String ele = itr.next();
			System.out.println(ele);
		}
	}
	
	// Add elements of one ArrayList to other ArrayList
	public static void addArrayListElements() {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("Java");
		ar.add("Ruby");
		ar.add("Python");
		
		ArrayList<String> ar1 = new ArrayList<String>();
		ar1.add("C#");
		ar1.add("JS");
		ar.addAll(ar1);// All elements of ar1 will be added to ar
		System.out.println(ar);	
		
//		ar1.clear();// This will clear all the elenments of ar1
//		System.out.println(ar1);	
		
		ArrayList<String> ar3 = new ArrayList<String>();
		ar3 = (ArrayList<String>)ar1.clone();// Type cast array list which needs to be cloned to ArrayList<>
		System.out.println(ar3);
		
		System.out.println(ar1.contains("Java"));// Contains() returns true if element is present in ArrayList else retuns false
		System.out.println(ar1.contains("JS"));
		
		System.out.println(ar.indexOf("Java"));//indexOf() gives index of any element in ArrayList
	    System.out.println();
	    
	    System.out.println(ar.lastIndexOf("Hello"));// lastIndexOf() returns -1 if element is not present in ArrayList
	    
	    System.out.println(ar.remove(2));// remove(int index) returns Object which has been removed e.g. Python
	    System.out.println(ar.remove("Java"));// remove(Object o) returns boolean i.e. true if element removed else false if not removed/not present
	    
	    ArrayList<Integer> arNumbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));// This is another way to create and initialize an ArrayList.
//	    arNumbers.removeIf(ele->(ele%2==0));// removeIf() takes some condition as parameter and updates ArrayList as par the condition. Here we are printing odd numbers between 1 to 10.
//	    System.out.println(arNumbers);
//	    arNumbers.removeIf(ele->(ele%2!=0));// Here we are printing even numbers between 1 to 10 using removeIf()
//	    System.out.println(arNumbers);
	    
   }
	// Program to convert an ArrayList to an Array
    public static void arrayListToArray() {
    	ArrayList<String> ar = new ArrayList<String>(Arrays.asList("Delhi","Mumbai","Pune","Bhopal","Indore","Chaennai"));
    	Object[] strArr = ar.toArray();//toArray() returns one Object[]
    	for(Object ele: strArr)
    		System.out.println(ele.toString());// This will convert each Object type element to String
    }
    
    // Create synchronized ArrayList by using CopyOnWriteArrayList class
    public static void synchronizedArrayList() {
    	CopyOnWriteArrayList<String> ar = new CopyOnWriteArrayList<String>();
    	ar.add("Hello");
    	ar.add("java");
    	ar.add("world!");
    	Iterator<String> itr = ar.iterator();
    	for(String ele: ar)
    		System.out.println(ele);
    }
    
    // Program to remove duplicate elements from a array list
    public static void removeDuplicateElements() {
    	// 1. By using LinkedHashSet 
    	ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList(1,2,2,3,4,4,5,7,7,7,8,9));
    	// Create object of LinkedHashSet
    	LinkedHashSet<Integer> linkedHS = new LinkedHashSet<Integer>(ar);
    	// Create one more Arraylist and pass this LinkedHashSet object
    	ArrayList<Integer> ar1 = new ArrayList<Integer>(linkedHS);
    	System.out.println(ar1);// This will print arrayList without duplicate values.
    	
    	// 1. By using stream
    	ArrayList<Integer> marks = new ArrayList<Integer>(Arrays.asList(10,12,11,13,12,11,10,14,17,14));
        List<Integer> uniqueMarks = marks.stream().distinct().collect(Collectors.toList());// this collect() returns List
        System.out.println(uniqueMarks);
    }
    
    // Program to compare two ArrayList
    public static void compareArrayList() {
    //1. By using sorting
    ArrayList<String> ar = new ArrayList<String>(Arrays.asList("Java","Python","Ruby","JS","C"));
    ArrayList<String> ar1 = new ArrayList<String>(Arrays.asList("Java","Python","Ruby","JS","C#"));
    // First we will sort the arrays by using Collections class if don't sort then comparison can't be done because comparison is done on index basis
    Collections.sort(ar);
    Collections.sort(ar1);
    System.out.println(ar.equals(ar1));// equals() returns true if both ArrayLists are  equal else returns false
    
    // Compare two lists and find the additional element
    ArrayList<String> ar2 = new ArrayList<String>(Arrays.asList("Java","Python","Ruby","JS","C"));
    ArrayList<String> ar3 = new ArrayList<String>(Arrays.asList("Java","Python","Ruby","JS","C#"));
//    ar2.removeAll(ar3);// This will give the additional element present in ar2 but not in ar3 i.e. C
//    System.out.println(ar2);
    
//    ar3.removeAll(ar2);
//    System.out.println(ar3);// This will give missing element which is not in ar2 i.e. C#
    
    // Fine the common elements
    ar2.retainAll(ar3);
    System.out.println(ar2);// This will return common elements i.e. "Java","Python","Ruby","JS"	
    
    }
}
