import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Jh_9370 {
    static int n, m, t, s, g, h;
    static ArrayList<Edge>[] adj;
    static int[] dist_s, dist_g, dist_h;
    static boolean[] visit;
    static TreeMap<Integer, Boolean> candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v1, v2, cost;

                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());

                adj[v1].add(new Edge(v2, cost));
                adj[v2].add(new Edge(v1, cost));
            }

            candidate = new TreeMap<>();
            for (int i = 0; i < t; i++)
                candidate.put(Integer.parseInt(br.readLine()), false);

            dist_s = new int[n + 1];
            dist_g = new int[n + 1];
            dist_h = new int[n + 1];

            Arrays.fill(dist_s, Integer.MAX_VALUE);
            Arrays.fill(dist_g, Integer.MAX_VALUE);
            Arrays.fill(dist_h, Integer.MAX_VALUE);

            dijkstra(s, dist_s);
            dijkstra(g, dist_g);
            dijkstra(h, dist_h);

            for (Map.Entry entry : candidate.entrySet()) {
                int idx = (int) entry.getKey();

                if (dist_s[idx] == dist_s[g] + dist_g[h] + dist_h[idx]
                        || dist_s[idx] == dist_s[h] + dist_h[g] + dist_g[idx]) {
                    candidate.put(idx, true);
                }
            }

            for (Map.Entry entry : candidate.entrySet()) {
                if ((boolean) entry.getValue()) {
                    System.out.print(entry.getKey() + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dijkstra(int start, int[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });
        visit = new boolean[n + 1];
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            visit[now.vertex] = true;

            for (Edge next : adj[now.vertex]) {
                if (!visit[next.vertex] && dist[next.vertex] > dist[now.vertex] + next.cost) {
                    dist[next.vertex] = dist[now.vertex] + next.cost;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

    private static class Edge {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}