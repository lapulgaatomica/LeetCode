package hackerrank.easy;

import java.util.List;

public class HurdleRace {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/the-hurdle-race/problem
        System.out.println(hurdleRace(4, List.of(1, 6, 3, 5, 2)));
        System.out.println(hurdleRace(7, List.of(2, 5, 4, 5, 2)));
    }

    public static int hurdleRace(int k, List<Integer> height) {
        int highest = height.get(0);
        for (int i : height){
            if(i > highest){
                highest = i;
            }
        }
        return highest > k ? highest - k : 0;
    }
}
