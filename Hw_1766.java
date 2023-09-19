import java.util.*;

public class Hw_1766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> problem = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int[] count = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			problem.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			problem.get(first).add(second);
			count[second]++;
		}
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			for (int node : problem.get(now)) {
				count[node]--;
				if (count[node] == 0) {
					queue.add(node);
				}
			}
		}
		System.out.println(sb);
	}
}
