package hackerrank.easy;

import java.util.List;

public class TheBirthdayBar {
    public static void main(String[] args) {
        System.out.println(birthday(List.of(1, 2, 1, 3, 2), 3, 2));
        System.out.println(birthday(List.of(1, 1, 1, 1, 1, 1), 3, 2));
        System.out.println(birthday(List.of(4), 4, 1));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int bars = 0;

        for(int i = 0; i < (s.size() - m + 1); i++){
            int sum = 0;

            for(int j = i; j < (i + m); j++){
                sum += s.get(j);
            }

            if(sum == d){
                bars++;
            }
        }
        return bars;
    }
}
