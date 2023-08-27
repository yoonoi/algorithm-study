import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jh_1697 {
    private static int answer;
    private static boolean[] map = new boolean[200001];
    private static int[] cnt = new int[200001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        bfs(N, K);

        System.out.println(answer);
    }

    private static void bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        map[N] = true;
        while (!q.isEmpty()) {
            int location = q.poll();

            if (location - 1 >= 0) {
                if (!map[location - 1]) {
                    q.add(location - 1);
                    map[location - 1] = true;
                    cnt[location - 1] = cnt[location] + 1;
                }
            }

            if (location + 1 < 200000) {
                if (!map[location + 1]) {
                    q.add(location + 1);
                    map[location + 1] = true;
                    cnt[location + 1] = cnt[location] + 1;
                }
            }

            if (location * 2 < 200000) {
                if (!map[location * 2]) {
                    q.add(location * 2);
                    map[location * 2] = true;
                    cnt[location * 2] = cnt[location] + 1;
                }
            }

        }
        answer = cnt[K];

    }
}
