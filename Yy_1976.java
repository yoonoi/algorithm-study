package unionFind;

import java.util.Scanner;

public class Yy_1976 {
	
	static int n, m;
	static int[] parent;
	
	static int getParent(int a) {
		if(parent[a] == a)
			return a;
		
		return parent[a] = getParent(parent[a]);
	}
	
	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a == b) return;
		
		if(a <= b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	static boolean isUnion(int a, int b) {
		return getParent(a) == getParent(b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt(); // 여행 계획에 속한 도시의 수
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int input = sc.nextInt();
				
				if(input == 1) 
					union(i, j);
			}
		}
		
		int parent = 0;
		boolean isUnion = true;
		for(int i=0; i<m; i++) {
			int plan = sc.nextInt();
			
			int plansParent = getParent(plan);
			if(parent == 0)
				parent = plansParent;
			
			if(isUnion(parent, plansParent)) continue;
			else {
				isUnion = false;
				break;
			}
		}
		
		System.out.println(isUnion ? "YES" : "NO");
	}

}
