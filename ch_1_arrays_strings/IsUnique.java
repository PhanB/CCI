/* Author: Bailey Phan
 * Date: July 30, 2017
 * Purpose: Determines if string(s) has/have all unique characters with/without using data structures.
 * Methods: For the function that utilizes data structures, a hashmap is used to track all previously encountered characters, resulting in a runtime of O(n). 
 * 			For the function without data structures, the string is sorted and neighboring characters are compared, resulting in a runtime of O(nlogn + n).
 * */
package ch_1_arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class IsUnique {

	public static void main(String[] args) {
		
		//determine which function to use (one uses data structures, other doesn't)
		Scanner sc = new Scanner(System.in);
		System.out.println("Use data structures? (yes/no)");
		String useDataStruct = sc.next();
		useDataStruct = useDataStruct.toLowerCase();
		
		Consumer<String> unique;//pointer to which function to use
		
		if(useDataStruct.equals("yes") || useDataStruct.equals("y") || useDataStruct.equals("true")){
			unique = (y) -> isUnique(y);
		}
		else{
			unique = (y) -> isUniqueNoDataStructures(y);
		}
		
		
		if(args.length == 0){//no arguments inputted
			unique.accept("metalworkings");
			unique.accept("troublemakings");
			unique.accept("handcraftsmanship");
			unique.accept("uncopyrightable");
			unique.accept("uncopyrightable");
		}
		else{//arguments inputted
			for(int i=0;i<args.length;i++)
				unique.accept(args[i]);
		}

	}
	
	/* Inputs: string to be checked if it contains all unique characters
	 * Outputs: returns if string contains all unique characters
	 * Methods: Uses a hashmap to track which characters appear in the string. Runtime of O(n).
	 * */
	public static boolean isUnique(String input){
		
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		String cleaned = removeSpecialChars(input);
		
		//check if character has appeared in string previously (previously encountered characters are stored in a hashmap)
		for(int i=0;i<cleaned.length();i++){
			if(map.containsKey(cleaned.charAt(i))){
				System.out.println("'" + input + "' does not consist of unique characters.");
				return false;
			}
			else
				map.put(cleaned.charAt(i), true);
		}
		
		System.out.println("'" + input + "' consists of unique characters.");
		return true;
		
	}
	
	/* Inputs: string to be checked if it contains all unique characters
	 * Outputs: returns if string contains all unique characters
	 * Methods: Sorts the string and checks if adjacent characters are the same. Runtime of O(nlogn + n).
	 * */
	public static boolean isUniqueNoDataStructures(String input){
		
		//remove special chars
		String cleaned = removeSpecialChars(input);
		//sort array
		cleaned = quickSort(cleaned);
		
		//check if neighboring characters are equal
		for(int i=0;i<cleaned.length()-1;i++){
			if(cleaned.charAt(i) == cleaned.charAt(i+1)){
				System.out.println("'" + input + "' does not consist of unique characters.");
				return false;
			}
		}
		
		System.out.println("'" + input + "' consists of unique characters.");
		return true;
		
	}
	
	/* Inputs: string to be cleaned up (remove special characters)
	 * Outputs: string without special characters
	 * */
	public static String removeSpecialChars(String cleanMe){
		//remove cases
		cleanMe = cleanMe.toLowerCase();
		//remove special characters
		cleanMe = cleanMe.replaceAll("[^a-zA-Z0-9]", "");
		
		return cleanMe;
	}
	
	/* Inputs: string to be cleaned up (remove special characters)
	 * Outputs: string without special characters
	 * Methods: Uses Arrays' sort function (quicksort).
	 * */
	public static String quickSort(String sortMe){
		//Arrays' sort algorithm uses quicksort
		char[] tmpSort = sortMe.toCharArray();
		Arrays.sort(tmpSort);
		
		return String.valueOf(tmpSort);
	}

}
