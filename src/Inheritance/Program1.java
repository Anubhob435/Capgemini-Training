package src.Inheritance;

public class Program1{}

class A1 {
    int a = 100;

    public void a() {
        System.out.println("a()");
    }

    // Instance Initialization Block
    {
        System.out.println("A non-static init");
    }

    public A1() {
        super(); // Implicit or explicit call to Object constructor
        System.out.println("A constructor");
    }
}

class B1 extends A1 {
    int b = 200;

    public void b() {
        System.out.println("b()");
    }

    // Instance Initialization Block
    {
        System.out.println("B non-static init");
    }

    public B1() {
        super(); // Calls A's constructor
        System.out.println("B constructor");
    }
}

class C extends B {
    int c = 300;

    public void c() {
        System.out.println("c()");
    }

    // Instance Initialization Block
    {
        System.out.println("C non-static init");
    }

    public C() {
        super(); // Calls B's constructor
        System.out.println("C constructor");
    }

    public static void main(String[] args) {
        C obj = new C();

        // Accessing fields
        System.out.println(obj.c); // Prints 300
        System.out.println(obj.b); // Prints 200
        System.out.println(obj.a); // Prints 100

        // Calling methods
        obj.c();
        obj.b();
        obj.a();
    }
}
