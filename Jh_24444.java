import java.util.*;

public class Jh_24444 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean visited[];
    static int result[];
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int start = sc.nextInt();

        result = new int[m+1];

        for(int i=0; i<=m; i++) list.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1; i<=m; i++){
            var pos = list.get(i);
            Collections.sort(pos);
        }


        bfs(start, m);

        for(int i=1; i<=m; i++)
            System.out.println(result[i]);
    }

    public static void bfs(int start, int m){
        int cnt = 1;
        visited = new boolean[m+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        result[start] = cnt++;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int num : list.get(cur)){
                if(!visited[num]){
                    queue.add(num);
                    visited[num] = true;
                    result[num] = cnt++;
                }
            }
        }
    }
}
