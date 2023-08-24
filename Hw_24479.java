import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Hw_24479 {
	static int n, m, r; // 정점, 간선, 시작노드
	static boolean[] visited;
	static int cnt = 1;
	static int[] order;
	static List<List<Integer>> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();

		visited = new boolean[n + 1];
		order = new int[n + 1];
		list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.get(start).add(end);
			list.get(end).add(start);
		}

		for (int i = 0; i <= n; i++) {
			list.get(i).sort(Comparator.naturalOrder());
		}

		dfs(r);

		for (int i = 1; i <= n; i++) {
			System.out.println(order[i]);
		}
	}

	public static void dfs(int startNode) {

		visited[startNode] = true;
		order[startNode] = cnt++;
		
		for (int node : list.get(startNode)) {
			if (!visited[node]) {
				dfs(node);
			}
		}

	}

}