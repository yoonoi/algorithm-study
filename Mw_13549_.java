package BOJ;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Mw_13549_ {

    static int n, k; // 수빈 & 동생
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return this.time - o.time;
        }
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] delta = {-1, 1};

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            int nextIdx;
            // 1. 1초 후일 때(+-1)
            for(int i=0; i<2; i++) {
                nextIdx = now.idx + delta[i];

                if(nextIdx < 0 || nextIdx >= dist.length) continue;

                if(dist[nextIdx] > now.time + 1) {
                    dist[nextIdx] = now.time + 1;
                    pq.offer(new Node(nextIdx, dist[nextIdx]));
                }
            }

            // 2. 0초 후일 때(*2)
            nextIdx = now.idx * 2;
            if(nextIdx >= dist.length) continue;
            if(dist[nextIdx] > now.time) {
                dist[nextIdx] = now.time;
                pq.offer(new Node(nextIdx, dist[nextIdx]));
            }
        }

//        System.out.println(Arrays.toString(dist));
        return dist[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int big = Math.max(n, k);
        dist = new int[2 * big + 1];
        Arrays.fill(dist, INF);

        System.out.println(dijkstra(n, k));
    }

}