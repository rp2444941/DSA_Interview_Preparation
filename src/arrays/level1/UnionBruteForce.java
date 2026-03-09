package arrays.level1;

import java.util.ArrayList;
import java.util.List;

public class UnionBruteForce {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {3, 4};

        List<Integer> union = unionBrute(arr1, arr2);

        System.out.println("Union (Brute Force): " + union);
    }
    public static List<Integer> unionBrute(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();

        // Process first array
        for (int value : arr1) {
            if (!contains(result, value)) { // agar result me nahi hai
                result.add(value);
            }
        }

        // Process second array
        for (int value : arr2) {
            if (!contains(result, value)) {
                result.add(value);
            }
        }

        return result;
    }

    // Linear search helper: list me value hai ya nahi
    private static boolean contains(List<Integer> list, int target) {
        for (int x : list) {
            if (x == target) return true;
        }
        return false;
    }
}