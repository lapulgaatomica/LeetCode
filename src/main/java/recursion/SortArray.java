package recursion;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5,2,3,1})));
        System.out.println(Arrays.toString(sortArray(new int[]{5,1,1,9,2,0,0})));
    }

    public static int[] sortArray(int[] nums) {//merge sort algorithm
        if(nums.length <= 1)
            return nums;
        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] answer = new int[left.length + right.length];
        int answerPointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        while(answerPointer < answer.length && leftPointer < left.length && rightPointer < right.length){
            if(left[leftPointer] < right[rightPointer]){
                answer[answerPointer] = left[leftPointer];
                leftPointer++;
            }else{
                answer[answerPointer] = right[rightPointer];
                rightPointer++;
            }
            answerPointer++;
        }
        while (leftPointer < left.length){
            answer[answerPointer] = left[leftPointer];
            leftPointer++;
            answerPointer++;
        }
        while (rightPointer < right.length){
            answer[answerPointer] = right[rightPointer];
            rightPointer++;
            answerPointer++;
        }
        return answer;
    }
}
