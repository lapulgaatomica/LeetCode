package blind75.slidingwindow;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int lowest = prices[0];
        int answer = 0;

        for(int i = 1; i < prices.length; i++){
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
