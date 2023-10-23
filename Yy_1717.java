package unionFind;

import java.util.Scanner;

public class Yy_1717 {
	
	static int n, m;
	static int[] parent; // 부모 노드를 저장하는 배열
	
	// 합집합으로 만드는 메서드
	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a == b) return;
		
		if(a <= b) 
			parent[b] = a;
		else
			parent[a] = b;
		
		// 왜 아래처럼 쓰면 틀리지???
//		// 이미 둘의 부모가 같으면 패스ㄱ
//		if(getParent(a) == getParent(b)) return;
//		
//		// 둘 중 작은애한테 합친다.
//		if(a <= b) {
//			parent[b] = getParent(a);
//		} else {
//			parent[a] = getParent(b);
//		}
	}
	
	// a의 부모노드를 찾는 메서드
	static int getParent(int a) {
		if(parent[a] == a)
			return a;
		
//		return getParent(parent[a]); // 이렇게만 쓰면 그냥 부모만 반환해주는거고
		return parent[a] = getParent(parent[a]); // 이렇게 쓰면 a의 부모를 찾아서 반환도해주고 바꿔도준다.
	}
	
	// a와 b가 같은 부모에게 나온 앤지 체크하는 메서드
	static boolean isUnion(int a, int b) {
		return getParent(a) == getParent(b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parent[i] = i; // 1. 본인을 부모 배열에 저장해놓는다.
		}
		
		for(int i=0; i<m; i++) {
			int calc = sc.nextInt();
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(calc == 0)
				union(a, b);
			else 
				System.out.println(isUnion(a, b) ? "YES" : "NO");
		}
	}

}
