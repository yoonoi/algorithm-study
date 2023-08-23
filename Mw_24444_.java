package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Mw_24444_ {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
     */
    static List<Integer>[] graph;
    static Scanner sc = new Scanner(System.in);
    static int n,m,start;

    static boolean[] visited;

    static int[] rank;
    static int rankCount =1;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }
    }

    static void solve() throws IOException {
        rank[start] = 1;
        bfs();

        for (int i = 1; i <= n; i++) {
            bw.write(rank[i]+"\n");
        }
    }

    static void bfs() throws IOException {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int nextNode = q.poll();
            rank[nextNode] = rankCount;
            rankCount++;

            for (int nearNode : graph[nextNode]) {
                if (!visited[nearNode]) {
                    q.add(nearNode);
                    visited[nearNode] = true; //이미 큐에 들어있는 노드를 다른노드의 인접노드를 살펴보다가 또 넣을수있으므로 큐에있는건 일단 방문처리한다.
                }
            }

        }

    }

}