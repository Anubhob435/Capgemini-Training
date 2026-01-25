package src.WeeklyTests;

class ParentH {
    static void display() {
        System.out.print("Parent");
    }
}

class ChildH extends ParentH {
    static void display() {
        System.out.print("Child");
    }
}

public class Q81_PolymorphismTest  {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";

        System.out.println(s1 == s2);
    }
}

