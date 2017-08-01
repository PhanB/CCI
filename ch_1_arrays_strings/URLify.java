/* Author: Bailey Phan
 * Date: July 31, 2017
 * Purpose: Converts strings back and forth between URL format and non-URL format by switching spaces and '%20'.
 * Methods: Strings are iterated through and each time a space or '%20' is reached, the complement is appended to the StringBuilder.
 * 			The runtime is O(n) for both ways.
 * */
package ch_1_arrays_strings;

public class URLify {

	public static void main(String[] args) {
		if(args.length > 1){
			for(int i=0;i<args.length;i++)
				System.out.println("URL: " + new String(urlify(args[i].toCharArray())) + "\t " + "NonURL: " + new String(deurlify(urlify(args[i].toCharArray()))));
		}
		else{
			char test[] = new char[20];
			test = "Mr John Smith".toCharArray();
			System.out.println("URL: " + new String(urlify(test)) + "\tNonURL: " + new String(deurlify(urlify(test))));
		}

	}
	
	/* Inputs: URL to be stripped of '%20'
	 * Outputs: char array of URL with '%20' replaced with spaces 
	 * */
	public static char[] deurlify(char url[]){
		StringBuilder sb = new StringBuilder();
		
		//loop through, find any instances of '%20' and if found append a space to the StringBuilder in its place
		for(int i=0;i<url.length;i++){
			if(i < url.length - 2){
				if(url[i] == '%' && url[i+1] == '2' && url[i+2] == '0'){
					sb.append(' ');
					i+=2;//make sure to account for the i++ after each loop
					continue;
				}	
			}
			sb.append(url[i]);
		}
		
		//convert back to char array before returning
		char[] parsed = new char[url.length];
		sb.getChars(0, sb.length(), parsed, 0);
		return parsed;
		
	}
	
	/* Inputs: char array to be converted to URL (replace spaces with '%20')
	 * Outputs: char array with spaces replaced with '%20'
	 * */
	public static char[] urlify(char url[]){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<url.length;i++){
			if(url[i] == ' ')
				sb.append("%20");
			else
				sb.append(url[i]);
		}
		
		//handles sizing of char array
		return sb.toString().toCharArray();
	}

}
