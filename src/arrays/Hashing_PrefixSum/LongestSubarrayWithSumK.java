package arrays.Hashing_PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longestSubarray(arr, k)); // 4
        System.out.println(Longest(arr,k));
    }
    public static int Longest(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,maxLen=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            if(sum==k){
                maxLen=i+1;
            }
            if(map.containsKey(sum-k)){
                maxLen=Math.max(maxLen,i-map.get(sum-k));
            }
            // store first occurence only
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }

        }
        return maxLen;
    }

    private static int longestSubarray(int[] arr, int k) {
        int n=arr.length;
        int maxLen=0;
        for (int i = 0; i <n ; i++) {
            int sum=0;
            for (int j = i; j <n ; j++) {
                sum+=arr[j];
                if(sum==k){
                    maxLen=Math.max(maxLen,j-i+1);
                }

            }

        }
        return maxLen;
    }
}
