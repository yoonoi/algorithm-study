import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_16928 {

    static int[] map, visited;
    
    static void bfs(int startIdx) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startIdx);
        visited[startIdx] = 0;
        
        while(!q.isEmpty()) {
            int pop = q.poll();
            
            for(int i=1; i<=6; i++) {
                int nextIdx = pop + i;

                if(nextIdx >= 100 || nextIdx < 0) continue;
                
                if(map[nextIdx] != -1) {
                    nextIdx = map[nextIdx]; // 무조건 인덱스 범위내일테니 확인할 필요없음
                }

                if(visited[nextIdx] != -1) continue;

                q.offer(nextIdx);
                visited[nextIdx] = visited[pop] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[100];
        visited = new int[100];
        Arrays.fill(map, -1);
        Arrays.fill(visited, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리
        int m = Integer.parseInt(st.nextToken()); // 뱀

        for(int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x-1] = y-1;
        }

        // 시작점은 1칸이니까 인덱스 0부터 시작
        bfs(0);

        System.out.println(visited[99]);
    }
}
