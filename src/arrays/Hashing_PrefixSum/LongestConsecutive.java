package arrays.Hashing_PrefixSum;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        System.out.println(longestConsecutive(nums)); // 4
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int maxLength = 1;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int length = 1;

            // Check for num+1, num+2, ...
            while (contains(nums, current + 1)) {
                current++;
                length++;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    private static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }


}
