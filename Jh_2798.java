import java.util.Scanner;

public class Jh_2798 {

    static int N, M, max;
    static int[] card;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        max=0;

        card = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            card[i] = sc.nextInt();
        }

        combi(0,0,0);
        System.out.println(max);
    }

    static void combi(int cnt, int idx, int sum){
        if(cnt ==3){
            if(sum<=M){
                max = Math.max(sum, max);
            }
            return;
        }

        for(int i=idx; i<N;i++){
            sum+=card[i];
            combi(cnt+1, i+1, sum);
            sum-=card[i];
        }
    }
}
