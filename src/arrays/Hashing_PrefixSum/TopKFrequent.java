package arrays.Hashing_PrefixSum;
import java.util.*;
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

        System.out.println(Arrays.toString(topKFrequent1(nums, k)));
    }
    //method 1
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: frequency count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        // Step 2: find max frequency k times
        for (int i = 0; i < k; i++) {
            int maxFreq = Integer.MIN_VALUE;
            int maxElement = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxElement = entry.getKey();
                }
            }

            result[i] = maxElement;
            map.remove(maxElement);
        }

        return result;
    }
    //method 2

    public static int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> elements = new ArrayList<>(freqMap.keySet());

        elements.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = elements.get(i);
        }

        return result;
    }


}
