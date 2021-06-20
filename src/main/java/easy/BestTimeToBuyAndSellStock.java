package easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{2, 4, 1}));
        System.out.println(maxProfit(new int[]{2, 1}));
        System.out.println(maxProfit(new int[]{2,1,2,1,0,1,2}));
        System.out.println(maxProfit(new int[]{2,1,2,1,0,0,1}));
    }

    public static int maxProfit(int[] prices) {
        int lowest = prices[0];
        int answer = 0;

        for(int i = 1; i < prices.length && i >= 1; i++){
            int diff = prices[i] - lowest;
            if(diff > answer){
                answer = diff;
            }else if(diff < 1){
                lowest = prices[i];
            }
        }
        if(answer < 1){
            return 0;
        }
        return answer;
    }
}
