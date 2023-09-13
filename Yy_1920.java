import java.util.Arrays;
import java.util.Scanner;

public class Yy_1920 {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr); // 이분탐색은 정렬을 한 후 사용해야함

        int m = sc.nextInt();
        for(int i=0; i<m; i++) {
            int key = sc.nextInt();

            binarySearch(key, 0, n-1);
        }
    }

    public static void binarySearch(int key, int start, int end) {

        if(start > end) {
            System.out.println(0);
            return;
        }

        int mid = (start + end) / 2;

        if(arr[mid] == key) {
            System.out.println(1);
            return;
        }

        if(key < arr[mid]){
            binarySearch(key, start, mid - 1); // 그냥 mid 했더니 메모리초과남
        } else {
            binarySearch(key, mid + 1, end);
        }
    }

}
