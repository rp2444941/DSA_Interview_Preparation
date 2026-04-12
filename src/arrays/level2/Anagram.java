package arrays.level2;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        // Agar length alag hai, toh anagram nahi ho sakte
        if(s.length()!=t.length()){
            return false;
        }
        // String ko character array mein badlo taaki sort kar sakein
        char[] sChars=s.toCharArray();
        char[] tChar=t.toCharArray();
         // Dono arrays ko sort kardo
        Arrays.sort(sChars);
        Arrays.sort(tChar);
        // Compare karo ki dono same hain ya nahi
        return Arrays.equals(sChars,tChar);

    }
}
