package STRINGS.LEVEL_1;

public class reverseString {
    public static void main(String[] args) {
        String s = "HELLO";
        System.out.println(reverseBruteForce(s));
        System.out.println(reverseOptimized(s));
    }
    public static String reverseBruteForce(String s) {
        // We use StringBuilder because appending in a loop to a standard String
        // is very slow (creates a new object every time).
        StringBuilder reversed = new StringBuilder();

        // Start at the last index: s.length() - 1
        // Stop after we process the first index: 0
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }

        return reversed.toString();
    }
    public static String reverseOptimized(String s) {
        // 1. Convert to a mutable character array
        char[] chars = s.toCharArray();

        // 2. Initialize Two Pointers
        int left = 0;                  // Points to the start
        int right = chars.length - 1;  // Points to the end

        // 3. Move pointers towards the middle
        while (left < right) {
            // Swap logic
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move pointers
            left++;
            right--;
        }

        // 4. Convert back to String
        return new String(chars);
    }
}
