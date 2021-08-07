package easy2;

import java.util.List;

public class BreakingRecords {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
        System.out.println(breakingRecords(List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int highestBroken = 0;
        int lowestBroken = 0;
        int highest = scores.get(0);
        int lowest = scores.get(0);

        for(int i = 1; i < scores.size(); i++){
            if(scores.get(i) < lowest){
                lowestBroken++;
                lowest = scores.get(i);
            }
            if(scores.get(i) > highest){
                highestBroken++;
                highest = scores.get(i);
            }
        }
        return List.of(highestBroken, lowestBroken);
    }
}
