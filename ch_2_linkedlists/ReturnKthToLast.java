/* Author: Bailey Phan
 * Date: August 3, 2017
 * Purpose: Returns the kth to last element in the linked list structure with a runtime complexity of O(n), n being the size of the linked list.
 * */
package ch_2_linkedlists;

public class ReturnKthToLast {

	public static void main(String[] args) {
		
		//populate linked list
		LinkedListNode head;
		
		if(args.length == 0){
			String data[] = {"one", "two", "three", "four", "five", "six", "seven"};
			head = populateLinkedList(data);
		}
		else{//arguments inputted
			head = populateLinkedList(args);
		}
		
		//print out list and retrieve the kth to last
		System.out.print("Retrieving 3rd to last of list: ");
		printLinkedList(head);
		System.out.println(returnKthToLast(head,3).data);
		
	}
	/* Inputs: head node and an index of which node to returned (starts from end and moves backwards)
	 * Outputs: returns the kth to last node in the linked list
	 * Methods: Two runners are set n-1 nodes apart until the front runner reaches the end. The back runner is returned.
	 * */
	public static LinkedListNode returnKthToLast(LinkedListNode head, int k){
		
		LinkedListNode runnerFront = head;//will b k nodes ahead of runnerBack
		LinkedListNode runnerBack = head;//will end as the kth to last element
		
		//move front runner to kth element
		for(int i=1;i<k;i++){
			if(runnerFront.next == null){
				System.out.println("There are not " + k + " elements in the LinkedList.");
				return null;
			}
			runnerFront = runnerFront.next;
		}
		
		//move both runners forward 1 node until the front runner hits the end
		while(runnerFront.next != null){
			runnerFront = runnerFront.next;
			runnerBack = runnerBack.next;
		}
		
		return runnerBack;
		
		
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
	 * Outputs: prints out comma separated list of node values
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
