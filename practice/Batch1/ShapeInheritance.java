package practice.Batch1;

import java.util.Scanner;

// Shape Interface
interface Shape {
    double getArea();
    double getPerimeter();
    String toString();
}

// Rectangle Class implementing Shape
class Rectangle implements Shape {
    protected double length;
    protected double width;
    
    // Constructor
    public Rectangle(double length, double width) {
        if (length < 1 || length > 100 || width < 1 || width > 100) {
            throw new IllegalArgumentException("Length and width must be between 1 and 100");
        }
        this.length = length;
        this.width = width;
    }
    
    // Calculate area: length × width
    @Override
    public double getArea() {
        return length * width;
    }
    
    // Calculate perimeter: 2 × (length + width)
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
    
    // String representation
    @Override
    public String toString() {
        return String.format("Rectangle [Length=%.2f, Width=%.2f, Area=%.2f, Perimeter=%.2f]",
                           length, width, getArea(), getPerimeter());
    }
    
    // Getters
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
}

// Square Class extending Rectangle
class Square extends Rectangle {
    
    // Constructor - sets both length and width to side
    public Square(double side) {
        super(side, side);
        if (side < 1 || side > 100) {
            throw new IllegalArgumentException("Side must be between 1 and 100");
        }
    }
    
    // Area is already inherited and calculated as: side × side = side²
    // Perimeter is already inherited and calculated as: 2 × (side + side) = 4 × side
    
    @Override
    public String toString() {
        return String.format("Square [Side=%.2f, Area=%.2f, Perimeter=%.2f]",
                           length, getArea(), getPerimeter());
    }
    
    // Getter for side
    public double getSide() {
        return length; // length and width are equal for square
    }
}

// Circle Class implementing Shape
class Circle implements Shape {
    private double radius;
    private static final double PI = Math.PI;
    
    // Constructor
    public Circle(double radius) {
        if (radius < 1 || radius > 100) {
            throw new IllegalArgumentException("Radius must be between 1 and 100");
        }
        this.radius = radius;
    }
    
    // Calculate area: π × radius²
    @Override
    public double getArea() {
        return PI * radius * radius;
    }
    
    // Calculate perimeter (circumference): 2 × π × radius
    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
    
    // String representation
    @Override
    public String toString() {
        return String.format("Circle [Radius=%.2f, Area=%.2f, Perimeter=%.2f]",
                           radius, getArea(), getPerimeter());
    }
    
    // Getter
    public double getRadius() {
        return radius;
    }
}

// Main Class
public class ShapeInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SHAPE INHERITANCE SYSTEM ===\n");
        
        // Demonstration Examples
        System.out.println("--- Example Shapes ---\n");
        
        // Create Rectangle
        System.out.println("1. Rectangle:");
        Rectangle rectangle = new Rectangle(10, 5);
        System.out.println(rectangle);
        System.out.println("   Area calculation: 10 × 5 = " + rectangle.getArea());
        System.out.println("   Perimeter calculation: 2 × (10 + 5) = " + rectangle.getPerimeter());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Create Square
        System.out.println("2. Square:");
        Square square = new Square(7);
        System.out.println(square);
        System.out.println("   Area calculation: 7² = " + square.getArea());
        System.out.println("   Perimeter calculation: 4 × 7 = " + square.getPerimeter());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Create Circle
        System.out.println("3. Circle:");
        Circle circle = new Circle(6);
        System.out.println(circle);
        System.out.println("   Area calculation: π × 6² = " + circle.getArea());
        System.out.println("   Perimeter calculation: 2 × π × 6 = " + circle.getPerimeter());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Array of shapes demonstrating polymorphism
        System.out.println("--- Array of Shapes (Polymorphism) ---\n");
        Shape[] shapes = {
            new Rectangle(8, 4),
            new Square(5),
            new Circle(3),
            new Rectangle(15, 10),
            new Square(9),
            new Circle(7.5)
        };
        
        double totalArea = 0;
        double totalPerimeter = 0;
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println((i + 1) + ". " + shapes[i]);
            totalArea += shapes[i].getArea();
            totalPerimeter += shapes[i].getPerimeter();
        }
        
        System.out.println("\nTotal Area of all shapes: " + String.format("%.2f", totalArea));
        System.out.println("Total Perimeter of all shapes: " + String.format("%.2f", totalPerimeter));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Comparison of shapes
        System.out.println("--- Shape Comparisons ---\n");
        Rectangle rect1 = new Rectangle(12, 8);
        Square square1 = new Square(10);
        Circle circle1 = new Circle(5);
        
        System.out.println("Rectangle: " + rect1);
        System.out.println("Square: " + square1);
        System.out.println("Circle: " + circle1);
        
        System.out.println("\nLargest area: ");
        if (rect1.getArea() >= square1.getArea() && rect1.getArea() >= circle1.getArea()) {
            System.out.println("  Rectangle with area " + String.format("%.2f", rect1.getArea()));
        } else if (square1.getArea() >= circle1.getArea()) {
            System.out.println("  Square with area " + String.format("%.2f", square1.getArea()));
        } else {
            System.out.println("  Circle with area " + String.format("%.2f", circle1.getArea()));
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test constraints
        System.out.println("--- Testing Constraints ---\n");
        try {
            System.out.println("Creating rectangle with valid dimensions (50, 30)...");
            Rectangle validRect = new Rectangle(50, 30);
            System.out.println("Success: " + validRect);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            System.out.println("\nAttempting to create rectangle with invalid dimensions (150, 30)...");
            Rectangle invalidRect = new Rectangle(150, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
        
        try {
            System.out.println("\nAttempting to create circle with invalid radius (0.5)...");
            Circle invalidCircle = new Circle(0.5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Interactive Mode
        System.out.println("=== INTERACTIVE MODE ===\n");
        
        boolean running = true;
        while (running) {
            System.out.println("--- Choose a Shape ---");
            System.out.println("1. Rectangle");
            System.out.println("2. Square");
            System.out.println("3. Circle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter length (1-100): ");
                        double length = scanner.nextDouble();
                        System.out.print("Enter width (1-100): ");
                        double width = scanner.nextDouble();
                        Rectangle userRect = new Rectangle(length, width);
                        System.out.println("\n" + userRect);
                        System.out.println();
                        break;
                        
                    case 2:
                        System.out.print("Enter side (1-100): ");
                        double side = scanner.nextDouble();
                        Square userSquare = new Square(side);
                        System.out.println("\n" + userSquare);
                        System.out.println();
                        break;
                        
                    case 3:
                        System.out.print("Enter radius (1-100): ");
                        double radius = scanner.nextDouble();
                        Circle userCircle = new Circle(radius);
                        System.out.println("\n" + userCircle);
                        System.out.println();
                        break;
                        
                    case 4:
                        running = false;
                        System.out.println("\nThank you for using Shape Inheritance System!");
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please try again.\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values.\n");
                scanner.nextLine(); // Clear buffer
            }
        }
        
        scanner.close();
    }
}
