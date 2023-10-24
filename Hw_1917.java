import java.util.*;

public class Hw_1917 {
	static int N, M;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		p = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int isConnected = sc.nextInt();
				if (i < j && isConnected == 1) {
					union(i, j);
				}
			}
		}

		int[] travel = new int[M];
		for (int i = 0; i < M; i++) {
			travel[i] = sc.nextInt();
		}
		for (int i = 0; i < M - 1; i++) {
			if (find(travel[i]) != find(travel[i + 1])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static void union(int x, int y) {
		p[find(y)] = find(x);
	}

	public static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
}
