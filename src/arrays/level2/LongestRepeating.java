package arrays.level2;

public class LongestRepeating {
    public static void main(String[] args) {
       String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
    public static int characterReplacement(String s, int k) {
        int[] charCounts = new int[26]; // A-Z ki frequency store karne ke liye
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0; // Current window mein sabse zyada aane wale character ki frequency

        for (int right = 0; right < s.length(); right++) {
            // Naye character ka count badhao
            int rightCharIndex = s.charAt(right) - 'A';
            charCounts[rightCharIndex]++;

            // Ab tak ki max frequency update karo
            maxFreq = Math.max(maxFreq, charCounts[rightCharIndex]);

            // Current window ki length
            int windowLength = right - left + 1;

            // The Golden Formula: Agar badalne wale characters 'k' se zyada hain
            if (windowLength - maxFreq > k) {
                // Window invalid hai, left se shrink karo
                int leftCharIndex = s.charAt(left) - 'A';
                charCounts[leftCharIndex]--;
                left++;
                // Note: Hum yahan maxFreq ko dobara recalculate nahi karte,
                // kyunki humein sirf "pehle se badi" maxFreq chahiye lamba answer paane ke liye.
            }

            // Max length update karo (window ab valid ho chuki hai)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
