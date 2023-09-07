package gold;

import java.util.*;
import java.util.Scanner;

public class Kh_13549 {
   static class Position {
      int l;
      int t;

      public Position(int l, int t) {
         this.l = l;
         this.t = t;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int K = sc.nextInt();

      if (N == K) {
         System.out.println(0);
         return;
      }
      Queue<Position> Q = new LinkedList<>();

      boolean[] visited = new boolean[100002];
      Q.add(new Position(N, 0));
      visited[N] = true;

      while (!Q.isEmpty()) {
         Position tmp = Q.poll();
         int tmpT = tmp.t;

         int[] next = { tmp.l - 1, tmp.l * 2, tmp.l + 1 };

         for (int i = 0; i < 3; i++) {
            int nextL = next[i];
            int nextT = tmpT + 1;
            if (i == 1) {
               nextT = tmpT;
            }

            if (nextL < 0 || nextL >= visited.length || visited[nextL]) {
               continue;
            }

            if (nextL == K) {
               System.out.println(nextT);
               return;
            }
            Q.add(new Position(nextL, nextT));
            visited[nextL] = true;

         }
      }

      sc.close();

   }
}