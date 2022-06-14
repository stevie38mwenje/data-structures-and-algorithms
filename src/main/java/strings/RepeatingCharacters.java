package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatingCharacters {
   public static String nonRepeatingWord(String sentense){
       Map<String, Integer> map = new HashMap<>();
       String [] word = sentense.split(" ");
//       System.out.println(word.toString());
       //var chars = sentense.toCharArray();
       for(var ch: word){
           if(map.containsKey(ch)){
               var count = map.get(ch);
               map.put(ch,count+1);

           }
           else
               map.put(ch,1);



//           var count = map.containsKey(ch)?map.get(ch):0;
//           map.put(ch,count+1);
       }
       System.out.println(map);
       for(var ch:word){
           if(map.get(ch)==1){
               return ch;
           }

       }
       return null;
   }

   public static char nonRepeatingChar(String sentense){
       Map<Character,Integer> map = new HashMap<>();
       var chars = sentense.toCharArray();
       for(var ch:chars){
           if(map.containsKey(ch)){
               var count = map.get(ch);
               map.put(ch,count+1);
           }
           else
               map.put(ch,1);
       }
       //System.out.println(map);
       for(var ch:chars){
           if(map.get(ch)==1){
               return ch;
           }
       }
       return Character.MIN_VALUE;

   }

   public static char findFirstRepeating(String sentense){
       Set<Character> set = new HashSet<>();
       var chars = sentense.toCharArray();
       for(var ch:chars){
           if(set.contains(ch)){
               return ch;
           }
           else
                set.add(ch);

       }
       return Character.MIN_VALUE;
   }


}


class Solution {

    static double root(double x, int n) {
        double lo = 0.0, hi = x, md = (lo+hi)/2.0;
        while ((hi-lo)>=0.002) {
            if (Math.pow(md,n)>x) {
                hi = md;
            } else if (Math.pow(md,n)<x) {
                lo = md;
            } else {
                break;
            }
            md = (lo+hi)/2.0;
        }
        return md;
    }

    public static void main(String[] args) {
        double x = 7;
        int n = 3;
        // Expected output: 1.913
        System.out.println(root(x, n));

        x = 9;
        n = 2;
        // Expected output: 3
        System.out.println(root(x, n));
    }
}
