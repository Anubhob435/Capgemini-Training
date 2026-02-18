package com;

public class Main {
	public static void main(String[] args) {
		Demo demo = ()->{
			System.out.println("Method");
		};
		demo.sample();
		Demo demo1 = ()->{
			System.out.println("Method from second func ");
		};
		demo1.sample();
	}
}
