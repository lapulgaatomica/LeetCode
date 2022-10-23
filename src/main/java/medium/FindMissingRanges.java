package medium;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges {
    public static void main(String[] args) {
        System.out.println(findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
        System.out.println(findMissingRanges(new int[]{-1}, -1, -1));
        System.out.println(findMissingRanges(new int[]{1, 2, 3}, 1, 3));
        System.out.println(findMissingRanges(new int[]{}, 1, 1));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList<>();
        if(nums.length < 1){
            if(lower == upper){
                answer.add(lower+"");
            }else{
                answer.add(lower + "->" + upper);
            }
            return answer;
        }


        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                if(nums[i] > lower){
                    Integer lowerBound = lower;
                    Integer upperBound = nums[i] - 1;
                    if(lowerBound.equals(upperBound)){
                        answer.add(lowerBound.toString());
                    }else{
                        answer.add(lowerBound + "->" + upperBound);
                    }
                }
            }else{
                if(nums[i] - 1 != nums[i - 1]){
                    Integer lowerBound = nums[i - 1] + 1;
                    Integer upperBound = nums[i] - 1;
                    if(lowerBound.equals(upperBound)){
                        answer.add(lowerBound.toString());
                    }else{
                        answer.add(lowerBound + "->" + upperBound);
                    }
                }
            }
        }

        if(nums[nums.length - 1] < upper){
            Integer lowerBound = nums[nums.length - 1] + 1;

            if(lowerBound.equals(upper)){
                answer.add(lowerBound.toString());
            }else{
                answer.add(lowerBound + "->" + upper);
            }
        }
        return answer;
    }
}
