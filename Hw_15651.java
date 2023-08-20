import java.util.*;

public class Hw_15651 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		
		backtracking(0);
		System.out.println(sb);
	}
	
	public static void backtracking(int r) {
		if(r == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++) {
			result[r] = i + 1;
			backtracking(r + 1);
		}
	}
}
