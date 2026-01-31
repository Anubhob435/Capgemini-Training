package dsa.basics;


import java.util.*;

public class StackEg {
	public static void main(String[] args) {
		Stack <Integer> stack = new Stack();
		System.out.println(stack.push(10));
		System.out.println(stack.push(10));
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.isEmpty());
		try {
			System.out.println(stack.pop());
		}catch(EmptyStackException e){
			System.out.println("Stack is empty");
		}
		
		
	}
}
