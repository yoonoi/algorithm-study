package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Mw_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int idx = 0; idx < n; idx++) {
            arr[idx] = sc.nextInt();
        }
        
        int x = sc.nextInt();
        Arrays.sort(arr);
        
        int cnt = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == x) {
                cnt++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(cnt);
    }
}
