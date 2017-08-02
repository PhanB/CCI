/* Author: Bailey Phan
 * Date: August 1, 2017
 * Purpose: Given two strings s1 and s2, determine if s2 is a rotation of s1 while only using one call to isSubString. Assume you have a function called isSubstring that determines if s2 is a substring of s1.
 * Methods: Append the rotated string to the end of itself (thus repeating the string), then use indexOf to see if the original exists in this new, and twice as large, string.
 * 			The runtime complexity of the program is equal to our function isSubstring and its time complexity. In this case we used indexOf which has a time complexity of O(m*n), where m and n are the lengths of the strings.
 * */
package ch_1_arrays_strings;

public class StringRotation {

	public static void main(String[] args) {
		if(args.length > 1){
			for(int i=0;i<args.length-1;i+=2)
				stringRotation(args[i],args[i+1]);
		}
		else{
			String original = "waterbottle";
			String rotation = "erbottlewat";
			stringRotation(original, rotation);
		}

	}
	
	/* Inputs: two strings, one unrotated string and one rotated string
	 * Outputs: boolean value of whether they are rotations of each other
	 * Methods: Append the rotated string to the end of itself (thus repeating the string), then use indexOf to see if the original exists in this new, and twice as large, string.
	 * */
	public static boolean stringRotation(String original, String rotation){
		
		String doublesub = rotation.toLowerCase();
		doublesub+= doublesub;
				
		if(doublesub.indexOf(original.toLowerCase()) != -1){
			System.out.println(rotation + " is a rotation of " + original);
			return true;
			
		}
		
		System.out.println(rotation + " is not a rotation of " + original);
		return false;
		
	}

}
