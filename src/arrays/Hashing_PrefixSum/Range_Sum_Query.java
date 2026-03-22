package arrays.Hashing_PrefixSum;
import java.util.*;
public class Range_Sum_Query {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};

        int[] prefix = buildPrefix1Based(arr);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Prefix Array: " + Arrays.toString(prefix));

        System.out.println("Sum from index 1 to 3: " + rangeSum(prefix, 1, 3)); // 18
        System.out.println("Sum from index 0 to 2: " + rangeSum(prefix, 0, 2)); // 12
        System.out.println("Sum from index 2 to 4: " + rangeSum(prefix, 2, 4)); // 24
    }
    public static int[] buildPrefix1Based(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        return prefix;
    }

    public static int rangeSum(int[] prefix, int l, int r) {
        return prefix[r + 1] - prefix[l];
    }
}
