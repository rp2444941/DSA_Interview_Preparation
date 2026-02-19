import java.util.*;

public class Solution{

    static int largestBrute(int[] arr) {
        int n = arr.length;
        if (n == 0) throw new IllegalArgumentException("Array empty hai");

        for (int i = 0; i < n; i++) {
            boolean isMax = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isMax = false;
                    break;
                }
            }
            if (isMax) return arr[i];
        }
        return Integer.MIN_VALUE;
    }

    static int largestSorting(int[] arr) {
        int n = arr.length;
        if (n == 0) throw new IllegalArgumentException("Array empty hai");

        int[] copy = arr.clone();
        Arrays.sort(copy);
        return copy[n - 1];
    }

    static int largestOptimal(int[] arr) {
        int n = arr.length;
        if (n == 0) throw new IllegalArgumentException("Array empty hai");

        int maxi = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxi) maxi = arr[i];
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(largestBrute(arr));
        System.out.println(largestSorting(arr));
        System.out.println(largestOptimal(arr));
    }
}