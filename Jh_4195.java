import java.util.Scanner;
import java.util.HashMap;

public class Jh_4195 {

    static int[] parent, rank;

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (rank[x] < rank[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
            return rank[x];
        }
        return rank[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int f = sc.nextInt();
            parent = new int[f * 2];
            rank = new int[f * 2];

            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

            int cnt = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < f; i++) {
                String friend1 = sc.next();
                String friend2 = sc.next();

                if (!map.containsKey(friend1)) {
                    map.put(friend1, cnt++);
                }

                if (!map.containsKey(friend2)) {
                    map.put(friend2, cnt++);
                }

                System.out.println(union(map.get(friend1), map.get(friend2)));
            }
        }
        sc.close();
    }
}
