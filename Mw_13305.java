package greedy;

import java.util.Scanner;

public class Mw_13305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 도시의 개수를 나타내는 정수 N
		
		long[] distance = new long[N-1]; // 각 도시 사이의 거리
		long[] price = new long[N]; // 각 도시별 기름 값의 비용
		
		long cost = 0;
		long minPrice = Integer.MAX_VALUE;
		
		for(int idx = 0; idx < N-1; idx++) {
			distance[idx] = sc.nextInt();
		}
		for(int idx = 0; idx < N; idx++) {
			price[idx] = sc.nextInt();
		}
		
		minPrice = price[0];
		cost = distance[0] * minPrice;
		
		for(int idx = 1; idx < N-1; idx++) {
			if(price[idx] < minPrice) minPrice = price[idx];
			cost += (distance[idx] * minPrice);
		}
		System.out.println(cost);
	}
}
