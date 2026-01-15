package src.Arrays;

public class Program5 {
	public static void printarr(int[][] res) {
		for(int i =0; i<res.length; i++) {
			for(int j = 0; j <res[i].length; j++) {
				System.out.println(res[i][j] + " s");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int [][] a = {{7, 9},{1, 4}};
		int [][] b = {{1, 2},{3, 4}};
		printarr(sum(a, b));
		
	}
	public static int[][] sum(int [][] a, int [][] b){

		int row=a.length;
		int col=a[0].length;
		int [][] res=new int [row][col];

		for(int i=0; i<row; i++) {

			for(int j=0; j<col; j++) {
				res[i][j] =a[i][j] + b[j][i];

			}
		}
		return res;
	}
}
