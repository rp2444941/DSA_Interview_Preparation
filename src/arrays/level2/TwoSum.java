package arrays.level2;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(num, target)));

    }
    public static int[] twoSum(int[] num, int target) {
        int n = num.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (num[i] + num[j] == target) {
                    return new int[]{i, j}; // i always smaller than j
                }
            }
        }

        return new int[]{-1, -1}; // just for safety
    }
}
