package com;

public class Main {
	public static void main(String[] args) {
//		Demo demo = ()->{
//			System.out.println("Method");
//		};
//		demo.sample();
//		Demo demo1 = ()->{
//			System.out.println("Method");
//		};
//		demo.sample();
		Demo demo = (num)->{
		System.out.println("Method " + num);
		};
		demo.sample(55);
	}
}
