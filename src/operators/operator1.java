package src.operators;

public class operator1 {
        public static void main(String[] args) {
                int a = 10;
                int b = 20;
                int c = 0;
                
                // Arithmetic Operators
                c = a + b;
                System.out.println("a + b = " + c);
                
                c = b - a;
                System.out.println("b - a = " + c);
                
                c = a * b;
                System.out.println("a * b = " + c);
                
                c = b / a;
                System.out.println("b / a = " + c);
                
                c = b % a;
                System.out.println("b % a = " + c);
                
                // Increment and Decrement Operators
                System.out.println("a before increment: " + a);
                System.out.println("a after increment: " + (++a));
                
                System.out.println("b before decrement: " + b);
                System.out.println("b after decrement: " + (--b));
        }
}