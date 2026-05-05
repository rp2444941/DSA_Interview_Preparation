package STRINGS.LEVEL_2;

public class firstUniq {
    public static void main(String[] args) {
       String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar1(s));
    }
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    isUnique = false; // Duplicate mil gaya
                    break;
                }
            }
            if (isUnique) {
                return i; // Pehla unique mil gaya
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        // 26 alphabets ke liye frequency array
        int[] count = new int[26];

        // Pass 1: Har character ki frequency calculate karo
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 'a' ka ASCII minus karke index 0-25 me map karte hain
            count[c - 'a']++;
        }

        // Pass 2: String ke shuru se check karo kiska count 1 hai
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                return i; // Pehla unique character mil gaya
            }
        }

        // Agar loop poora chal gaya aur return nahi hua, matlab koi unique nahi hai
        return -1;
    }
}
