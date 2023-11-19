package greedy;
import java.util.Arrays;
import java.util.Scanner;

public class Mw_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 사람의 수 N
		
		int[] time = new int[N];
		int sum = 0;
		
		for(int idx = 0; idx < N; idx++) {
			time[idx] = sc.nextInt();
		}
		
		Arrays.sort(time);
		
		for(int idx = 0; idx < N; idx++) {
			sum += time[idx] * (N-idx);
		}
		
		System.out.println(sum);
	}
}
