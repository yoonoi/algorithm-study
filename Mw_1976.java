package BOJ;

//import java.util.Arrays;
import java.util.Scanner;

public class Mw_1976 {
	
	static int getParent(int parent[], int num) {
		if(parent[num] == num) return num;
		return parent[num] = getParent(parent, parent[num]);
	}
	
	static void unionParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 도시의 수 N
		int M = sc.nextInt(); // 여행 계획에 속한 도시들의 수 M
		
		int parent[] = new int[N+1];
		for(int idx = 1; idx < N+1; idx++) {
			parent[idx] = idx;
		}
		
		int connect;
		for(int row = 1; row <= N; row++) {
			for(int col = 1; col <= N; col++) {
				connect = sc.nextInt();
				if(connect  == 1) unionParent(parent, row, col);
			}
		}
		
//		System.out.println(Arrays.toString(parent));
		
		int parentNum = parent[sc.nextInt()];
		int checkNum;
		for(int num = 1; num < M; num++) {
			checkNum = sc.nextInt();
			if(parentNum != parent[checkNum]) {
				System.out.println("NO");
				break;
			}
			if(num == M-1 && parentNum == parent[checkNum]) {
				System.out.println("YES");
			}
		}
		
	}
}
