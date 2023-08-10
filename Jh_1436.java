import java.util.Scanner;

public class Jh_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 666;
        int cnt = 1;

        while ((cnt != n)){
            num++;
            if(String.valueOf(num).contains("666")){
                cnt++;
            }
        }
        System.out.println(num);
    }
}
