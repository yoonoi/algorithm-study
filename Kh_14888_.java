package silver;

import java.util.Scanner;

public class Kh_14888 {
	static int max = Integer.MAX_VALUE;
	static int min = Integer.MIN_VALUE;
	static int[] operator = new int[4];
	static int[] numbers;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		numbers = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			numbers[i] = sc.nextInt();
 		}
		
		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}
 
		dfs(numbers[0], 1);
 
		System.out.println(max);
		System.out.println(min);
 
		
	}
	public static void dfs(int num, int idx) {
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
 
				operator[i]--;
 
				switch (i) {
 
				case 0:	dfs(num + numbers[idx], idx + 1);	break;
				case 1:	dfs(num - numbers[idx], idx + 1);	break;
				case 2:	dfs(num * numbers[idx], idx + 1);	break;
				case 3:	dfs(num / numbers[idx], idx + 1);	break;
 
				}
				operator[i]++;
			}
		}
	}

}
