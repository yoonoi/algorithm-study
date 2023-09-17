package BOJ;

import java.util.Scanner;

public class Mw_2740 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] A = new int[N][M];
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col ++) {
				A[row][col] = sc.nextInt();
			}
		}
		
		M = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] B = new int[M][K];
		
		for(int row = 0; row < M; row++) {
			for(int col = 0; col < K; col ++) {
				B[row][col] = sc.nextInt();
			}
		}
		
		int[][] mul = new int[N][K];
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < K; col ++) {
				for(int idx = 0; idx < M; idx++) {
					mul[row][col] += A[row][idx] * B[idx][col];
				}
			}
		}
		
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < K; col++) {
				if(col == K-1) {
					System.out.println(mul[row][col]);
				} else {
					System.out.print(mul[row][col] + " ");
				}
			}
		}
	}
}
