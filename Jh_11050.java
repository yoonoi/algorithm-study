import java.util.Scanner;

public class Jh_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result =1;
        for(int i=1; i<=m; i++){
            result = result *(n-i+1)/i;
        }
        System.out.println(result);
    }
}
