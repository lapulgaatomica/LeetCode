package greedy;

import java.util.Arrays;

public class MinimumWaitingTime {
    //https://www.algoexpert.io/questions/minimum-waiting-time
    public static void main(String[] args) {
        System.out.println(minimumWaitingTime(new int[]{3, 2, 1, 2, 6}));
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int answer = 0;

        for(int i = 0; i < queries.length; i++){
            answer += queries[i] * (queries.length - (i + 1));
        }
        return answer;
    }
}
