package unaccepted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumEquivDominoPairs {
    public static void main(String[] args) {
        // https://leetcode.com/problems/number-of-equivalent-domino-pairs/
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        List<Integer> list = new ArrayList<>();
        int numberOfPairs = 0;

        for(int i = 0; i < dominoes.length - 1; i++){
            if(!list.contains(i)){
                list.add(i);
                int outerFirst = dominoes[i][0];
                int outerSecond = dominoes[i][1];
                for(int j = i + 1; j < dominoes.length; j++){
                    if(!list.contains(j)){
                        int innerFirst = dominoes[j][0];
                        int innerSecond = dominoes[j][1];
                        if((outerFirst == innerFirst && outerSecond == innerSecond)
                                || (outerFirst == innerSecond && innerFirst == outerSecond)){
                            numberOfPairs++;
                            list.add(j);
                        }
                    }
                }
            }
        }

        return numberOfPairs;
    }
}
