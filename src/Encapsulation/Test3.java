package src.Encapsulation;

public class Test3 {
	public static void main(String[] args) {

		Demo obj=new Demo();
		
		//obj.a=30;
		obj.setValueA(100);
		
		System.out.println(obj.getValueA());
	}
}