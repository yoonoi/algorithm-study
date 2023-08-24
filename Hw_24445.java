import java.util.*;

public class Hw_24445 {
	static int N, M, R;
	static int[] order;
	static boolean[] visited;
	static int count = 1;
	static ArrayList<ArrayList<Integer>> list;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		list = new ArrayList<>();
		visited = new boolean[N + 1];
		order = new int[N + 1];
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
		bfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append('\n');
		}

		System.out.println(sb);
	}

	public static void bfs(int startNode) {
		visited[startNode] = true;
		order[startNode] = count++;
		for (int node : list.get(startNode)) {
			if (!visited[node]) {
				visited[node] = true;
				order[node] = count++;
				queue.add(node);
			}
		}
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (int node : list.get(nowNode)) {
				if (!visited[node]) {
					visited[node] = true;
					order[node] = count++;
					queue.add(node);
				}
			}
		}
	}
}
