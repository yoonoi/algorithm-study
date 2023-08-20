import java.util.*;

public class Hw_15650 {
	static StringBuilder sb = new StringBuilder();
	static int[] result;
	static boolean[] visited;
	static int pointer = 0;
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		visited = new boolean[N];

		combine(0);
		System.out.println(sb);
	}

	public static void combine(int r) {
		if (r == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		
		for (int i = pointer; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			result[r] = i + 1;
			pointer = result[r];
			visited[i] = true;
			combine(r + 1);
			visited[i] = false;
		}
	}
}
