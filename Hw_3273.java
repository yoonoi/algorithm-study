import java.util.*;

public class Hw_3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}

		arr.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1 - o2;
			}

		});
		int x = sc.nextInt();
		int result = 0;
		int left = 0;
		int right = N - 1;
		while(left < right) {
			if(arr.get(left) + arr.get(right) == x) {
				result++;
				left++;
				right--;
				continue;
			}
			else if(arr.get(left) + arr.get(right) < x) {
				left++;
				continue;
			}
			else if(arr.get(left) + arr.get(right) > x) {
				right--;
				continue;
			}
			
		}
		System.out.println(result);
	}
}
