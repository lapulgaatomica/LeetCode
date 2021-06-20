package easy;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int finalAnswer = 0;
        int lowest = prices[0];

        for(int i = 1; i < prices.length && i >= 1; i++){
            int diff = prices[i] - lowest;

            if (diff >= 1) {
                finalAnswer += diff;
            }

            lowest = prices[i];
        }
        return finalAnswer;
    }
}
