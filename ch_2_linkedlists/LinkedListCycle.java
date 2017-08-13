/* Author: Bailey Phan
 * Date: August 13, 2017
 * Purpose: Simplistic cyclic detection of linked lists using the hare and tortoise algorithm. The runtime complexity is O(n).
 * Methods: Simple cycle detection using the hare and tortoise algorithm in which we have two pointers.
 * 			One is labeled the hare and one the tortoise because the hare pointer jumps twice per iteration
 * 			whilst the tortoise jumps once per iteration. If the two are ever equal a cycle is detected and if
 * 			the hare ever reaches the end of the linked list, a cycle does not exist.
 * */
package ch_2_linkedlists;

public class LinkedListCycle {

	public static void main(String[] args) {
		
		//create linked list with a cycle
		LinkedListNode curr = new LinkedListNode("2", null);
		LinkedListNode prev = new LinkedListNode("1", curr);
		
		LinkedListNode head = prev;
		for(int i=0;i<50;i++){
			prev = curr;
			curr = new LinkedListNode("" + i, null);
			prev.next = curr;
		}

		//create loop
		curr.next = head;
		
		if(detectCycle(head))
			System.out.println("Cycle detected.");
		else
			System.out.println("No cycle detected.");
	}
	
	/* Inputs: Head pointer to a singly linked list
	 * Outputs: Boolean value of whether the linked list contains a loop
	 * Methods: Simple cycle detection use the hare and tortoise algorithm.
	 * */
	public static boolean detectCycle(LinkedListNode head){
		LinkedListNode tortoise = head;
		LinkedListNode hare = head;
		
		while(hare != null){
			//hare takes 2 steps at a time, tortoise takes 1
			hare = hare.next;
			if(hare == null)
				return false;
			hare = hare.next;
			tortoise = tortoise.next;
			
			if(hare == tortoise)
				return true;
		}
		
		return false;
	}

}
