/* Author: Bailey Phan
 * Date: August 15, 2017
 * Purpose: Given a stack of integers, sorts the stack with the smallest value being at the top of the stack.
 * 			The runtime complexity is O(n^2) and the additional space used is O(n), n being the size of the inputted stack.
 * */
package ch_3_stacks_queues;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {

		Stack<Integer> stacky = new Stack<Integer>();
		
		if(args.length < 1){
			//if no arguments, push 10 random integers to the stack
			for(int i=0;i<10;i++)
				stacky.push((int)(Math.random()*100));
		}
		else{
			//if arguments inputted, convert to integers and push to stack
			for(int i=0;i<args.length;i++){
				try{
					int num = Integer.parseInt(args[i]);
					stacky.push(num);
				}
				catch(NumberFormatException e){
				      System.out.println("Unable to convert '" + args[i] + "' to integer: " + e.getMessage());
				      
				}
			}
				
		}

		System.out.println("Pre  Sort: " + stacky.toString());
		sortStack(stacky);
		System.out.println("Post Sort: " + stacky.toString());
	}

	/* Inputs: Stack of integers to be sorted
	 * Outputs: Sorts the inputted stack in ascending order
	 * Methods: Uses 1 additional stack as a temporary storage
	 * */
	public static void sortStack(Stack<Integer> myStack){
		Stack<Integer> tmpStack = new Stack<Integer>();
		while(!myStack.isEmpty()){
			int curr = myStack.pop();//item we are sorting
			int popCount = 0;

			//System.out.println(tmpStack.toString());
			//move smaller items back to stack 1
			while(!tmpStack.isEmpty() && curr < tmpStack.peek()){
				myStack.push(tmpStack.pop());
				popCount++;
			}

			//found where curr belongs in stack 2
			tmpStack.push(curr);

			//move items from stack 1 back to stack 2
			for(int i=0;i<popCount;i++)
				tmpStack.push(myStack.pop());

		}

		//push sorted (reversed) tmpStack to original stack
		while(!tmpStack.isEmpty())
			myStack.push(tmpStack.pop());
	}

}
