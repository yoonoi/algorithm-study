import java.util.*;

public class Hw_15652 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] result;
	static int pointer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		combine(0);
		System.out.println(sb);
	}
	
	public static void combine(int r) {
		if(r == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = pointer; i < N; i++) {
			result[r] = i + 1;
			pointer = i;
			combine(r + 1);
		}
	}
}
