package easy2;

import java.util.List;

public class MinimumLoss {
    public static void main(String[] args) {
        System.out.println(minimumLoss(List.of(20L, 7L, 8L, 2L, 5L)));
    }

    public static int minimumLoss(List<Long> price) {
        int lowest = Integer.MAX_VALUE;
        for(int i = 0; i < price.size() - 1; i++){
            for(int j = i + 1; j < price.size(); j++){
                long difference = price.get(i) - price.get(j);
                if(difference >= 0 && difference < lowest){
                    lowest = (int) difference;
                }
            }
        }
        return lowest;
    }
}
