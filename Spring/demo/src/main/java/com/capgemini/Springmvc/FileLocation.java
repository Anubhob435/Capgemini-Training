package com.capgemini.Springmvc;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLocation {
    public static void main(String[] args) {

        Path path = Paths.get("example.txt");

        System.out.println("File path: " + path);
        System.out.println("Absolute path: " + path.toAbsolutePath());
    }
}