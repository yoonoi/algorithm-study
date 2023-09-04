import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Jh_1753 {
    static ArrayList<Node>[] list;
    private static int v;
    private static int e;
    private static int start;
    private static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        start = sc.nextInt();
        list = new ArrayList[v + 1];
        distance = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        //초기화
        Arrays.fill(distance, INF);
        distance[start] = 0;
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v, w));
        }
        dijkstra();
        for (int i = 1; i <= v; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (distance[vertex] < weight) {
                continue;
            }
            for (int i = 0; i < list[vertex].size(); i++) {
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) {
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
