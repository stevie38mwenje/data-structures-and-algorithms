package dp;

public class CoinChange {

    public static int change(int[] coins, int amount){
//        if(amount<1)
//            return 0;

//        return minimumCoins(coins,amount);
        int [] cache = new int[amount];
        for(int i=1;i<amount;i++) {
            cache[i] = -1;
        }
        return minCoins(coins,amount,cache);
    }

    private static int minCoins(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = minCoins(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return count[rem - 1];
    }


    private static int minimumCoins(int[] coins, int target) {
        int[] dp = new int[target + 2];
        //base case
        dp[0] = 0;

        for (int i = 1; i <= target + 1; i++) {
            dp[i]=Integer.MAX_VALUE-1;
            for (int coin : coins) {
                if ((i - coin) >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        if (dp[target] != target+1) {
            return dp[target];
        }
        return -1;
        //return(dp[target]==Integer.MAX_VALUE-1) ? -1 : dp[target];
    }


        public static void main(String[] args) {
            int coins [] = {5,50,60,4,1};
            int coins2 [] = {1,2,5};

            System.out.println("Minimum Count: "+change( coins,110));
            System.out.println("Minimum Count: "+change( coins2,11));

        }




}
