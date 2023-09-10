import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Yj_13549 {
    static int N; // 수빈이 위치
    static int K; // 동생 위치
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{N, 0});
        boolean[] visited = new boolean[100_001];

        int count = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nPosition = now[0];
            count = now[1];

            if (nPosition == K) {
                break;
            }

            visited[nPosition] = true;
            if (nPosition * 2 <= 100_000 && !visited[nPosition * 2]) {
                pq.offer(new int[] {nPosition * 2, count});
            }

            if (nPosition < K && nPosition + 1 <= 100_000 && !visited[nPosition + 1]) {
                pq.offer(new int[] {nPosition + 1, count + 1});
            }

            if (nPosition - 1 >= 0  && !visited[nPosition - 1]) {
                pq.offer(new int[] {nPosition - 1, count + 1});
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
