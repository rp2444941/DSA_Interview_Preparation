package arrays.level2;
import java.util.*;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(LongestSubstringOptimized(s));
    }

    public static int LongestSubstringOptimized(String s) {
        int maxLength = 0;
        int left = 0; // Window ka starting point
        HashSet<Character> set = new HashSet<>();

        // right pointer window ko aage badhayega
        for (int right = 0; right < s.length(); right++) {

            // Agar character pehle se window mein hai,
            // toh left se characters remove karo jab tak duplicate hat na jaye
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Unique character ko set mein dalo
            set.add(s.charAt(right));

            // Current window ki length check karo
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}