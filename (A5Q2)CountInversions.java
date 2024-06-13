import java.util.Scanner;
public class CountInversions { 
    public static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        long invCnt = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCnt += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
        return invCnt;
    }
    public static long mergeSortAndCount(int[] arr, int left, int right) {
        long invCnt = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            invCnt += mergeSortAndCount(arr, left, mid);
            invCnt += mergeSortAndCount(arr, mid + 1, right);
            invCnt += mergeAndCount(arr, left, mid, right);
        }
        return invCnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long invCnt = mergeSortAndCount(arr, 0, n - 1);
        System.out.println("Number of inversions: " + invCnt);
        sc.close();
    }
}