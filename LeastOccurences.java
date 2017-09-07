/* Author: Bailey Phan
 * Date: September 7, 2017
 * Purpose: Find element(s) in an arraylist which appear the least amount.
 * Runtime complexity is O(m + n), where m is the amount of elements in the list and n is the amount of unique elements in the list. */
Class LeastOccurences{
	public static void main(String[] args){

		//iterate through list and count the ocurrences of each element
		HashMap<String,Integer> map = new HashMap<String, Integer>();

		for(int i=0;i<args.length;i++){
			if(map.contains(args[i])
				map.put(args[i],map.get(arg[i]) + 1);
			else
				map.put(args[i], 1);
		}

		//iterate through occurence map and find the minimum appearing elements
		int min = 99999;
		ArrayList<String> list = new ArrayList<String>();

		for(String element: map.keySet()){
			int occurences = map.get(element);
			if(occurences < min){
				min = occurences;
				set.clear();
				set.add(element);
			}

			else if(occurences == min)
				set.add(element);
		}

		System.out.print("Element(s) that appear the least ( " + min + " occurences): " + String.join(",", list));
	}
}
