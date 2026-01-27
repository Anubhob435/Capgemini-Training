package src.WeeklyTests;

import java.util.HashSet;

public class ArrayListDemo {
    
    int[] array = {10, 20, 30, 10, 20, 40, 50};
    
    public void printDuplicates() {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        
        for (int num : array) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }
        
        for (int num : duplicates) {
            System.out.println(num);
        }
    }
    
    public static void main(String[] args) {
        ArrayListDemo demo = new ArrayListDemo();
        demo.printDuplicates();
    }
}
