package arrays.two_pointer;
import java.util.*;
public class LargestSubarraySum0 {
    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {2, 4, -2, 1, -3, 5, -3};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {0, 0, 0};
        int[] arr4 = {-1, 1, -1, 1, -1, 1};
        int[] arr5 = {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println("Array 1: " + java.util.Arrays.toString(arr1));
        System.out.println("Length of longest subarray with sum 0: " + maxLen(arr1));
        printLongestZeroSumSubarray(arr1);
        System.out.println();

        System.out.println("Array 2: " + java.util.Arrays.toString(arr2));
        System.out.println("Length: " + maxLen(arr2));
        printLongestZeroSumSubarray(arr2);
        System.out.println();

        System.out.println("Array 3: " + java.util.Arrays.toString(arr3));
        System.out.println("Length: " + maxLen(arr3));
        printLongestZeroSumSubarray(arr3);
        System.out.println();

        System.out.println("Array 4: " + java.util.Arrays.toString(arr4));
        System.out.println("Length: " + maxLen(arr4));
        printLongestZeroSumSubarray(arr4);
        System.out.println();

        System.out.println("Array 5: " + java.util.Arrays.toString(arr5));
        System.out.println("Length: " + maxLen(arr5));
        printLongestZeroSumSubarray(arr5);
    }

    /**
     * Returns the length of the longest contiguous subarray whose sum is zero.
     * If no such subarray exists, returns 0.
     *
     * @param arr input array of integers (can contain positive, negative, zero)
     * @return length of the longest zero-sum subarray
     */
    public static int maxLen(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        // Initialize for subarray starting from index 0
        sumToIndex.put(0, -1);  // sum 0 seen before index 0 (virtual)

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the same cumulative sum was seen before, the subarray between
            // that previous index+1 and current index has sum 0
            if (sumToIndex.containsKey(sum)) {
                int prevIndex = sumToIndex.get(sum);
                int length = i - prevIndex;
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                // Store first occurrence of this cumulative sum
                sumToIndex.put(sum, i);
            }
        }

        return maxLength;
    }

    // Optional: print the actual subarray (first longest found)
    public static void printLongestZeroSumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int startIdx = -1, endIdx = -1;
        sumToIndex.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumToIndex.containsKey(sum)) {
                int prev = sumToIndex.get(sum);
                int length = i - prev;
                if (length > maxLength) {
                    maxLength = length;
                    startIdx = prev + 1;
                    endIdx = i;
                }
            } else {
                sumToIndex.put(sum, i);
            }
        }

        if (maxLength == 0) {
            System.out.println("No zero-sum subarray found.");
        } else {
            System.out.print("Longest zero-sum subarray (length " + maxLength + "): [");
            for (int i = startIdx; i <= endIdx; i++) {
                System.out.print(arr[i] + (i < endIdx ? ", " : ""));
            }
            System.out.println("]");
        }
    }

}
