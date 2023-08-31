import java.util.*;

public class Hw_16928 {
	static int N;
	static int M;
	static int[] map = new int[101];
	static boolean[] visited = new boolean[101];
	static Queue<Pos> queue = new LinkedList<>();
	static int[] deltaX = { 1, 2, 3, 4, 5, 6 };
	static int result;

	static class Pos {
		int x, t;

		public Pos(int x, int t) {
			this.x = x;
			this.t = t;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N + M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			map[start] = end;
		}
		queue.add(new Pos(1, 0));
		visited[1] = true;
		bfs();
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pos current = queue.poll();
			if (current.x == 100) {
				System.out.println(current.t);
				return;
			}
			for (int i = 1; i < 7; i++) {
				int newLocation = current.x + i;
				if (newLocation > 100 || visited[newLocation]) {
					continue;
				}
				if (map[newLocation] != 0) {
					newLocation = map[newLocation];
				}
				result = current.t + 1;
				queue.add(new Pos(newLocation, result));
				visited[newLocation] = true;
			}
		}
	}
}
