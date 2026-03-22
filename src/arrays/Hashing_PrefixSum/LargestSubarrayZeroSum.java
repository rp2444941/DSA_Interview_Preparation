package arrays.Hashing_PrefixSum;
import java.util.*;

public class LargestSubarrayZeroSum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr)); // 5
        System.out.println(LongestLen(arr));
        System.out.println(largestSubarrayZero(arr));
    }

    private static int maxLen(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
    public static int LongestLen(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int maxLen = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];

                if (sum == 0) {
                    maxLen = i + 1;
                }

                if (map.containsKey(sum)) {
                    int prevIndex = map.get(sum);
                    int len = i - prevIndex;
                    maxLen = Math.max(maxLen, len);
                } else {
                    map.put(sum, i); // first occurrence only
                }
            }

            return maxLen;
    }
    public static int largestSubarrayZero(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // important trick
        int sum=0;
        int maxLen=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            if(map.containsKey(sum)){
                maxLen=Math.max(maxLen,i-map.get(sum));
            }else{
                map.put(sum,i);
            }

        }

return maxLen;
    }
}
