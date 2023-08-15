import java.util.Scanner;

public class Jh_11729 {
    static int cnt;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int n = sc.nextInt();
        hanoi(n,1,3,2);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void hanoi(int n, int l, int r, int mid){
        if(n==1){
            cnt++;
            sb.append(l).append(" ").append(r).append("\n");
            return;
        }else {
            hanoi(n-1, l, mid, r);
            cnt++;
            sb.append(l).append(" ").append(r).append("\n");
            hanoi(n-1,mid,r,l);
        }
    }
}
