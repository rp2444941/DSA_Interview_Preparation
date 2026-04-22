package arrays.two_pointer;
import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Input: [3,2,3]");
        System.out.println("Output: " + majorityElement(nums1)); // Expected: [3]

        // Test case 2
        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Input: [1,1,1,3,3,2,2,2]");
        System.out.println("Output: " + majorityElement(nums2)); // Expected: [1,2]

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("Input: [1,2,3,4]");
        System.out.println("Output: " + majorityElement(nums3)); // Expected: []
    }
    /**
     * Majority Element II
     * Find all elements that appear more than ⌊ n/3 ⌋ times in an integer array.
     * Time: O(n), Space: O(1)
     */public static List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<>();

            if (nums == null || nums.length == 0) {
                return result;
            }

            // Step 1: Find potential candidates (at most two)
            int candidate1 = 0, candidate2 = 0;
            int count1 = 0, count2 = 0;

            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }

            // Step 2: Verify the candidates
            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                }
            }

            int threshold = nums.length / 3;
            if (count1 > threshold) {
                result.add(candidate1);
            }
            if (count2 > threshold) {
                result.add(candidate2);
            }

            return result;
        }


}
