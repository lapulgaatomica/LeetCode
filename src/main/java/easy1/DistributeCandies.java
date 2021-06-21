package easy1;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static void main(String[] args) {
        // https://leetcode.com/problems/distribute-candies/
        System.out.println(distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println(distributeCandies(new int[]{1,1,2,3}));
        System.out.println(distributeCandies(new int[]{6, 6, 6, 6}));
    }

    public static int distributeCandies(int[] candyType) {
        Set<Integer> setOfRecommendedNumberOfCandies = new HashSet<>();
        int lengthOfCandyTypeArray = candyType.length;
        int halfOfLengthOfCandyTypeArray = lengthOfCandyTypeArray / 2;

        for(int i = 0; i < lengthOfCandyTypeArray && setOfRecommendedNumberOfCandies.size() < halfOfLengthOfCandyTypeArray; i++){
            setOfRecommendedNumberOfCandies.add(candyType[i]);
        }

        return setOfRecommendedNumberOfCandies.size();
    }
}
