package src.Interface;

interface I{
	static void keep() {
		System.out.println("hehe");
	}

}

interface I2{
	final static int a=10;
	public abstract void take();
	static void keep() {
		System.out.println("keep");
		
	}
}
public class Demo implements I2,I{
public void take() {
	System.out.println("take it");
}
public static void main(String[] args) {
	Demo d=new Demo();
	I.keep();I2.keep();
	d.take();
	System.out.println("I2.a");
	
	
}
		
	}
	


//whenever the class not implementing the interface and trying to access the static members of an interface by interface name as a reference at that time the interface static members will get loaded in static area
//whenever the class not implementing the interface and trying to access the static members of 
//an interface by interface name as a 
//reference at that time the interface static members will get loaded in static area