package src.WeeklyTests;

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.print("Circle");
    }
}

public class Q17_AbstractDemo {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        if (a && b || a) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}