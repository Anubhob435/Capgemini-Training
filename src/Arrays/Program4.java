package src.Arrays;

public class Program4 {


	public static void main(String[] args) {
		int a[]= {10,20,30};
		int []res=demo(a);
		for(int i=0; i<a. length; i++) {
		System.out.println(res[i]);
		}
	}

	public static int [] demo(int []a) {
	
	int []b=new int[a. length];
	
	for(int i=0; i<a. length; i++) {
	b[i]=a[i]*3;
	

	}
	return b;
	}
	}