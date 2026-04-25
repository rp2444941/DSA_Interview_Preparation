package STRINGS.LEVEL_1;

public class Palindrome {
    public static void main(String[] args) {
       String s="madam";
        System.out.println(isPalindromeOptimized(s));
    }
    public static boolean isPalindromeOptimized(String s) {
        int left = 0;
        int right = s.length() - 1; // Last valid index!

        // We only need to check until the pointers meet in the middle.
        while (left < right) {

            // Extract the characters (primitives)
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // We use == or != here because we are comparing primitive 'char' types,
            // NOT 'String' objects.
            if (leftChar != rightChar) {
                // The moment we find a mismatch, game over. It's not a palindrome.
                return false;
            }

            // If they match, move inward to check the next pair
            left++;
            right--;
        }

        // If we made it through the whole loop without returning false, it must be a palindrome!
        return true;
    }
}
