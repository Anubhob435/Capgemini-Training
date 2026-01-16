package src.Encapsulation;

public class Demo {
	String Name;
	private Demo() {
		
	}
	Demo (String Name){
		this.Name = Name;
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
}