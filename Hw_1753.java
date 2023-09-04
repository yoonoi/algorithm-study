import java.util.*;

public class Hw_1753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int startNode = sc.nextInt();
		int[] result = new int[V + 1];
		int count = 0;
		class Node {
			int nodeNum, value;

			public Node(int nodeNum, int value) {
				this.nodeNum = nodeNum;
				this.value = value;
			}
		}
		ArrayList<ArrayList<Node>> relationship = new ArrayList<>();
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.value - o2.value;
			}

		});
		Arrays.fill(result, Integer.MAX_VALUE);
		result[startNode] = 0;
		for (int i = 0; i <= V; i++) {
			relationship.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int value = sc.nextInt();
			relationship.get(start).add(new Node(end, value));
			if (start == startNode) {

				if (result[end] > value) {
					queue.add(new Node(end, value));
					result[end] = value;
				}

			}
		}

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			for (Node node : relationship.get(current.nodeNum)) {
				if (result[node.nodeNum] > node.value + current.value) {
					result[node.nodeNum] = node.value + current.value;
					queue.add(new Node(node.nodeNum, node.value + current.value));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (result[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(result[i]);
			}
		}

	}
}