package strings;

import java.util.Locale;

public class Anagram {

    public boolean isAnagram(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) return false;
        if(s1==null||s2==null)return false;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] letters = new int[256];
        for (char c : s1.toCharArray()) {
            letters[c]++;
        }
        for (char c : s2.toCharArray()) {
            letters[c]--;
        }
        for (int i : letters) {
            if (letters[i] != 0) return false;
        }
        return true;
    }
}
