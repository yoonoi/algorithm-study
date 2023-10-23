import java.util.*;

public class Hw_1717 {
	static int N, M;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		p = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			int command = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(command == 0) {
				union(a, b);
			} else {
				if(find(a) == find(b)) {
					sb.append("YES").append('\n');
				} else {
					sb.append("NO").append('\n');
				}
			}
		}
		System.out.println(sb);
	}

	static void union(int x, int y) {
		p[find(y)] = find(x);
	}

	static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
}
