package src.WeeklyTests;

abstract class AbstractC {
    AbstractC() {
        System.out.print("Abstract ");
    }
    abstract void show();
}

class ConcreteC extends AbstractC {
    ConcreteC() {
        System.out.print("Concrete ");
    }
    void show() {
        System.out.print("Show");
    }
}

public class Q68_AbstractConstructor {
    public static void main(String[] args) {
        ConcreteC obj = new ConcreteC();
        obj.show();
    }
}