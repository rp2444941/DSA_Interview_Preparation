package arrays.Hashing_PrefixSum;

public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices={7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
    }
    public  static int maxProfit(int[]prices ){
        int maxProfit=0;
        for (int i = 0; i < prices.length ; i++) {
            for (int j = i+1; j <prices.length ; j++) {
                int currentProfit=prices[j]-prices[i];
                if(currentProfit>maxProfit){
                    maxProfit=currentProfit;
                }

            }

        }
        return maxProfit;
    }
    public static int maxProfit1(int[] prices){
        // Edge case: agar array khali hai
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE; // Sabse sasta price dhoondhne ke liye
        int maxProfit = 0; // Maximum profit store karne ke liye

        for (int i = 0; i < prices.length; i++) {
            // 1. Kya humein ab tak ka sabse sasta price mila?
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // 2. Agar aaj bechein, toh kya profit pehle se zyada hai?
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;

    }

}
