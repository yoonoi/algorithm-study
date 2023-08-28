import java.util.*;

public class Hw_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();
		int command = sc.nextInt();
		int[][] relationship = new int[command][2];
		boolean[] visited = new boolean[node + 1];

		for (int i = 0; i < command; i++) {
			relationship[i][0] = sc.nextInt();
			relationship[i][1] = sc.nextInt();
		}

		Queue<Integer> queue = new LinkedList<>();

		int result = 0;
		visited[1] = true;
		for (int i = 0; i < command; i++) {
			if (relationship[i][0] == 1) {
				queue.add(relationship[i][1]);
				visited[relationship[i][1]] = true;
				result++;
			}
			if (relationship[i][1] == 1) {
				queue.add(relationship[i][0]);
				visited[relationship[i][0]] = true;
				result++;
			}
		}

		while (!queue.isEmpty()) {
			int nowNode = queue.poll();

			for (int i = 0; i < command; i++) {
				if (relationship[i][0] == nowNode && !visited[relationship[i][1]]) {
					queue.add(relationship[i][1]);
					visited[relationship[i][1]] = true;
					result++;
				}
				if (relationship[i][1] == nowNode && !visited[relationship[i][0]]) {
					queue.add(relationship[i][0]);
					visited[relationship[i][0]] = true;
					result++;
				}
			}
		}

		System.out.println(result);
	}
}