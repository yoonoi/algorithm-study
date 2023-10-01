import java.util.Queue;
import java.util.Scanner;

public class Jh_14888 {
    static int min, max, n;
    static int[] num, operator;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        n = sc.nextInt();
        num = new int[n];
        operator = new int[4];

        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }

        for (int i=0; i<4; i++){
            operator[i]=sc.nextInt();
        }
        dfs(num[0], 0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int value, int dep) {
        if(dep == n-1){
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for(int i=0; i<4; i++){
            if(operator[i]>0){
                operator[i]--;
                dfs(operator(value, num[dep+1], i), dep+1);
                operator[i]++;
            }
        }
    }

    static int operator(int a, int b, int op){
        switch (op){
            case 0: return a+b;
            case 1: return a-b;
            case 2: return a*b;
            case 3: return a/b;
        }
        return 0;
    }
}
