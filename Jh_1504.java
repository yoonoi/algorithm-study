import java.util.*;

public class Jh_1504 {
    public static final int INF = Integer.MAX_VALUE;
    static ArrayList<Pair>[] list;
    static int d[][];
    static int v;
    static int e;

    public static class Pair implements Comparable<Pair>{
        int index;
        int distance;

        Pair(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair o) {
            return distance <= o.distance ? -1 : 1;
        }
    }
    public static void dijkstra(int start, int index) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        d[index][start] = 0;
        pq.offer(new Pair(start, d[index][start]));

        while(!pq.isEmpty()) {
            Pair p = pq.peek();
            int current = p.index;
            int distance = p.distance;
            pq.poll();

            if(d[index][current] < distance)
                continue;

            for(int i=0; i<list[current].size(); i++) {
                int next = list[current].get(i).index;
                int nextDistance = distance + list[current].get(i).distance;

                if(nextDistance < d[index][next]) {
                    d[index][next] = nextDistance;
                    pq.offer(new Pair(next, nextDistance));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        list = new ArrayList[v+1];
        d = new int[3][v+1];

        // 변수 초기화
        for(int i=1; i<=v; i++) {
            d[0][i] = INF;
            d[1][i] = INF;
            d[2][i] = INF;
            list[i] = new ArrayList<Pair>();
        }

        for(int i=0; i<e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            list[a].add(new Pair(b, w));
            list[b].add(new Pair(a, w));
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        dijkstra(1, 0);
        dijkstra(a, 1);
        dijkstra(b, 2);

        int min = Math.min(d[0][a] + d[1][b] + d[2][v], d[0][b] + d[2][a] + d[1][v]);
        if(d[0][a] == INF || d[1][b] == INF || d[1][v] == INF) {
            if(d[0][b] == INF || d[1][a] == INF || d[1][v] == INF) {
                System.out.println(-1);
            }else {
                System.out.println(min);
            }

        }else {
            System.out.println(min);
        }
    }
}