package src.Constructors;

public class Demo {

	
	//private variable global var,method,Constructor
	//class Initializer not used 
	// Constructor ---> object 
	private Demo(){
		-
	}
	private int a;
	// write value , read the value
	
	//method write design setter method
	//read the value design getter method
	
	public int getValueA() {
		return a;
	}
	
	public void setValueA(int a) {
		this.a=a;
	}
	// Factory Method
	static Demo object;//null/ref
	public static Demo getA() {
		if(object==null) {
		object=new Demo();
		}
		return object;
	}
}