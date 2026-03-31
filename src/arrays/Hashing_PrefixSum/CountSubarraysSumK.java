package arrays.Hashing_PrefixSum;
import java.util.*;
public class CountSubarraysSumK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(countSubarrays(arr, k));
        System.out.println(countSubarrays1(arr, k)); // 2
    }
    public static int countSubarrays1(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // important
        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
    private static int countSubarrays(int[] arr, int k) {
        int n=arr.length;
        int count=0;
        for (int i = 0; i <n ; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
                sum+=arr[j];
                if(sum==k) count++;

            }

        }
        return count;
    }
}
