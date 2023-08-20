import java.util.Scanner;

public class Jh_15650 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visited = new boolean[n];

        combi(0,0);
    }

    static void combi(int cnt, int k){
        if(cnt == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=k; i<n; i++) {
            if(!visited[i]) {
                arr[cnt] = i + 1;
                visited[i] = true;
                combi(cnt+1,i + 1);
                visited[i] = false;
            }
        }
    }
}
