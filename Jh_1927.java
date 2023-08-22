import java.util.PriorityQueue;
import java.util.Scanner;

public class Jh_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else System.out.println(0);
                continue;
            }
            q.add(x);
        }
    }
}
