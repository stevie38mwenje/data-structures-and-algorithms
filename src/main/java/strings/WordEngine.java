package strings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class WordEngine {

    public static String reverseWords(String sentence){
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for(var i = words.length-1;i>=0;i--){
            reversed.append(words[i] + " ");
        }
        return reversed.toString().trim().toLowerCase(Locale.ROOT);
    }

    public static String reverseWord(String sentence){
        String[] words = sentence.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words).toLowerCase(Locale.ROOT);
    }


}
