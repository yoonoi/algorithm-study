import java.util.*;

public class Hw_5014 {
	static int F, S, G, U, D;

	static class floor {
		int num, count;

		public floor(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		visited = new boolean[F + 1];
		Queue<floor> queue = new LinkedList<>();
		queue.add(new floor(S, 0));
		visited[S] = true;
		while (!queue.isEmpty()) {
			floor now = queue.poll();
			if (now.num == G) {
				System.out.println(now.count);
				return;
			}
			int newUpperFloor = now.num + U;
			int newLowerFloor = now.num - D;
			if (newUpperFloor <= F && !visited[newUpperFloor]) {
				queue.add(new floor(newUpperFloor, now.count + 1));
				visited[newUpperFloor] = true;
			}
			if (newLowerFloor > 0 && !visited[newLowerFloor]) {
				queue.add(new floor(newLowerFloor, now.count + 1));
				visited[newLowerFloor] = true;
			}
		}
		System.out.println("use the stairs");
	}
}
