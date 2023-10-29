import java.util.Scanner;

//부모노드를 갱신하자.
public class Jh_1717  {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n + 1];
        // 값 초기화 자기 자신이 부모.
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int check = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int p1= find(a);
            int p2= find(b);

            if(check==0 &&p1!=p2) union(p1,p2);
            else if(check==1&&p1!=p2) System.out.println("NO");
            else if(check==1&&p1==p2) System.out.println("YES");
        }
    }

    static void union(int a, int b) {
        // 합칠게 없으니 리턴
        parent[a]=b;
    }

    static int find(int a) {
        if(parent[a]==a) return a;
        else return parent[a]=find(parent[a]);
    }
}
