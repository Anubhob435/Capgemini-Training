package dsa.basics;

import java.util.*;

public class StackAllMethods {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack);
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		System.out.println("after push(): " + stack);

		stack.pop();
		System.out.println("after pop(): " + stack);

		System.out.println("peek() : " + stack.peek());
		System.out.println("After peek() : " + stack);

		System.out.println("empty() :" + stack.empty());

		System.out.println("search() : " + stack.search(300));
//
//		System.out.println(stack[0]);
	}



}