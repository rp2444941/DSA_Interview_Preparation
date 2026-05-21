package arrays.level2;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        // Pointers set karo
        int left = 0;
        int right = s.length() - 1;

        // Jab tak Left, Right ko cross nahi karta
        while (left < right) {

            // Agar dono characters alag hain
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Turant bata do ki Palindrome NAHI hai
            }

            // Agar match kar gaye, toh pointers ko andar ki taraf khiskao
            left++;
            right--;
        }

        // Agar poora loop chal gaya aur koi mismatch nahi mila
        return true; // Iska matlab yeh Palindrome HAI!
    }

    public static void main(String[] args) {
        String word1 = "RADAR";
        String word2 = "HELLO";

        System.out.println(word1 + " is Palindrome? " + isPalindrome(word1)); // Output: true
        System.out.println(word2 + " is Palindrome? " + isPalindrome(word2)); // Output: false
    }
}
