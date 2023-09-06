import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Yj_9730_ {
    public static class Node implements Comparable<Node>{
        int dest;
        long weight;
        Node(){}
        Node(int a,long b){
            dest=  a;
            weight = b;
        }
        @Override
        public int compareTo(Node o) {
            if(this.weight > o.weight )return 1;
            return 0;
        }
    }
    public static int n,m,t;
    public static int s,g,h; //시작점, 다리 시작, 다리 끝
    public static ArrayList<Node> adj[];
    public static long dist[];
    public static int candi[];
    public static PriorityQueue<Node> q = new PriorityQueue<Node>();

    public static void initDist(){
        q.clear();
        Node start = new Node(s,0);
        q.offer(start);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(dist[cur.dest] < cur.weight) continue;
            for(int i=0;i<adj[cur.dest].size();i++) {
                int next = adj[cur.dest].get(i).dest;
                long cost = adj[cur.dest].get(i).weight;
                if(dist[next] > cur.weight + cost) {
                    dist[next] = cur.weight + cost;
                    q.offer(new Node(next,cur.weight+cost));
                }
            }
        }
    }

    public static void go() {
        initDist();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc--!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n+1];
            candi = new int[n+1];
            dist = new long[n+1];
            for(int i=1;i<=n;i++) {
                adj[i] = new ArrayList<Node>();
                dist[i] = 2000000000;
            }
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            for(int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int a,b;
                long c;
                a = Integer.parseInt(st.nextToken());
                b= Integer.parseInt(st.nextToken());
                c= Long.parseLong(st.nextToken());

                if((a==g && b==h) || (a==h && b==g)) {
                    adj[a].add(new Node(b,c*2-1));
                    adj[b].add(new Node(a,c*2-1));
                }else{
                    adj[a].add(new Node(b,c*2));
                    adj[b].add(new Node(a,c*2));
                }
            }
            ArrayList<Integer> candi = new ArrayList<Integer>();
            for(int i=0;i<t;i++) {
                int can = Integer.parseInt(br.readLine());
                candi.add(can);
            }
            dist[s] = 0;
            go();
            Collections.sort(candi);
            for(int i=0;i<candi.size();i++){
                if(dist[candi.get(i)] %2 == 1){
                    System.out.print(candi.get(i) + " ");
                }
            }
            System.out.println();
        }
    }

}