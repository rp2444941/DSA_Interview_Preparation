package arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int left=0, maxLen=0;
        for (int right = 0; right <s.length() ; right++) {
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                left=Math.max(left,map.get(ch)+1);

            }
            map.put(ch,right);
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;

    }
}
