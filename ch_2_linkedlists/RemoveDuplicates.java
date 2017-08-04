/* Author: Bailey Phan
 * Date: August 3, 2017
 * Purpose: Removes duplicates in the linked list structure with runtime complexity of O(n).
 * Methods: A HashSet is used to track which node values have been previously found and removes nodes whose values are found in the HashSet.
 * */
package ch_2_linkedlists;

import java.util.HashSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		LinkedListNode head;
		if(args.length > 1){
			head = populateLinkedList(args);
		}
		else{
			String[] data = {"alpha", "beta", "gamma", "delta", "alpha", "gamma"};
			head = populateLinkedList(data);
		}
		
		System.out.print("List before dupliate removal: ");
		printLinkedList(head);
		
		removeDuplicates(head);
		System.out.print("List after duplicate removal: ");
		printLinkedList(head);

	}
	
	/* Inputs: head node of linked list
	 * Outcome: removes nodes with duplicate values
	 * Methods: a hashset is used to track which values have been previously seen
	 * */
	public static void removeDuplicates(LinkedListNode head){
		if(head == null)
			return;
		
		HashSet<String> set = new HashSet<String>();
		LinkedListNode prev = head;
		LinkedListNode curr = head;
		while(curr != null){
			
			if(set.contains(curr.data)){//if duplicate
				prev.next = curr.next;//set previous node's pointer to current's next
				curr = curr.next;
			}
			else{
				set.add(curr.data);
				prev = curr;
				curr = curr.next;
			}
			
		}		
	}
	
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
		System.out.println("");
	}

}
