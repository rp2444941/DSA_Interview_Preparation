package arrays.Hashing_PrefixSum;
import java.util.*;
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        System.out.println(longestConsecutive(nums)); // 4
        int[] nums1 = {2, 20, 4, 10, 3, 4, 5};
        System.out.println(longestConsecutive1(nums1)); // 4

        int[] nums2 = {0, 3, 2, 5, 4, 6, 1, 1};
        System.out.println(longestConsecutive1(nums2)); // 7
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


    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        // Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {
            // Check if this is a sequence start
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }



}
