package silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Kh_24479 {
	static boolean[] visited;
	static int N, M, R, count=0;
	static ArrayList<ArrayList<Integer>> E;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		E = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			E.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			int idx = sc.nextInt();
			int destination = sc.nextInt();
			E.get(idx - 1).add(destination);
			E.get(destination - 1).add(idx);
		}
		for(int i = 0 ; i < E.size() ; i++) {
			E.get(i).sort(Comparator.naturalOrder());
		}
		
		result = new int[N];
		visited = new boolean[N];
		dfs(R);

		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append('\n');
		}

		System.out.println(sb);
	}

	public static void dfs(int r) {
		visited[r-1] = true;
		count++;

		result[r-1] = count;

		
			for (int j = 0; j < E.get(r-1).size(); j++) {
				int d = E.get(r-1).get(j);
				if (!visited[d - 1]) {
					dfs(d);
				}
			}
		
	}

}