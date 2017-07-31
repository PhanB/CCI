/* Author: Bailey Phan
 * Date: July 31, 2017
 * Purpose: Given 2 strings, determine if they are permutations of each other
 * Methods: The characters in each string and their amount of occurrences are counted/stored in a hashmap. 
 * 			If they are equal they are permutations of each other.
 * 			The runtime is O(a+b), where a and b are the lengths of the given strings.
 * */
package ch_1_arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

	public static void main(String[] args) {
		if(args.length < 1){
			checkPermutation("apple pie","ppaie ple");
			checkPermutation("dino","saur");
			checkPermutation("hello","elolh");
			checkPermutation("one two three","three two one");
		}
		else{
			for(int i=0;i<args.length-1;i+=2)
				checkPermutation(args[i],args[i+1]);
		}

	}
	
	public static boolean checkPermutation(String str1, String str2){
		
		//clean up strings
		String a = removeSpecChars(str1.toLowerCase());
		String b = removeSpecChars(str2.toLowerCase());
				
		//first check length of strings
		if(a.length() != b.length()){
			System.out.println("'" + str1 + "' is not a permutation of '" + str2 + "'");
			return false;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		//count occurrences of each character in first string
		for(int i=0;i<a.length();i++){
			char c = a.charAt(i);
			if(map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
			
		}
				
		//decrement occurrences counted from first string for each char in second string (remove key/char when value/count is 0)
		for(int i=0;i<b.length();i++){
			char c = b.charAt(i);
			if(map.containsKey(c))
				if(map.get(c) - 1 == 0)
					map.remove(c);
				else
					map.put(c, map.get(c)-1);
			else{//second string had more chars than first string
				System.out.println("'" + str1 + "' is not a permutation of '" + str2 + "'");
				return false;
			}
		}
		
		if(map.isEmpty()){//same amount of chars in each string
			System.out.println("'" + str1 + "' is a permutation of '" + str2 + "'");
			return true;
		}
		else{//first string had more chars than second string
			System.out.println("'" + str1 + "' is not a permutation of '" + str2 + "'");
			return false;
		}
	}
	
	public static String removeSpecChars(String s){
		return s.replaceAll("[^a-zA-Z0-9]", "");
	}

}
