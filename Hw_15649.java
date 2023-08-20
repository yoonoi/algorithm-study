import java.util.*;

public class Hw_15649 {
	static boolean[] visited;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N];
		result = new int[M];
		
		backtracking(0);
		System.out.println(sb);
	}

	public static void backtracking(int r) {
		if (r == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + 1).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			result[r] = i;
			visited[i] = true;
			backtracking(r + 1);
			visited[i] = false;
		}
	}
}
