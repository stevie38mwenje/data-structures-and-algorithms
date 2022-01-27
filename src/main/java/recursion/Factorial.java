package recursion;

import spa.Journal;

public class Factorial {

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    static class Demo {
        public static void main(String[] args) {
            //Factorial factorial = new Factorial();
            System.out.println(factorial(9));

        }
    }
}
