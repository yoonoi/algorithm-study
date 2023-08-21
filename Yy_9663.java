package backtracking;

import java.util.Scanner;

public class Yy_9663 {
	
	static int n, cnt;
	static int[] arr;
	
	static void nqueen(int depth) {
		// 모든 원소를 다 채운 상태면 cnt ++ 
		if(depth == n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[depth] = i;
			
			// 놓을 수 있는 위치면 재귀
			if(isPossible(depth)) 
				nqueen(depth + 1);
		}
	}
	
	// 일차원 배열로 두어 인덱스 = 열, 열은 항상 다르기 때문에 행과 대각선만 체크
	static boolean isPossible(int col) {
		
		for(int i=0; i<col; i++) {
			// 같은 행에 존재하는지
			if(arr[col] == arr[i]) 
				return false;
			
			// 같은 대각선에 존재하는지
			if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) 
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		cnt = 0;
		
		nqueen(0);
		System.out.println(cnt);
	}
}
