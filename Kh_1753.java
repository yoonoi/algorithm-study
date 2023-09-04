package gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kh_1753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int K = sc.nextInt();

		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		boolean[] visited = new boolean[V + 1];

		ArrayList<ArrayList<int[]>> ways = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			ways.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int depart = sc.nextInt();
			int destine = sc.nextInt();
			int weight = sc.nextInt();
			int[] weighted = { destine, weight };
			ways.get(depart).add(weighted);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[1] < o2[1]) {
					return -1;
				} else if (o1[1] > o2[1]) {
					return 1;
				}
				return 0;
			}
		});

		int[] start = { K, 0 };

		dist[K] = 0;

		pq.add(start);

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int nodeNum = tmp[0];
			if (visited[nodeNum]) {
				continue;
			}
			visited[nodeNum] = true;

			for (int i = 0; i < ways.get(nodeNum).size(); i++) {
				int[] nextNode = ways.get(nodeNum).get(i);
				int nextNodeNum = nextNode[0];

				if (dist[nextNodeNum] > dist[nodeNum] + nextNode[1]) {
					dist[nextNodeNum] = dist[nodeNum] + nextNode[1];

					int[] next = { nextNodeNum, dist[nextNodeNum] };
					pq.add(next);
				}

			}

		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
}
