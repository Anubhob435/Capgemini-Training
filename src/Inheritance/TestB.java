package src.Inheritance;

class TestB extends TestA {
    
    // Label (2) points to this constructor
    public TestB() {
        super(10);  // Written on board as "supa(10)"
        System.out.println(" TestB ");
    }
    public static void main(String[] args) {
    	TestB obj = new TestB();
	}
}