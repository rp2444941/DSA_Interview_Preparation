package arrays.level2;

public class subarraySum {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        System.out.println(subarraySum1(nums,k));
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

}
