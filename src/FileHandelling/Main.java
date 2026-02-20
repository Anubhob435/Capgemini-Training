package src.FileHandelling;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		File file = new File("src/FileHandelling/Test.txt");
		System.out.println("File Created here");
		
		if(file.createNewFile()){
			System.out.println("File Created");
		}
		else {
			System.out.println("File already exists");
		}
		
		FileWriter writer = new FileWriter("src/FileHandelling/Test.txt");
		writer.write("Hello from Eclipse");
		writer.close();
		
		System.out.println("File written successfully");
	}

}
