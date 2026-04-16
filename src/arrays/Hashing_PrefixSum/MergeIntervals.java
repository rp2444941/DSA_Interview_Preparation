package arrays.Hashing_PrefixSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.toString(merge(intervals)));


    }
    public static int[][] merge(int[][] intervals) {
            // Agar array khali hai ya 1 hi element hai
            if (intervals.length <= 1) {
                return intervals;
            }

            // Step 1: Intervals ko unke 'start' time ke aadhar par sort karo
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            List<int[]> merged = new ArrayList<>();

            // Pehle interval ko current_interval maan lo
            int[] current_interval = intervals[0];
            merged.add(current_interval); // Ise list me daal do (hum iski values update karte rahenge)

            // Step 2: Baaki intervals ko scan karo
            for (int i = 1; i < intervals.length; i++) {
                int current_end = current_interval[1];

                int next_start = intervals[i][0];
                int next_end = intervals[i][1];

                // Kya naya interval purane ke saath overlap kar raha hai?
                if (next_start <= current_end) {
                    // Haan! Toh end time ko update karo (Merge them)
                    current_interval[1] = Math.max(current_end, next_end);
                } else {
                    // Nahi! Toh is naye interval ko current_interval bana lo aur list me daal do
                    current_interval = intervals[i];
                    merged.add(current_interval);
                }
            }

            // List<int[]> ko wapas int[][] array mein convert karke return karo
            return merged.toArray(new int[merged.size()][]);
        }
    }

