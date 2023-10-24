package gold;

import java.util.Scanner;

public class Kh_1976 {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;

		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int link = sc.nextInt();
				if (i < j && link == 1) {
					union(i, j);
				}
			}
		}
		int[] plan = new int[M];
		boolean flag = true;
		for (int m = 0; m < M; m++) {
			plan[m] = findSet(sc.nextInt());
			if(m >= 1 && plan[m]!= plan[m-1]) {
				flag = false;
			}
		}
		
		
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	public static void union(int a, int b) {
		parent[findSet(b)] = findSet(a);
	}

	public static int findSet(int x) {
		if (parent[x] != x) {
			parent[x] = findSet(parent[x]);
		}
		return parent[x];
	}
}
