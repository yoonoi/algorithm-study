import java.util.Scanner;

public class Jh_1010 {

    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for(int t=0; t<tc; t++) {
            //서쪽
            n = sc.nextInt();
            //동쪽
            m = sc.nextInt();
            System.out.println(combi());
        }
    }

    static int combi(){
        int result =1;
        for(int i=1; i<=n; i++){
            result = result*(m-i+1)/i;
        }
        return result;
    }
}
