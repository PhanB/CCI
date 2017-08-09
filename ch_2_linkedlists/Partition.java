/* Author: Bailey Phan
 * Date: August 8, 2017
 * Purpose: Partitions a linked list around a value x. One list has all the values less than x and the other list has all values greater than or equal to x.
 * Method(s): Iterates through linked list and adds node to either the left/right partition based on the node's value vs the midpoint. The runtime complexity is O(n), where n is the size of the linked list.
 * */
package ch_2_linkedlists;

import java.util.ArrayList;
import java.util.Arrays;

public class Partition {

	public static void main(String[] args) {
		ArrayList<LinkedListNode> leftPartition = new ArrayList<LinkedListNode>();
		ArrayList<LinkedListNode> rightPartition = new ArrayList<LinkedListNode>();
		LinkedListNode head;
		
		int midPoint;
		
		if(args.length < 1){
			//if no arguments, create linked list with 10 random integers (1-100) and pick a random list item as midpoint
			int SIZE = 10;
			String[] values = new String[SIZE];
			
			for(int i=0;i<SIZE;i++)
				values[i] = Integer.toString((int)(Math.random() * 100) + 1);
				
			head = populateLinkedList(values);
			midPoint = Integer.parseInt(values[(int)(Math.random() * SIZE)]);
			
			
		}
		else{
			
			//take input and turn into a linked list -- last argument is the index of midpoint
			String[] values = new String[args.length - 1];
			values = Arrays.copyOfRange(args, 0, args.length - 1);
			int midIndex;
			
			//convert string values to integers
			try{
				midIndex = Integer.parseInt(args[args.length-1]);
			}
			catch(NumberFormatException e){
				System.out.println("Unable to convert last input ('" + args[args.length-1] + "') to integer.");
				return;
			}
			
			if(midIndex >= args.length){
				System.out.println("Error: Index of midpoint too large.");
				System.out.println("Usage: Values for linked list followed by the index of the desired midpoint");
				return;
			}
			
			try{
				midPoint = Integer.parseInt(args[midIndex]);
			}
			catch(NumberFormatException e){
				System.out.println("Error in converting midpoint '" + args[midIndex] + "' to integer: ");
				return;
			}
			
			head = populateLinkedList(values);
		}

		
		partition(head, midPoint, leftPartition, rightPartition); 

	}

	/* Inputs: Head of linked list, midpoint (integer), ArrayLists of LinkedListNode's to hold left/right partition
	 * Outputs: None, but prints left and right partition and populates left/right arraylists with values less than/greater than midpoint
	 * */
	public static void partition(LinkedListNode head, int mid, ArrayList<LinkedListNode> left, ArrayList<LinkedListNode> right){
		left.clear();
		right.clear();
		LinkedListNode runner = head;//current node
		int nodeValue;//current node's value (converted from string to int)
		
		//print out list to be partitioned
		System.out.print("Partitioning list: [");
		printLinkedList(head);
		System.out.println("] with midpoint " + mid);

		//partition the linked list
		while(runner != null){
			//convert node values to ints
			try{
				nodeValue = Integer.parseInt(runner.data);
		    }catch(NumberFormatException e){
		        System.out.println("Error in converting '" + runner.data + "' to integer: " + e.getMessage() + ".");
		        continue;
		    }
			
			//sort into lists (less than goes to left, greater than or equal to goes to right)
			if(nodeValue < mid){
				left.add(runner);
			}
			else{
				if(nodeValue == mid)
					right.add(0,runner);
				else
					right.add(runner);
			}
			runner = runner.next;
		}
		
		/*System.out.print("Left: ");
		for(int i=0;i<left.size();i++){
			System.out.print(left.get(i).data);
			if(i < left.size() - 1)
				System.out.print(" -> ");
		}
		System.out.print("\n");
		
		System.out.print("Right: ");
		for(int i=0;i<right.size();i++){
			System.out.print(right.get(i).data);
			if(i < right.size() - 1)
				System.out.print(" -> ");
		}
		System.out.print("\n");*/
		
		for(int i=0;i<left.size();i++)
			System.out.print(left.get(i).data + " -> ");
		for(int i=0;i<right.size()-1;i++)
			System.out.print(right.get(i).data + " -> ");
		System.out.println(right.get(right.size()-1).data);

	}
	
	//utility functions
	
	/* Inputs: array of strings
	 * Outputs: returns head of newly created linked list
	 * */
	public static LinkedListNode populateLinkedList(String[] myData){
		if(myData.length == 0)
			return null;
		LinkedListNode head = new LinkedListNode(myData[0],null);
		LinkedListNode prev = head;
		LinkedListNode curr = head;
		
		//iterate through array and create LinkedListNodes for each element
		for(int i=1;i<myData.length;i++){
			curr = new LinkedListNode(myData[i],null);
			prev.next = curr;
			prev = curr;
		}
		
		return head;
	}
	
	/* Inputs: head node of a linked list
	 * Outcome: prints out comma separated list of node values
	 * */
	public static void printLinkedList(LinkedListNode head){
		LinkedListNode runner = head;
		while(runner != null){
			if(runner != head)
				System.out.print(", ");
			System.out.print(runner.data);
			runner = runner.next;
			
		}
	}

}
