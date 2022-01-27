package recursion;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = fibonacci(n-1)+ fibonacci(n-2);
        return fib;
    }

    public static int fib(int n){
        int [] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;

        for(int i=2;i<=n;i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static int fib1(int n){
        int first = 0, second = 1,sum = 0;
        if(n<2){
            return n;
        }
        for(int i=2;i<=n;i++){
            sum = first+second;
            first = second;
            second = sum;
        }
        return sum;
    }

    static class Demo {
        public static void main(String[] args) {
            //Fibonacci fib = new Fibonacci();
            System.out.println(fibonacci(0));
            System.out.println(fib(9));
            System.out.println(fib1(9));

        }
    }


}
