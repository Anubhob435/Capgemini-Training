package src.FileHandelling;

import java.io.*;

public class Create10k {
	public static void main(String[] args) throws IOException {
		String dirPath = "src/FileHandelling/Folder/";
		File dir = new File(dirPath);
//		if (!dir.exists()) {
//			dir.mkdirs();
//		}

		for (int i = 1; i <= 10000; i++) {
			String fileName = dirPath + "file" + i + ".txt";
			File file = new File(fileName);
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write("test file " + i);
			}
		}
		System.out.println("10,000 files created successfully!");
	}
}
