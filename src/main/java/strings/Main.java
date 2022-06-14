package strings;

//import static strings.RepeatingCharacters.nonRepeating;
import static strings.WordEngine.reverseWord;

public class Main {
    public static void main(String[] args) {
        RepeatingCharacters finder = new RepeatingCharacters();
//        Reverse reverse = new Reverse();
//        System.out.println(reverseWord("hello JAMBO Kenya"));


//        var result1 = finder.nonRepeatingChar("a green apple green");
//        System.out.println(result1);
//
        var result = finder.nonRepeatingWord("a green apple green");
        System.out.println(result);
//
//        var result2 = finder.findFirstRepeating("a green apple green");
//        System.out.println(result2);
//
//        var res = reverse.reverseWord("jambo");




    }
}
