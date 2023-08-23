package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Mw_24479_ {

    static int N,M,R,idx;
    static ArrayList<Integer>[] edges;
    static int [] answer;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];
        for (int i = 1; i <=N; i++) {
            edges[i] = new ArrayList<>();
        }
        answer = new int [N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        for (int i = 1; i <= N ; i++) {
            Collections.sort(edges[i]);
        }
        visited[R] = true;
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N ; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        answer[cur] = ++idx;
        ArrayList<Integer> edge = edges[cur];
        for(int next : edge){
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }
    }
}