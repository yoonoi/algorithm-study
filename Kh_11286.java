import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kh_11286 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) < Math.abs(o2)) {
					return -1;
				}else if(Math.abs(o1) == Math.abs(o2)) {
					if(o1 < o2) {
						return -1;
					}else if(o1 > o2) {
						return 1;
					}
				}else if(Math.abs(o1) > Math.abs(o2)) {
					return 1;
				}
				return 0;
			}
		
		});
		
		int N = sc.nextInt();
		
		for(int i = 0 ; i < N ; i++) {
			int a = sc.nextInt();
			
			if(a ==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(a);
			}
		}		
	}
}
