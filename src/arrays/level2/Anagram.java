package arrays.level2;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram1(s,t));
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
    public static boolean isAnagram1(String s,String t){
        // Agar length alag hai, toh anagram nahi ho sakte
        if (s.length() != t.length()) {
            return false;
        }
        // 26 size ka array letters ka count track karne ke liye
        int[] charCounts = new int[26];

        for (int i = 0; i <s.length() ; i++) {
            //s ke character ke liye count badhao
            charCounts[s.charAt(i)-'a']++;
            //t ke character ke liye count ghatao
            charCounts[t.charAt(i)-'a']--;
        }
        // Check karo ki sab kuch cancel out hoke 0 bacha ya nahi
        for(int count:charCounts){
            if(count!=0){
                return false;// Agar koi bhi 0 nahi hai, toh anagram nahi hai
            }
        }
        return true;

    }
}
