package easy1;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        // https://leetcode.com/problems/height-checker
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
        System.out.println(heightChecker(new int[]{5,1,2,3,4}));
        System.out.println(heightChecker(new int[]{1,2,3,4,5}));
    }

    public static int heightChecker(int[] heights) {
        int[] sorted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);

        int answer = 0;

        for(int i = 0; i < heights.length; i++){
            if(sorted[i] != heights[i]){
                answer++;
            }
        }
        return answer;
    }
}
