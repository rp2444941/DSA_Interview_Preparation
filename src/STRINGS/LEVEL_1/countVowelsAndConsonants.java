package STRINGS.LEVEL_1;

public class countVowelsAndConsonants {
    public static void main(String[] args) {
         String s="Java17!";
        countVowelsAndConst(s);
    }
    public static void countVowelsAndConst(String s) {
        int vowels=0;
        int cons=0;
        // Note: This creates a new string in memory.
        s=s.toLowerCase();

// 2. Traverse the string from left to right
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);//Extract the character

// 3. Check if the character is an actual alphabet letter
            if(c>='a' && c<='z'){
                //4.check if it's a vowel
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    vowels++;
                }else{
                    cons++;
                }
            }


        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + cons);
    }
}
