package strings;

import java.util.*;

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

//
//import java.io.*;
//        import java.util.*;
//
//class Solution {
//
//    static String[][] wordCountEngine(String document) {
//        // your code goes here
//        HashMap<String,Integer> map = new HashMap<>();
//        HashMap<String,Integer> order = new HashMap<>();
//        ArrayList<String> ans = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        int max = 0;
//        int index =0;
//        for (char ch: document.toCharArray()){
//            if (ch ==' ' && sb.length()!=0){
//                String word = sb.toString();
//                if (!map.containsKey(word)){
//                    map.put(word,1);
//                    order.put(word,index);
//                    ans.add(word);
//                    index++;
//                }else{
//                    map.put(word,map.get(word)+1);
//                }
//                max = Math.max(max,map.get(word));
//                sb = new StringBuilder();
//            }else{
//                if (('a'<=ch && ch<='z' ) || ('A'<=ch && ch<='Z')){
//                    sb.append(Character.toLowerCase(ch));
//                }
//            }
//        }
//        if (sb.length()!=0){
//            String word = sb.toString();
//            if (!map.containsKey(word)){
//                map.put(word,1);
//                order.put(word,index);
//                ans.add(word);
//                index++;
//            }else{
//                map.put(word,map.get(word)+1);
//            }
//            max = Math.max(max,map.get(word));
//        }
//        System.out.println(max);
//        ArrayList<ArrayList<String>> fres = new ArrayList<>();
//        for (int i=0;i<max;i++){
//            fres.add(new ArrayList<>());
//        }
//        for (int i=0;i<ans.size();i++){
//            String word = ans.get(i);
//            int fre = map.get(word);
//            fres.get(fre-1).add(word);
//            //fres[fre].add(word);
//        }
//        String [][]res = new String[ans.size()][2];
//        index = 0;
//        for (int i=fres.size()-1;i>=0;i--){
//            ArrayList<String> nexts = fres.get(i);
//            for (int j=0;j<fres.get(i).size();j++){
//                res[index][0] = fres.get(i).get(j);
//                res[index][1] = String.valueOf(i+1);
//                index++;
//            }
//        }
//        //System.out.println(fres);
//
//        //System.out.println(map);
//        //System.out.println(order);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");
//    }
//
//}

/*

fre   {practice=3, youll=1, perfect=2, get=1, by=1, makes=1, only=1, just=1}
order {practice=0, youll=3, perfect=2, get=5, by=6, makes=1, only=4, just=7}
       practice 3  perfect 2 makes = 1 youll 1 only 1 get 1 by 1 just 1


input:  document = "Practice makes perfect. you'll only
                    get Perfect by practice. just practice!"

practice:3
makes:1
perfect:2
youll:1
only:1
get:1
by:1
just:1
output: [ ["practice", "3"], ["perfect", "2"],
          ["makes", "1"], ["youll", "1"], ["only", "1"],
          ["get", "1"], ["by", "1"], ["just", "1"] ]

*/