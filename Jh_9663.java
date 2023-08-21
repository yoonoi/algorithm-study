import java.util.Scanner;

public class Jh_9663 {

    static int n, cnt;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        cnt=0;
            queen(0);
        System.out.println(cnt);
    }

    static void queen(int dep){
        if(dep==n){
            cnt++;
            return;
        }

        for(int i=0; i<n; i++){
            arr[dep]=i;
            if(ispossible(dep)){
                queen(dep+1);
            }
        }
    }

    static boolean ispossible(int row){
        for(int i=0; i<row; i++){
            if (arr[row]==arr[i])
                return false;

            else if(Math.abs(arr[row]-arr[i])==Math.abs(row-i))
                return false;
        }
        return true;
    }
}
