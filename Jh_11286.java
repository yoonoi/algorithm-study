import java.util.PriorityQueue;
import java.util.Scanner;

public class Jh_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> {

            int absX = Math.abs(x);
            int absY = Math.abs(y);

            if (absX == absY) {
                if (x <= y) return -1; //x가 우선순위
                else return 1; //y가 우선순위
            } else if (absX < absY) {
                return -1;
            } else return 1;
        });

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else System.out.println(0);
                continue;
            }
            q.add(num);
        }
    }
}
