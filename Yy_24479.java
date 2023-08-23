import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Yy_24479 {

    static int n, m, start; // 정점, 간선, 시작점
    static boolean[] visited;
    static List<List<Integer>> list; // 연결리스트

    static void dfs(int start) {
        visited[start] = true; // 방문 표시

        for(int x : ) {
            if(!visited[x]) dfs(x);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new ArrayList<>());
            list.get(i).add(u);
            list.get(i).add(v);

        }



    }
}
