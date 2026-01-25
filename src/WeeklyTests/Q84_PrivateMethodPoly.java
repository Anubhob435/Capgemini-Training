package src.WeeklyTests;

class ParentPrivate {
    private void display() {
        System.out.print("Parent");
    }

    void call() {
        display();
    }
}

class ChildPrivate extends ParentPrivate {
    private void display() {
        System.out.print("Child");
    }
}

public class Q84_PrivateMethodPoly {
    public static void main(String[] args) {
        ParentPrivate p = new ChildPrivate();
        p.call();
    }
}