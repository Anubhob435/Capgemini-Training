package src.FileHandelling;

import java.io.*;

public class Code1 {
	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("OddEven.java");
		writer.write("//package src.FileHandelling; \n");
		writer.write("import java.util.Scanner; \n");
		writer.write("public class OddEven{  \n");
		writer.write("public static void main (String[] args){ \n");
		writer.write("Scanner sc = new Scanner(System.in); \n");
		writer.write("int n = sc.nextInt(); \n");
		
		for (int i=0; i<=10; i++) {
			if(i%2==0) {
			writer.write("if(n == " + i + ") \n");
			writer.write("System.out.println(\"Its a even number\"); \n");
			}
			else {
				writer.write("System.out.println(\"Its a odd number\"); \n");
			}
		}
		writer.write("} \n");
		writer.write("} \n");
		writer.close();
		System.out.println("code written");
		
		
	}

}
