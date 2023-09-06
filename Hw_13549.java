import java.util.*;

public class Hw_13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visited = new boolean[100001];
		class Pos {
			int location, time;

			public Pos(int location, int time) {
				this.location = location;
				this.time = time;
			}
		}
		Queue<Pos> queue = new LinkedList<>();

		queue.add(new Pos(N, 0));
		visited[N] = true;

		while (!queue.isEmpty()) {
			Pos now = queue.poll();
			if (now.location == K) {
				System.out.println(now.time);
				return;
			}
			int front = now.location + 1;
			int back = now.location - 1;
			int telpo = now.location * 2;
			if ((back >= 0 && back <= 100000) && !visited[back]) {
				queue.add(new Pos(back, now.time + 1));
				visited[back] = true;
			}
			if ((telpo >= 0 && telpo <= 100000) && !visited[telpo]) {
				queue.add(new Pos(telpo, now.time));
				visited[telpo] = true;
			}
			if ((front >= 0 && front <= 100000) && !visited[front] && front != telpo) {
				queue.add(new Pos(front, now.time + 1));
				visited[front] = true;
			}

		}
	}
}