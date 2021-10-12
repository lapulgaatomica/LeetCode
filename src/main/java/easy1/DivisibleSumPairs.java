package easy1;

import java.util.List;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
        System.out.println(divisibleSumPairs(6, 3, List.of(1, 3, 2, 6, 1, 2)));
        System.out.println(divisibleSumPairs(6, 5, List.of(1,2, 3, 4, 5, 6)));
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int answer = 0;
        for(int i = 0; i < n - 1; i++){
            int first = ar.get(i);
            for(int j = i + 1; j < n; j++){
                int second = ar.get(j);
                if((first + second) % k == 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
