package dp;

public class Rob {
    public static int rob(int[] houses){
        if(houses.length == 0){
            return 0;
        }
        if(houses.length==1){
            return houses[0];
        }
        int first = houses[0], last = Math.max(houses[0],houses[1]), sum = last;
        for(int i =2;i<houses.length;i++){
            sum=Math.max(first+houses[i],last);
            first = last;
            last = sum;
        }
        return sum;
    }

    public static int rob1(int [] houses){
        int[] cache = new int[houses.length+1];
        cache[0]=houses[0];
        cache[1]=Math.max(houses[0],houses[1]);

        return impl(houses, cache);
    }

    private static int impl(int[] houses, int[] cache) {
        for(int i=2;i<houses.length;i++){
            int ith_selected = cache[i-2]+houses[i];
            int ith_not_selected =cache[i-1];

            return Math.max(ith_selected,ith_not_selected);

        }


        return cache.length-1;
    }

        public static int rob2(int[] nums) {
            int [] dp = new int[nums.length];

            if(nums.length == 1)return nums[0];
            //base cases
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);

            //recurrence realtionship
            for(int i = 2;i<nums.length;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);

            }

            return dp[nums.length-1];


        }


    static class Demo {
        public static void main(String[] args) {
            int houses [] = {5,50,66,4,100};

            //Fibonacci fib = new Fibonacci();
            System.out.println("We are robbing "+rob(houses));
            System.out.println("We are robbing "+rob2(houses));
//            System.out.println(fib(9));
//            System.out.println(fib1(9));

        }
    }
}
