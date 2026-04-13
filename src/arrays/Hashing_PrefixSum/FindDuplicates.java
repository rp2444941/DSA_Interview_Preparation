package arrays.Hashing_PrefixSum;
import java.util.*;
public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));

    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[i]==nums[j] && !duplicates.contains(nums[i])){
                    duplicates.add(nums[i]);
                }

            }

        }
        return duplicates;
    }
}
