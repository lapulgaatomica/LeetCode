package easy1;

import java.util.Arrays;

public class GetConcatenation {
    public static void main(String[] args) {
        // https://leetcode.com/problems/concatenation-of-array/submissions/
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] answer = new int[nums.length * 2];

        for(int i = 0; i < nums.length; i++){
            answer[i] = nums[i];
            answer[i + nums.length] = nums[i];
        }

        return answer;
    }
}
