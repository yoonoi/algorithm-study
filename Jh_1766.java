import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Jh_1766 {
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            indegree[b]++;
        }
        topologicalSort(indegree, list);
    }

    private static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> list) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int node = pq.poll();

            for (Integer i : list.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0)
                    pq.offer(i);
            }
            System.out.print(node + " ");
        }
    }
}
