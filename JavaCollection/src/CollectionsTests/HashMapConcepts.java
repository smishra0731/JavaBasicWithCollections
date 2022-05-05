/* HashMap does not maintain insertion order and doesn't contain duplicate keys
   Stores values in the form of key-value pair
   HashMap extends AbstractMap<K,V> which implements Cloneable and Serializable interfaces
   HashMap allows only one null key but multiple null values
   HashMap is not thread safe i.e. it is not synchronized
*/
package CollectionsTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapConcepts {

	public static void main(String[] args) {
		 
		//mapBasicEntries();
		compareMaps();
	}
	
	public static void mapBasicEntries() {
		HashMap<String, String> capitalMap = new HashMap<String,String>();
		// Add the values to map by using put()
		capitalMap.put("India", "Delhi");
		capitalMap.put("Shri Lanka", "Colombo");
		capitalMap.put("Pakistan", "Lahore");
		capitalMap.put("UK", "London");
		capitalMap.put(null, "NullValue");
		// To get the value use get() and paas the key as argument
		System.out.println(capitalMap.get("India"));
		System.out.println(capitalMap.get(null));
		// By using Iterator we can traverse, we can apply iterator on key or on value
		Iterator<String> itrKeys = capitalMap.keySet().iterator();
		Iterator<String> itrValues = capitalMap.values().iterator();
        System.out.println("*** Traversing based on key ****");
		while(itrKeys.hasNext()) {
        	String key = itrKeys.next();
        	String value = capitalMap.get(key);
        		 System.out.println("Capital of: "+key+" is: "+value);      		
        }
        
        // We can also iterate on the basis of key-value pair by using entrySet() which returns Iterator<Entry<K,V>>
		System.out.println("*** Traversing based on key-value pair ****");
		Iterator<Entry<String, String>> itr1 =  capitalMap.entrySet().iterator();
	    while(itr1.hasNext()) {
	    	Entry<String,String> entry = itr1.next();
	    	System.out.println("Capital of :"+entry.getKey()+" is: "+entry.getValue());
	    }
	    
	    // We can also iterate by using for each and lambda expression
	    System.out.println("*** Traversing by using for each loop ****");
	    capitalMap.forEach((k,v)->System.out.println("Capital of : "+k+" is: "+v));
	}
	
	// Program to compare two hashMaps
	public static void compareMaps() {
		HashMap<Integer, String> map1 = new HashMap<Integer,String>();
		HashMap<Integer, String> map2 = new HashMap<Integer,String>();
		HashMap<Integer, String> map3 = new HashMap<Integer,String>();
		HashMap<Integer, String> map4 = new HashMap<Integer,String>();
		HashMap<Integer, String> map5 = new HashMap<Integer,String>();
		HashMap<Integer, String> map6 = new HashMap<Integer,String>();
		
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");
		
		map2.put(2, "B");
		map2.put(1, "A");
		map2.put(3, "C");
		
		map3.put(1, "A");
		map3.put(2, "B");
		map3.put(3, "C");
		map3.put(3, "D");
				
		// 1. Compare on the basis of key-value pair i.e. by using equals()
		System.out.println(map1.equals(map2));// This will give true
		System.out.println(map1.equals(map3));// This will give false
		
		// 2. Compare for same keys i.e. keySet()
		System.out.println(map1.keySet().equals(map2.keySet()));// This will give true
		System.out.println(map1.keySet().equals(map3.keySet()));// This will give true, because keySet() returns set of keys with unique values
		
		// 3. Find the extra keys
		map4.put(1, "A");
		map4.put(2, "B");
		map4.put(3, "C");
		map4.put(4, "D");
		// First get all the keys from map1 and store it  in one HashSet
		HashSet<Integer> combineKeys = new HashSet<Integer>(map1.keySet());
		// Now add all keys from map4 to combineKeys object
		combineKeys.addAll(map4.keySet());
		// Now remove all keys of map1 from combineKeys object, then only extra keys ill be left in combineakeys 
		combineKeys.removeAll(map1.keySet());
		System.out.println(combineKeys);
		
		// 4. Compare hash maps on the basis of values, there are two ways to compare hashMaps on value basis
		// (a) If duplicate values are allowed
		map5.put(1, "A");
		map5.put(2, "B");
		map5.put(3, "C");
				
		map6.put(1, "A");
		map6.put(2, "B");
		map6.put(3, "C");
		map6.put(4, "C");
		// Here first we will create new Arraylist object and paas the values of maps as parameter
		boolean compareResult = (new ArrayList<String>(map5.values())).equals(new ArrayList<String>(map6.values()));// This will return false
		System.out.println(compareResult);
		
		// (b) If duplicate values are not allowed
		// Here first we will create new HashSet object and paas the values of maps as parameter
		boolean compareResult_1 = (new HashSet<String>(map5.values())).equals(new HashSet<String>(map6.values()));// This will return true
		System.out.println(compareResult_1);
	}

}
