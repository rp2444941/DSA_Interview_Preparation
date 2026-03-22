package arrays.Hashing_PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(arr, k)); // 2
        System.out.println(sum(arr,k));

    }

    private static int subarraySum(int[] arr, int k) {
        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            int sum=0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(sum==k){
                   count++;
                }

            }

        }
        return count;

    }
    public static int sum(int[] arr, int k){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);//important

        int sum=0;
        int count=0;
        for(int num:arr){
            sum+=num;
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
