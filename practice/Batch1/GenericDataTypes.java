package practice.Batch1;

import java.util.Scanner;

// DataType Interface
interface DataType<T> {
    void addition(T a, T b);
    void subtraction(T a, T b);
    void multiplication(T a, T b);
    void division(T a, T b);
    void performAll(T a, T b);
}

// StringDataType Class
class StringDataType<T> implements DataType<T> {
    
    @Override
    public void addition(T a, T b) {
        if (a instanceof String && b instanceof String) {
            String str1 = (String) a;
            String str2 = (String) b;
            
            // Validate constraints
            if (str1.length() > 100 || str2.length() > 100) {
                System.out.println("Error: String length must not exceed 100 characters");
                return;
            }
            
            System.out.println("Adding two strings");
            String result = str1 + str2;
            System.out.println("Result: " + result);
        } else {
            System.out.println("Error: Both parameters must be strings");
        }
    }
    
    @Override
    public void subtraction(T a, T b) {
        System.out.println("Cannot perform this operation on strings");
    }
    
    @Override
    public void multiplication(T a, T b) {
        System.out.println("Cannot perform this operation on strings");
    }
    
    @Override
    public void division(T a, T b) {
        System.out.println("Cannot perform this operation on strings");
    }
    
    @Override
    public void performAll(T a, T b) {
        System.out.println("=== Performing all operations on strings ===");
        addition(a, b);
        subtraction(a, b);
        multiplication(a, b);
        division(a, b);
        System.out.println("=".repeat(45));
    }
}

// NumericDataType Class
class NumericDataType<T extends Number> implements DataType<T> {
    
    @Override
    public void addition(T a, T b) {
        System.out.println("Adding 2 generic instances");
        double result = a.doubleValue() + b.doubleValue();
        System.out.println("Result: " + String.format("%.2f", result));
    }
    
    @Override
    public void subtraction(T a, T b) {
        System.out.println("Subtracting two generic instances");
        double result = a.doubleValue() - b.doubleValue();
        System.out.println("Result: " + String.format("%.2f", result));
    }
    
    @Override
    public void multiplication(T a, T b) {
        System.out.println("Multiplying two generic instances");
        double result = a.doubleValue() * b.doubleValue();
        System.out.println("Result: " + String.format("%.2f", result));
    }
    
    @Override
    public void division(T a, T b) {
        System.out.println("Dividing two generic instances");
        if (b.doubleValue() == 0) {
            System.out.println("Error: Cannot divide by zero");
            return;
        }
        double result = a.doubleValue() / b.doubleValue();
        System.out.println("Result: " + String.format("%.2f", result));
    }
    
    @Override
    public void performAll(T a, T b) {
        System.out.println("=== Performing all operations on numeric instances ===");
        addition(a, b);
        System.out.println();
        subtraction(a, b);
        System.out.println();
        multiplication(a, b);
        System.out.println();
        division(a, b);
        System.out.println("=".repeat(56));
    }
}

// Main Class
public class GenericDataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== GENERIC DATA TYPES DEMONSTRATION ===\n");
        
        // ========== STRING DATA TYPE EXAMPLES ==========
        System.out.println("========== STRING DATA TYPE ==========\n");
        
        StringDataType<String> stringOps = new StringDataType<>();
        
        // Example 1: String addition (concatenation)
        System.out.println("Example 1: String Addition");
        stringOps.addition("Hello", "World");
        System.out.println();
        
        // Example 2: String subtraction (not allowed)
        System.out.println("Example 2: String Subtraction");
        stringOps.subtraction("Hello", "World");
        System.out.println();
        
        // Example 3: String multiplication (not allowed)
        System.out.println("Example 3: String Multiplication");
        stringOps.multiplication("Hello", "World");
        System.out.println();
        
        // Example 4: String division (not allowed)
        System.out.println("Example 4: String Division");
        stringOps.division("Hello", "World");
        System.out.println();
        
        // Example 5: Perform all operations on strings
        System.out.println("Example 5: Perform All String Operations");
        stringOps.performAll("Java", "Programming");
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== NUMERIC DATA TYPE EXAMPLES ==========
        System.out.println("========== NUMERIC DATA TYPE ==========\n");
        
        NumericDataType<Integer> intOps = new NumericDataType<>();
        
        // Example 6: Integer operations
        System.out.println("Example 6: Integer Addition");
        intOps.addition(10, 20);
        System.out.println();
        
        System.out.println("Example 7: Integer Subtraction");
        intOps.subtraction(50, 30);
        System.out.println();
        
        System.out.println("Example 8: Integer Multiplication");
        intOps.multiplication(7, 8);
        System.out.println();
        
        System.out.println("Example 9: Integer Division");
        intOps.division(100, 4);
        System.out.println();
        
        // Example 10: Perform all operations
        System.out.println("Example 10: Perform All Integer Operations");
        intOps.performAll(25, 5);
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== DOUBLE DATA TYPE EXAMPLES ==========
        System.out.println("========== DOUBLE DATA TYPE ==========\n");
        
        NumericDataType<Double> doubleOps = new NumericDataType<>();
        
        // Example 11: Double operations
        System.out.println("Example 11: Double Addition");
        doubleOps.addition(15.75, 24.25);
        System.out.println();
        
        System.out.println("Example 12: Double Subtraction");
        doubleOps.subtraction(100.50, 45.30);
        System.out.println();
        
        System.out.println("Example 13: Double Multiplication");
        doubleOps.multiplication(3.5, 4.2);
        System.out.println();
        
        System.out.println("Example 14: Double Division");
        doubleOps.division(75.5, 2.5);
        System.out.println();
        
        // Example 15: Perform all operations on doubles
        System.out.println("Example 15: Perform All Double Operations");
        doubleOps.performAll(50.0, 10.0);
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== MIXED NUMERIC TYPES ==========
        System.out.println("========== MIXED NUMERIC TYPES ==========\n");
        
        // Example 16: Float operations
        NumericDataType<Float> floatOps = new NumericDataType<>();
        System.out.println("Example 16: Float Operations");
        floatOps.performAll(12.5f, 2.5f);
        System.out.println();
        
        // Example 17: Long operations
        NumericDataType<Long> longOps = new NumericDataType<>();
        System.out.println("Example 17: Long Operations");
        longOps.performAll(1000000000L, 250000000L);
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== ERROR HANDLING EXAMPLES ==========
        System.out.println("========== ERROR HANDLING ==========\n");
        
        // Example 18: Division by zero
        System.out.println("Example 18: Division by Zero");
        intOps.division(100, 0);
        System.out.println();
        
        // Example 19: String length constraint
        System.out.println("Example 19: String Length Validation (exceeding 100 chars)");
        String longString = "a".repeat(101);
        stringOps.addition(longString, "test");
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== CONSTRAINT TESTING ==========
        System.out.println("========== CONSTRAINT TESTING ==========\n");
        
        // Example 20: Maximum numeric values (within constraint 1 ≤ a,b ≤ 10⁹)
        System.out.println("Example 20: Large Numbers (within constraint)");
        NumericDataType<Integer> largeOps = new NumericDataType<>();
        largeOps.performAll(1000000000, 500000000);
        System.out.println();
        
        // Example 21: Valid string lengths
        System.out.println("Example 21: Valid String Lengths (100 chars max)");
        String str1 = "A".repeat(50);
        String str2 = "B".repeat(50);
        stringOps.addition(str1, str2);
        System.out.println();
        
        System.out.println("=".repeat(70) + "\n");
        
        // ========== INTERACTIVE MODE ==========
        System.out.println("========== INTERACTIVE MODE ==========\n");
        
        boolean running = true;
        while (running) {
            System.out.println("Choose data type:");
            System.out.println("1. String Operations");
            System.out.println("2. Integer Operations");
            System.out.println("3. Double Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter first string: ");
                    String s1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    String s2 = scanner.nextLine();
                    
                    if (s1.length() > 100 || s2.length() > 100) {
                        System.out.println("Error: String length must not exceed 100 characters\n");
                        break;
                    }
                    
                    System.out.println("\nChoose operation:");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.println("5. Perform All");
                    System.out.print("Enter operation: ");
                    int strOp = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println();
                    switch (strOp) {
                        case 1: stringOps.addition(s1, s2); break;
                        case 2: stringOps.subtraction(s1, s2); break;
                        case 3: stringOps.multiplication(s1, s2); break;
                        case 4: stringOps.division(s1, s2); break;
                        case 5: stringOps.performAll(s1, s2); break;
                        default: System.out.println("Invalid operation");
                    }
                    System.out.println();
                    break;
                    
                case 2:
                    System.out.print("Enter first integer (1 to 1000000000): ");
                    int i1 = scanner.nextInt();
                    System.out.print("Enter second integer (1 to 1000000000): ");
                    int i2 = scanner.nextInt();
                    
                    if (i1 < 1 || i1 > 1000000000 || i2 < 1 || i2 > 1000000000) {
                        System.out.println("Error: Numbers must be between 1 and 1000000000\n");
                        break;
                    }
                    
                    System.out.println("\nChoose operation:");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.println("5. Perform All");
                    System.out.print("Enter operation: ");
                    int intOp = scanner.nextInt();
                    
                    System.out.println();
                    switch (intOp) {
                        case 1: intOps.addition(i1, i2); break;
                        case 2: intOps.subtraction(i1, i2); break;
                        case 3: intOps.multiplication(i1, i2); break;
                        case 4: intOps.division(i1, i2); break;
                        case 5: intOps.performAll(i1, i2); break;
                        default: System.out.println("Invalid operation");
                    }
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.print("Enter first double (1.0 to 1000000000.0): ");
                    double d1 = scanner.nextDouble();
                    System.out.print("Enter second double (1.0 to 1000000000.0): ");
                    double d2 = scanner.nextDouble();
                    
                    if (d1 < 1 || d1 > 1000000000 || d2 < 1 || d2 > 1000000000) {
                        System.out.println("Error: Numbers must be between 1 and 1000000000\n");
                        break;
                    }
                    
                    System.out.println("\nChoose operation:");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.println("5. Perform All");
                    System.out.print("Enter operation: ");
                    int dblOp = scanner.nextInt();
                    
                    System.out.println();
                    switch (dblOp) {
                        case 1: doubleOps.addition(d1, d2); break;
                        case 2: doubleOps.subtraction(d1, d2); break;
                        case 3: doubleOps.multiplication(d1, d2); break;
                        case 4: doubleOps.division(d1, d2); break;
                        case 5: doubleOps.performAll(d1, d2); break;
                        default: System.out.println("Invalid operation");
                    }
                    System.out.println();
                    break;
                    
                case 4:
                    running = false;
                    System.out.println("\nThank you for using Generic Data Types!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
        
        scanner.close();
    }
}
