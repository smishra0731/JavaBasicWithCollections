import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaInterviewQuestions {

	public static void main(String[] args) {
		// Find missing number in an array
		int ar[] = {3,4,5,6,8,9,10};
		int firstEle = ar[0];
		int lastEle = ar[ar.length-1];
		int sum =0;
		int sum1 = 0;
		
		for(int i=0;i<ar.length;i++)
		{
			sum = sum + ar[i];
		}
		System.out.println(sum);
		
		for(int j=firstEle;j<=lastEle;j++)
		{
			sum1 = sum1 + j;
		}
		System.out.println(sum1);
		
		System.out.println("Missing number is ::"+(sum1-sum));
	    System.out.println("************");
		// Find duplicate values in array using for loop
		String ar1[] = {"Test1","Test2","Test3","Test1","Test4","Test2"};
		for(int i=0;i<ar1.length;i++)
		{
			for(int j=i+1;j<ar1.length;j++)
			{
				if(ar1[i].equals(ar1[j]))
				{
					System.out.println("Duplicate ele is :: "+ar1[i]);
				}
			}
		}
		System.out.println("************");
		// Find duplicate values in array using HashSet
		Set<String> hs = new HashSet<String>();
		for(String ele: ar1) {
			if(hs.add(ele) == false)
				System.out.println("Duplicate ele is :: "+ele);
		}
		System.out.println("************");
		// Find duplicate values in array using HashMap
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for (String ele : ar1) {
			Integer count = hm.get(ele);
			if(count == null)
				hm.put(ele, 1);
			else
				hm.put(ele, ++count);
		}
		
		Set<Entry<String, Integer>> entrySet =  hm.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if(entry.getValue()>1)
				System.out.println("Duplicate element is :: "+entry.getKey());
			
		}
		
		// Find largest and smallest integer number in an array
		int num[] = {-12,3,5,7,15,-9,-4,19,20,30,17};
		int largestNum = num[0];
		int smallestNum = num[0];
		
		for(int i=0;i<num.length;i++)
		{
			if(num[i]>largestNum)
				largestNum=num[i];
			else if(num[i]<smallestNum)
				smallestNum=num[i];			
		}
		System.out.println("The array is : "+Arrays.toString(num));
		
		System.out.println("Largest number is :"+largestNum);
		System.out.println("Smallest number is :"+smallestNum);
		
		// Swap two integers without using third variable and using + operator
		int n1 = 5;
		int n2 = 10;
		
		n1 = n1+n2;//n1 = 15
		n2 = n1 - n2;// n2 = 15 - 10 = 5
		n1 = n1 - n2;// n1 = 15 - 5 = 10
		
		System.out.println("Swapped numbers are : "+n1+" and "+n2 );
		
		// Swap two integers without using third variable and using * operator
		int n3 = 12;
		int n4 = 20;
	
		n3 = n3*n4;//n3 = 240
		n4 = n3 / n4;// n3 = 240 / 20 = 12
		n3 = n3 / n4;// n4 = 240 - 12 = 20
				
		System.out.println("Swapped numbers are : "+n3+" and "+n4 );

		// Swap two integers without using third variable and using ^ operator
		int n5 = 15;
		int n6 = 25;
		
		n5 = n5^n6;
		n6=n5^n6;
		n5=n5^n6;
		System.out.println("Swapped numbers are : "+n5+" and "+n6 );
		
		// Swap two Strings without using third variable
		String s1 = "Hello";
		String s2 = "World";
		System.out.println("Before swapping values are : "+s1+ " and "+s2 );
		
		s1 = s1+ s2;
		s2 = s1.substring(0, s1.length()-s2.length());
		s1 = s1.substring(s2.length());
		
		System.out.println("After swapping values are : "+s1+ " and "+s2 );
	
		// Find the given number is prime or not
		int num1 = 13;
		boolean flag = true;
		for(int i = 2;i < num1/2;i++)
		{
			if(num1%i == 0)
			{
			   flag = false;
			}
		}
		if(flag == true && num1>=2)
			System.out.println("The number is prime");
		else
			System.out.println("The number is not prime");
		
		// Find given number is palindrom or not
		int origNum = 1001;
		int revNum = 0;
		int temp = origNum;
		int sum2 = 0;
		
		while(origNum>0) {
			revNum = origNum%10;
			sum2 = (sum2*10) + revNum;
			origNum = origNum/10;			
		}

		if(temp==sum2)
			System.out.println("The number "+temp+" is palindrom.");
		else
			System.out.println("The number "+temp+" is not palindrom.");
	
	    // Find the give number is a Armstrong number 
		int origNum1 = 153;
		int temp1 = origNum1;
		int revNum1;
	    int sum3 = 0;
	    while(origNum1>0) {
	    	revNum1 = origNum1%10;
	    	origNum1 = origNum1/10;
	    	sum3 = sum3+(revNum1*revNum1*revNum1);	    	
	    }
	    if(sum3==temp1)
	    	System.out.println("The number "+temp1+" is Armstrong number.");
	    else
	    	System.out.println("The number "+temp1+" is not an Armstrong number.");	
	
	    // Iterate an ArrayList
	    System.out.println("Iterate arrayList using lambda java 8");
	    ArrayList<String> arList = new ArrayList<String>();
	    arList.add("Element_1");
	    arList.add("Element_2");
	    arList.add("Element_3");
	    arList.add("Element_4");
	    arList.add("Element_5");
	    arList.add("Element_6");
	    // Using java 8
	    arList.forEach(ele ->{
	    	System.out.println(ele);
	    });
	    // Using iterator
	    System.out.println("Iterate arrayList using Iterator");
	    Iterator<String> itrString = arList.iterator();
	    while(itrString.hasNext()) {
	    	String ele = itrString.next();
	    	System.out.println(ele);
	    }
	    // Using for-each loop
	    System.out.println("Iterate using for each loop");
	    for (String ele : arList) {
			System.out.println(ele);
		}
	 // Using for-each loop
	    System.out.println("Iterate using for loop");
	    for(int i = 0;i<arList.size(); i++)
	    	System.out.println(arList.get(i));
	 // Using for-each loop
	    System.out.println("Iterate using List iterator");
	    ListIterator<String> lstItr = arList.listIterator(arList.size());
	    while(lstItr.hasPrevious()) {
	    	String ele = lstItr.previous();
	    	System.out.println(ele);
	    }
	
	}
}
