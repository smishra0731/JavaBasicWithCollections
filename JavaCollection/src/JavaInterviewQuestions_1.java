import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class JavaInterviewQuestions_1 {
	public static String[] ar1 = {"Java","Ruby","Python","C++","Java","C#","Python",".Net"};
	public static void main(String[] args) {
		
		//findDuplicateWords("Java is Java best language is Java");
		//printNumbers();
		//printHello();
		//printNumber(1);
		//printNumber(1,100);
		//findDuplicateEle(ar1);
		//System.out.println(factWithForLoop(5));
		//System.out.println(factRecursion(0));
		//convertMapToArrayList();
		//treeMap();
		//reverseLinkedList();
		hasHSetMethods();
	}
	// Program to find duplicate words in a given string
	public static void findDuplicateWords(String str) {
		String ele[] = str.split(" ");
		HashMap<String, Integer> wordCount = new HashMap<String,Integer>();
		for (String word : ele) {
			if(wordCount.containsKey(word)) {
				wordCount.put(word, wordCount.get(word)+1);
			}else
				wordCount.put(word, 1);
		}
		Set<String> wordsInString = wordCount.keySet();
		for (String word : wordsInString) {
			if(wordCount.get(word)>1)
				System.out.println(word+" : "+wordCount.get(word));
		}
	
	  }
	// Program to print 1 to 100 without using any number
			public static void printNumbers() {
				int one = 'A'/'A';
				String str = "..........";
				for(int i = one; i<=(str.length()*str.length());i++)
					System.out.println(i);
			}
			
	// Program to print Hello World without using ;
			public static void printHello() {
			if(System.out.printf("Hello World"+"\n")==null)	
			{
				
			}
			if(System.out.append("Hello World")==null)
			{
				
			}
			}
			
	// Program to print numbers from 1 to 100 without using any loop
			public static void printNumber(int num) {
				if(num<=100) {
					System.out.println(num);
					num = num+1;
					printNumber(num);
				}
			}
			
	// Program to print numbers between given range without using any loop
		public static void printNumber(int strNum, int endNum) {
			if (strNum <= endNum) {
				System.out.println(strNum);
				strNum++;
				printNumber(strNum, endNum);
			}
		}
			
	// Program to find duplicate elements in an array
		public static void findDuplicateEle(String[] ar) {
			for(int i = 0; i<ar.length; i++) {
				for(int j = i+1;j<ar.length;j++) {
					if(ar[i].equals(ar[j]))
						System.out.println("Duplicat element is : "+ar[i]);
				}				
			}
		}
		
		// Program to find factorial of a number using for Loop
		public static int factWithForLoop(int num){
			int fact = 1;
			if(num == 0 )
				return 1;
			for(int i = 1; i<=num; i++)
				fact = fact*i;
			return fact;
		}
		
		// Program to find factorial of a number using recursion
		public static int factRecursion(int num){
			if(num ==0)
				return 1;
			int fact = num*factRecursion(num-1);
			num = num - 1;
			return fact;
		}
		
		// Program to convert hashMap to ArayList
		public static void convertMapToArrayList() {
			HashMap<String, Integer> companies =  new HashMap<String, Integer>();
			companies.put("Apple", 10000);
			companies.put("Google", 8000);
			companies.put("Deliote", 12000);
			companies.put("IBM", 6000);
			companies.put("TCS", 15000);
			
			ArrayList<String> arrList = new ArrayList<String>(companies.keySet());// This will convert all keys of hashMap to ArrayList
			System.out.println(arrList);
			
			ArrayList<Integer> arrList1 = new ArrayList<Integer>(companies.values());// This will convert all values of hashMap to ArrayList
			System.out.println(arrList1);
			System.out.println("*** Printing all keys using lambda expression ***");
			companies.forEach((k,v)-> System.out.println(k));
			System.out.println("*** Printing all values using lambda expression ***");
			companies.forEach((k,v)-> System.out.println(v));
		}
		
	    // Program to use TreeMap
		public static void treeMap() {		
		TreeMap<String, Integer> students = new TreeMap<String,Integer>();
		students.put("Ravi", 100);
		students.put("Ajay", 110);
		students.put("Nilesh", 200);
		students.put("Tanya", 109);
		students.put("Bali", 130);
		students.put("Chetna", 180);
		students.put("Dhruv", 205);
		students.put("Ganesh", 210);
		System.out.println(students);
		SortedMap<String, Integer> lessThanKeys =  students.headMap("Chetna");
		lessThanKeys.forEach((k,v)->System.out.println(k+"  "+v));
		System.out.println("***********");
		SortedMap<String, Integer> greaterThanKeys = students.tailMap("Chetna");
		greaterThanKeys.forEach((k,v)-> System.out.println(k+"   "+v));		
		// Print map in reverse order
		TreeMap<String, Integer> students1 = new TreeMap<String,Integer>(Comparator.reverseOrder());
		students1.put("Ravi", 100);
		students1.put("Ajay", 110);
		students1.put("Nilesh", 200);
		students1.put("Tanya", 109);
		students1.put("Bali", 130);
		students1.put("Chetna", 180);
		students1.put("Dhruv", 205);
		students1.put("Ganesh", 210);
		System.out.println("*** Reverse map is ***");
		System.out.println(students1);
		}
		
		// LinkedList methods
		public static void linkedListMethods() {
			
			
		} 
		
		// reverse a linkedlist
		public static void reverseLinkedList() {
			LinkedList<String> names = new LinkedList<String>(Arrays.asList("Java","Python","Ruby","JS"));
			Iterator<String> itr = names.descendingIterator();
			System.out.println("*** Reverse using descendingIterator ***");
			while(itr.hasNext())
				System.out.println(itr.next());
			System.out.println("*** Reverse using for loop ***");
			for(int i = names.size()-1; i >=0; i--)
				System.out.println(names.get(i));
							
		}
		
		// HashSet methods 
		public static void hasHSetMethods() {
			Set<Integer> first = new HashSet<Integer>();
			first.addAll(Arrays.asList(new Integer [] {1,2,3,5,7,8,10}));
			
			Set<Integer> second = new HashSet<Integer>();
			second.addAll(Arrays.asList(new Integer[] {2,3,4,6,9,10}));
			// To get all the values 
//			first.addAll(second);
//			System.out.println(first);
			// To get common elements from two sets use retainAll()
//			first.retainAll(second);
//			System.out.println(first);
			// To get distinct elements from two sets use removeAll()
//			first.removeAll(second);// This will give elements present in set first but not in set second
//			System.out.println(first); 
			
			second.removeAll(first);// This will give elements present in set second but not in set first
			System.out.println(second); 
			
		}
}
