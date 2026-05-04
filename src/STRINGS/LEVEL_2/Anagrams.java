package STRINGS.LEVEL_2;
import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        // Fix: Added square brackets for array declaration and initialized the object
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Anagrams solver = new Anagrams();
        List<List<String>> result = solver.groupAnagrams(strs);

        System.out.println("Grouped Anagrams: " + result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: Key = Sorted String (Signature), Value = List of Anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // 1. Create the signature by sorting the characters
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // 2. ComputeIfAbsent is a cleaner way to initialize the list
            map.putIfAbsent(sortedWord, new ArrayList<>());

            // 3. Add the original word to the corresponding group
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}