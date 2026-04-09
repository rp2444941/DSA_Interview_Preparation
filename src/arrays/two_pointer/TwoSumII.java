package arrays.two_pointer;
import java.util.*;
public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int target = 3;
        System.out.println(Arrays.toString(twoSum(numbers, target))); // [1,2]

        System.out.println(Arrays.toString(twoSum1(numbers, target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1}; // 1-indexed
                }
            }
        }

        return new int[]{-1, -1}; // safety
    }
    public static int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }

            map.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }
}
