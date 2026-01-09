package src.loops;

public class NeonNum {
	public static void main(String[] args) {
		int num = 9;
		int square_num = num * num;
		
		int sum_sq = 0;
		while (square_num != 0) {
			sum_sq = square_num % 10;
			square_num /= 10;
			
		}
		
		if(sum_sq == square_num){
			System.out.println("neon number");
		}
		else {
			System.out.println("not");
		}
	}
}
