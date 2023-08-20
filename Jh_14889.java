import java.util.Scanner;

public class Jh_14889 {

    static int n, min;
    static int[][] map;
    static boolean[] selected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        selected = new boolean[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        min = Integer.MAX_VALUE;
        combi(0,0);
        System.out.println(min);
    }

    //조합
    static void combi(int cnt, int k){
        if(cnt == n/2) {
            diff();
            return;
        }

        for(int i=k; i<n; i++) {
            if(!selected[i]) {
                selected[i] = true;
                combi(cnt+1,i + 1);
                selected[i] = false;
            }
        }
    }

    static void diff(){
        int start = 0;
        int link = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(selected[i]==true&&selected[j]==true){
                    start+=map[i][j]+map[j][i];
                }else if(selected[i]==false&&selected[j]==false){
                    link+=map[i][j]+map[j][i];
                }
            }
        }
        int gap = Math.abs(start-link);
        min=Math.min(gap, min);
    }
}
