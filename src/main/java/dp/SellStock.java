package dp;

public class SellStock {
    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;//7
        int overallProfit = 0;
        int profitIfSoldToday = 0;
            //[7,1,5,3,6,4]
        for(int i = 0;i<=prices.length-1;i++){
            if(prices[i]<leastSoFar)
                leastSoFar = prices[i];//7->1

            profitIfSoldToday = prices[i] - leastSoFar;//0

            if(overallProfit<profitIfSoldToday){
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;

//        int buy = Integer.MAX_VALUE;//24000
//        int sell = Integer.MIN_VALUE;//0
//        int profit = 0;
//
//        for (int i = 0; i < prices.length - 1; i++) {
//            buy = Math.min(buy, prices[i]);//(24000,7)->(7,1)->(1,5)
//            sell = Math.max(sell, prices[i]);//(0,7)-(7)
//            profit = sell - buy;
//        }
//        return profit;

//
//        int leftPtr = 0;
//        int rightPtr = 1;
//        int maxProfit = 0;
//        while(rightPtr<prices.length){
//            if(prices[leftPtr]<prices[rightPtr]){
//                int profit = prices[leftPtr]-prices[rightPtr];
//                maxProfit = Math.max(maxProfit,profit);
//            }
//            else {
//                leftPtr = rightPtr;
//                rightPtr+=1;
//            }
//        }
//        return maxProfit;
    }
}
