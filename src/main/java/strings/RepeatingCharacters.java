package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatingCharacters {
   public static String nonRepeatingWord(String sentense){
       Map<String, Integer> map = new HashMap<>();
       String [] word = sentense.split(" ");
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
