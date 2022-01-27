package dp;

import java.util.HashSet;

public class nonRepeating {
    public static int lengthOfLongestSubString( String s){
        if(s.length()==0||s.length()==1) {
            return s.length();
        }
            HashSet<Character> set = new HashSet<>();
            int rightPointer =0,leftPointer=0,ans = 0;
            while(rightPointer<s.length()){
                if(!set.contains(s.charAt(rightPointer))){
                    set.add(s.charAt(rightPointer));
                    rightPointer++;
                    ans=Math.max(ans,(rightPointer-leftPointer));
                }
                else
                    set.remove(s.charAt(leftPointer++));
                    //leftPointer++;
            }

        return ans;
    }

    public static void main(String[] args) {
        String word = "abcabcaa";
        System.out.println("Longest non-repeating: "+lengthOfLongestSubString( word));
    }
}
