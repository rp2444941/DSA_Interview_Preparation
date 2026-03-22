package arrays.Hashing_PrefixSum;

import java.util.Arrays;

public class PrefixSumExample {
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        //in-place prefix sum
        int[] arrCopy=arr.clone();
        prefixSumInPlace(arrCopy);
        System.out.println(Arrays.toString(arrCopy));

        // Long prefix sum
        long[] prefix=prefixSumArrayLong(arr);
        System.out.println(Arrays.toString(prefix));
        // Range queries
        System.out.println(rangeSum(prefix, 1, 3)); // 18
        System.out.println(rangeSum(prefix, 0, 2)); // 12
        System.out.println(rangeSum(prefix, 2, 4)); // 24

        //prefixSumArray
        System.out.println(Arrays.toString(prefixSumArray(arr)));
    }
    public static long rangeSum(long[] prefix, int left, int right) {
        if(left==0) return prefix[right];
        return prefix[right]-prefix[left-1];
    }
    private static long[] prefixSumArrayLong(int[] arr) {
        int n= arr.length;
        if(n==0) return new long[0];
        long[] prefix=new long[n];
        prefix[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            prefix[i]=prefix[i-1]+arr[i];

        }
        return prefix;
    }

    private static void prefixSumInPlace(int[] arr) {
        for (int i = 1; i <arr.length; i++) {
            arr[i]=arr[i-1]+arr[i];

        }
    }
    public static int[] prefixSumArray(int[] arr) {
        int n= arr.length;
        if(n==0) return new int[0];
        int[] prefix=new int[n];
        prefix[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            prefix[i]=prefix[i-1]+arr[i];

        }
        return prefix;
    }
}
