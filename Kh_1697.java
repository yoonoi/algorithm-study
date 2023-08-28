import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] distance = new int[100002];
		Queue<Integer> Q = new LinkedList<>();
		
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		distance[N]++;
		
		Q.add(N);
		
		
		while(distance[K] == 0) {
			int currPoint = Q.poll();
			int[] toGo = {currPoint -1, currPoint+1, 2*currPoint };
			
			for(int next : toGo) {
				if(next<0|| next >100000) {
					continue;
				}
				if(distance[next] != 0) {
					continue;
				}
				distance[next] = distance[currPoint]+1;
				Q.add(next);
			}
			
		}
		System.out.println(distance[K]-1);
		
	}
}
