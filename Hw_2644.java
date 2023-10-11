import java.util.*;

public class Hw_2644 {
	static int n;
	static int start;
	static int end;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		int m = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).add(y);
			list.get(y).add(x);
		}
		int answer = find(start, end);
		System.out.println(answer);
	}

	static int find(int x, int y) {
		Queue<Integer> queue = new LinkedList<>();
		dist[x] = 0;
		visited[x] = true;
		queue.add(x);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == y) {
				return dist[now];
			}
			for (int next : list.get(now)) {
				if (!visited[next]) {
					dist[next] = dist[now] + 1;
					queue.add(next);
					visited[next] = true;
				}
			}

		}
		return -1;
	}
}