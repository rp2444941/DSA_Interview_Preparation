package arrays.Hashing_PrefixSum;
import java.util.*;
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

        System.out.println(Arrays.toString(topKFrequent1(nums, k)));
        System.out.println(Arrays.toString(topKFrequent2(nums, k)));
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
    //method 3 hashing
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap based on frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        // Step 3: Keep only top k frequent elements
        for (int num : freqMap.keySet()) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Build result
        int[] result = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }


}
