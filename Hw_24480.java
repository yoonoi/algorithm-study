import java.util.*;

public class Hw_24480 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, R;
	static int[] order;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static int count = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		list = new ArrayList<>();
		order = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.get(start).add(end);
			list.get(end).add(start);
		}

		for (int i = 1; i <= N; i++) {
			list.get(i).sort(Comparator.reverseOrder());
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			 System.out.println(order[i]);
		}
	}

	public static void dfs(int startNode) {
		visited[startNode] = true;
		order[startNode] = count++;

		for (int node : list.get(startNode)) {

			if (!visited[node]) {
				dfs(node);
			}
		}

	}
}
