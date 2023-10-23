package gold;

import java.util.Scanner;

public class Kh_1717 {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}


		for (int i = 0; i < M; i++) {
			int operation = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(operation == 0) {
				union(a,b);				
			}else {
				if(findSet(a) == findSet(b)) {
					sb.append("yes").append("\n");
				}else {
					sb.append("no").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

	public static void union(int a, int b) {
		parent[findSet(b)] = findSet(a);
	}

	public static int findSet(int x) {
		if (x != parent[x]) {
			parent[x] = findSet(parent[x]);
		}
		return parent[x];
	}

}
