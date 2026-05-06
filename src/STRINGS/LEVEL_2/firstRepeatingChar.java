package STRINGS.LEVEL_2;

public class firstRepeatingChar {
    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(firstRepeatingChar1(s));
    }

        public static char firstRepeatingChar1(String s) {
            int n = s.length();

            // Outer loop: Har character ko check karne ke liye
            for (int i = 0; i < n; i++) {
                char currentChar = s.charAt(i);

                // Inner loop: Aage check karo kya yeh dobara aaya hai?
                for (int j = i + 1; j < n; j++) {
                    if (currentChar == s.charAt(j)) {
                        return currentChar; // Pehla repeating mil gaya!
                    }
                }
            }
            return '#'; // Koi repeat nahi hua
        }

}
