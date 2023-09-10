import java.io.*;
import java.util.*;

public class Jh_13549 {

    static class node implements Comparable<node> {
        int to;
        int w;

        public node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(node v) {
            if (this.w > v.w)
                return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(n, 0));


        while(!pq.isEmpty()){
            node now = pq.poll();
            node [] next = {
                    new node(now.to-1, 1),
                    new node(now.to+1, 1),
                    new node(now.to*2, 0)
            };
            for(node cur : next){
                if(cur.to<0||cur.to>100000) continue; // out of bounds
                if(dist[cur.to] > dist[now.to] + cur.w){
                    dist[cur.to] = dist[now.to] + cur.w;
                    pq.add(new node(cur.to, dist[cur.to]));
                }
            }
        }

        bw.write(dist[k] + "\n");
        bw.flush();
        bw.close();
    }
}