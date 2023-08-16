import java.util.Scanner;

public class Jh_15649 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visited = new boolean[n];

        permutation(0);
    }

    static void permutation(int cnt){
        if(cnt == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                arr[cnt] = i + 1;
                visited[i] = true;
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }
}
