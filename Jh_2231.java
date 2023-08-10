import java.util.Scanner;

public class Jh_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = find(num);
        System.out.println(result);
    }
    static int find (int num){
        for (int i = 1; i < num; i++) {
            int sum = i + div(i);
            if (sum == num) {
                return i;
            }
        }
        return 0;
    }

    static int div (int num){
        int sum = 0;
        while (num !=0){
            sum+=num%10;
            num /=10;
        }
        return sum;
    }
}
