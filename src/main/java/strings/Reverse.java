package strings;

import java.util.Stack;

public class Reverse {
    public char reverseWord(String sentence){

        Stack<Character> stack = new Stack<>();
        for(var ch:sentence.toCharArray()){
            stack.push(ch);

        }
        System.out.println(stack);

        StringBuilder reversed = new StringBuilder();
        //String reversed = "";
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        System.out.println(reversed);

        return Character.MIN_VALUE;
    }
}
