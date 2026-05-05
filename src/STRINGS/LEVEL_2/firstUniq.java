package STRINGS.LEVEL_2;

public class firstUniq {
    public static void main(String[] args) {
       String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
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
}
