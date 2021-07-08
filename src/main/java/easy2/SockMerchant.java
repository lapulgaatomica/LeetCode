package easy2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockMerchant {
    public static void main(String[] args) {
        // https://www.hackerrank.com/challenges/sock-merchant/problem
        System.out.println(sockMerchant(7, List.of(1, 2, 1, 2, 1, 3, 2)));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> frequencyOfNumbers = new HashMap<>();

        // Get frequency of numbers
        for(int currentNumber : ar){
            frequencyOfNumbers.put(currentNumber, frequencyOfNumbers.getOrDefault(currentNumber, 0) + 1);
        }
        int totalNumberOfPairs = 0;

        for(int value: frequencyOfNumbers.values()){
            int currentNumberOfPairs = value / 2;
            totalNumberOfPairs += currentNumberOfPairs;
        }
        return totalNumberOfPairs;
    }
}
