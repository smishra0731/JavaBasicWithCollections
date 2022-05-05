
public class StringManipulation {

	public static void main(String[] args) {
		
		String str = "The automation is good";
		String str1 = "THE automation is good";
		
		// Check chatacter at position
		System.out.println(str.charAt(5));
		
		// Check index of any character
		System.out.println(str.indexOf('a'));
		
		// Check the index of second occurance of a
		System.out.println(str.indexOf('a', 5));
		// We can write the above line as below
		System.out.println(str.indexOf('a', str.indexOf('a')+1));
		
		// Check the index of an sub string in a string
		System.out.println(str.indexOf("is"));
	
		// If any substring is not available in string then it will return -1
		System.out.println(str.indexOf("Hello"));	 
	
		// String comparison by using equals()
		System.out.println(str.equals(str1));// This will return false because it is case sensitive
		
		System.out.println(str.equalsIgnoreCase(str1));// This will return true because it is not case sensitive 
		
		// Get substring from a string
		System.out.println(str.substring(0, 14));// This will return subtring starting from index 0 to index 13
		
		// How to trim spaces in a string
		String str2 = "   Hello world   ";
		//System.out.println(str2.trim());// This will remove the leading and trailing spaces
		
		System.out.println(str2.replace(" ", ""));// This will remove all spaces whether leading, trailing or in between
		
		// split()
		String str3 = "Hello_world_test_selenium";
		String splitStr[] = str3.split("_");
		for(int i=0;i<splitStr.length;i++)
			System.out.println(splitStr[i]);// This will split the string by _ and print all the substrings
		
		// Reverse a string without using any function
		String str4 = "Automation";
		String revStr = "";
		for(int i=str4.length()-1;i>=0;i--)
		{
			revStr = revStr + str4.charAt(i);
		}
		System.out.println(revStr);
		
		// Reverse of string can be done by using String buffer class also
		StringBuffer sf = new StringBuffer(str4);
		System.out.println("Reverse of string using String buffer "+sf.reverse());
		
		// print * pattern
		String starStr = "";
		for(int i =0;i<5;i++)
		{
			starStr = starStr + "*";
			System.out.println(starStr);
		}
		
		// Remove special characters from a string using regular expression
		String str5 = "%&*#^# Hello world";
		String newStr = str5.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(newStr);
		
		// Reverse a number
		int origNum = 123456;
		int revNum = 0 ;
		System.out.println("Original number is "+origNum);
		while(origNum!=0) {
			revNum = revNum*10 + origNum%10;
			origNum = origNum/10;
		}
		System.out.println("Reverse number is  "+revNum);	
		
		// Reverse a nember using StringBuffer()
		int origNum1 = 123456;
		StringBuffer sf1 = new StringBuffer(String.valueOf(origNum1));
		System.out.println("Reversed number using string buffer is "+sf1.reverse());	
	
	}
}
