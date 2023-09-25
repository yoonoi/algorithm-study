package BOJ;

import java.io.*;
import java.util.*;

public class Mw_2252_ {
    static int N, M;
    static Node[] adjList;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new Node[N + 1];
        indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start] = new Node(end, adjList[start]);
            indegree[end]++;        // end를 가리키는 노드의 수를 1개 증가시킨다.
        }
        bfs();
        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)        // indegree가 0인 정점을 queue에 넣는다.
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();    // 더이상 자신을 가리키는 노드가 없는 노드만 queue에 존재한다.

            sb.append(cur).append(" ");        // 그러므로 바로 출력

            for(Node temp = adjList[cur]; temp != null ; temp = temp.link){        // 연결된 노드를 탐색한다.
                if(--indegree[temp.vertex] == 0)    // 1만큼 감소시키고 0이되었다면 queue에 넣는다.
                    queue.offer(temp.vertex);
            }
        }
    }
}