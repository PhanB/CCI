/* Author: Bailey Phan
 * Date: July 29, 2017
 * Purpose: This program will test if the inputted string(s) are a permutation of a palindrome with a time complexity of O(n).
 * Methods: A HashMap is used to count how many times each character appears and if 2+ characters don't have an even number of appearances in the string, we know the string is not a permutation of a palindrome.
 * */

package ch_1_arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class PalindronePermutation {

	public static void main(String[] args) {
		if(args.length == 0)//no arguments inputted
			isPalindromePermutation("Tact Coa");
		else{//arguments inputted
			for(int i=0;i<args.length;i++)
				isPalindromePermutation(args[i]);
		}

	}
	
	
	/*
	 * Inputs: 1 string to be verified if it is a permutation of a palindrome or not
	 * Outputs: true if the input is a permutation of a palindrome, false otherwise
	 * */
	public static boolean isPalindromePermutation(String input){
		
		//handle upper/lower case
		String a = input.toLowerCase();
		//remove special characters
		a = a.replaceAll("[^a-zA-Z0-9]", "");
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();//holds how many times each char appears in the string
		
		//count characters in string and number of chars with odd duplicates
		int numOdds = 0;
		for(int i=0;i<a.length();i++){
			char c = a.charAt(i);

			//if char exists in hashmap, increment its count
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
				
				//keep track of the number of chars without a matching duplicate
				if(map.get(c) % 2 == 1)
					numOdds++;
				else
					numOdds--;
			}
			
			//if char doesnt exist in hashmap, add it in
			else{
				map.put(c, 1);
				numOdds++;
			}
		}
		
		if(numOdds > 1){
			System.out.println("'" + input + "' is not a palindrome permutation.");
			return false;
		}
		else{
			System.out.println("'" + input + "' is a palindrome permutation.");
			return true;
		}
	}

}
