package BOJ;

import java.util.Scanner;

public class Mw_1717 {
	// 부모 노드를 찾는 함수
	static int getParent(int[] parent, int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	
	// 두 부모 노드를 합치는 함수
	static void unionParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	// 부모 노드가 같은지 확인하는 함수
	static String findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a == b) return "YES"; // 부모 노드가 같다면 YES를
		return "NO"; // 아니라면 NO를 리턴하자
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] parent = new int[n+1];
		
		for(int idx = 0; idx <= n; idx++) {
			parent[idx] = idx;
		}
		
		int x,y,z;
		
		for(int idx = 0; idx < m; idx++) {
			x = sc.nextInt();
			y = sc.nextInt();
			z = sc.nextInt();
			
			if(x == 0) unionParent(parent, y, z);
			else System.out.println(findParent(parent, y, z));
		}
	}
}
