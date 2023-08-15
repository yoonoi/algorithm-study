import java.util.Scanner;

public class Jh_24060 {
    static int k, cnt;
    static int[] arr, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        temp = new int[n];
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(0, n - 1);
        if (cnt < k) System.out.println(-1);
    }

    static void mergeSort(int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;

        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        merge(l, mid, r);
    }

    static void merge(int l, int mid, int r) {
        int start = l;
        int start2 = mid + 1;
        int t = l;

        while (start <= mid && start2 <= r) {
            if (arr[start] <= arr[start2])
                temp[t++] = arr[start++];
            else
                temp[t++] = arr[start2++];
        }
        while (start <= mid) {
            temp[t++] = arr[start++];
        }

        while (start2 <= r) {
            temp[t++] = arr[start2++];
        }

        for (int i = l; i <= r; i++) {
            cnt++;
            arr[i] = temp[i];

            if (cnt == k)
                System.out.println(temp[i]);
        }
    }
}
