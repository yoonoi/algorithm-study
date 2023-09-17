package divideAndConquer;

import java.util.Scanner;

public class Yy_1780 {
	
	static int[][] map;
	static int minus = 0;
	static int zero = 0;
	static int plus = 0;
	
	static boolean check(int row, int col, int size) {
		int start = map[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(map[i][j] != start) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void divide(int row, int col, int size) {
		if(check(row, col, size)) {
			if(map[row][col] == -1)
				minus++;
			else if(map[row][col] == 1)
				plus++;
			else
				zero++;
			
			return;
		}
		
		for(int i=row; i<row+size; i+=size/3) {
			for(int j=col; j<col+size; j+=size/3) {
				divide(i, j, size/3);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		divide(0, 0, n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

}
