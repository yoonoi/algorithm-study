import java.util.*;

public class Hw_24444 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, R;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] order;
	static int cnt = 1;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		visited = new boolean[N + 1];
		order = new int[N + 1];
		list = new ArrayList<>();
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
			list.get(i).sort(Comparator.naturalOrder());
		}
		
		bfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append('\n');
		}
		System.out.println(sb);
	}

	public static void bfs(int startNode) {
		visited[startNode] = true;
		order[startNode] = cnt++;
		for(int node : list.get(startNode)) {
			if(!visited[node]) {
				visited[node] = true;
				queue.add(node);
				order[node] = cnt++;
			}
		}
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			for(int node : list.get(nowNode)) {
				if(!visited[node]) {
					visited[node] = true;
					queue.add(node);
					order[node] = cnt++;
				}
			}
		}
	}
}