import java.io.*;
import java.util.*;

public class Yj_1504{

    static int INF = Integer.MAX_VALUE;

    static int N, E;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        // 그래프 생성
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int e = 0; e < E; e++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        int distA = 0;
        int distB = 0;

        distA += dijkstra(1, v1);
        distA += dijkstra(v1, v2);
        distA += dijkstra(v2, N);

        distB += dijkstra(1, v2);
        distB += dijkstra(v2, v1);
        distB += dijkstra(v1, N);

        int answer = (distA >= INF && distB >= INF) ? -1 : Math.min(distA, distB);

        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        for(int i=0; i<=N; i++) {
            distance[i] = INF;
        }

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int dist = node.weight;
            int nowNum = node.end;

            if(distance[nowNum] < dist) {
                continue;
            }

            for(Node nxt : graph[nowNum]) {
                int nxtNum = nxt.end;
                int nxtDist = nxt.weight;

                int cost = dist + nxtDist;
                // 더 짧은 거리가 있으면
                if(cost < distance[nxtNum]) {
                    distance[nxtNum] = cost;
                    pq.add(new Node(nxtNum, cost));
                }
            }
        }

        return distance[end];
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
