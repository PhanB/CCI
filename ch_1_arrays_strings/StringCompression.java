/* Author: Bailey Phan
 * Date: August 2, 2017
 * Purpose: Performs basic string compression in which repeated characters are represented by a number.
 * 			The runtime complexity is O(n), where n is the length of the inputted string.
 * */
package ch_1_arrays_strings;

public class StringCompression {

	public static void main(String[] args) {
		if(args.length > 1)
			for(int i=0;i<args.length;i++)
				compressString(args[i]);
		else{//no arguments
			compressString("aabcccccaaa");
		}

	}
	/* Inputs: String to be compressed.
	 * Outputs: If the "compressed" string is longer than the original, the original is returned. Otherwise returned a compressed version of the string.
	 * Methods: Loops through string and counts adjacent, repeating characters.
	 * */
	public static String compressString(String orig){
		
		orig = orig.replaceAll("[^a-zA-Z]", "");
		
		StringBuilder compress = new StringBuilder();
		
		char curr = orig.charAt(0);
		int counter = 1;
		
		//loop through and count repeats
		for(int i=1;i<orig.length();i++){
			if(curr == orig.charAt(i))
				counter++;
			else{				
				compress.append(curr+counter);				
				counter = 1;
				curr = orig.charAt(i);
			}
			
		}
		//make sure to add in the last bit
		compress.append(curr);
		compress.append(counter);
		
		//check to see if "compressed" version is actually longer
		String compressed = compress.toString();
		if(compressed.length() < orig.length()){
			System.out.println("'" + orig + "' compressed is '" + compressed + "'");
			return compressed;
		}
		
		System.out.println("'" + orig + "' is already compressed.");
		return orig;
	}

}
