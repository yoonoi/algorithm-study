import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Hw_2230_ {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
 
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        // 투 포인터 알고리즘
        while (i < N) {
            if (arr[i] - arr[j] < M) {
                i++;
                continue;
            }
 
            if (arr[i] - arr[j] == M) {
                ans = M;
                break;
            }
 
            ans = Math.min(ans, arr[i] - arr[j]);
            j++;
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
