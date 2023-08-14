import java.util.Scanner;

public class Jh_10870 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int amswer = fibo(n);
        System.out.println(amswer);
    }

    public static int fibo(int n) {
        if(n == 1) {
            return 1;
        }else if(n == 0) {
            return 0;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
