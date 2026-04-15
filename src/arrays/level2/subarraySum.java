package arrays.level2;

import java.util.HashMap;

public class subarraySum {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        System.out.println(subarraySum1(nums,k));
        System.out.println(subarraySum2(nums,3));
    }
    public static int subarraySum1(int[] nums, int k) {
        int count=0;
        // outer loop:Subarray yahan se shuru hogi
        for (int i = 0; i <nums.length ; i++) {
            int sum=0;
            for (int j = i; j < nums.length ; j++) {
                sum+=nums[j];//sum me element add krte jao
                // agar sum k ke aqual mil jaye toh count badha do
                if(sum==k){
                    count++;
                }

            }

        }
        return count;
    }
    public static int subarraySum2(int[] nums, int k) {
        int count=0;
        int runningSum=0;
        //hashmap:<prefix Sum,Frequency>
        HashMap<Integer,Integer> map=new HashMap<>();
        // base case:0 sum ek bar  aa chuka hai(empty subaaray ka sum hai)
        map.put(0,1);
        for (int i = 0; i <nums.length ; i++) {
            //1. Current sum calculate karo
            runningSum+=nums[i];
            //2. check kro kya(runningsum-k) history me exist krta hai
            int removeSum=runningSum-k;
            if(map.containsKey(removeSum)){
                count+=map.get(removeSum);
            }
            //3. current runningsum ko map me add/ update karo future ke liye
            map.put(runningSum,map.getOrDefault(runningSum,0));

        }
        return count;
    }

}
