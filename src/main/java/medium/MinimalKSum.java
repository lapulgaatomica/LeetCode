package medium;

import java.util.Arrays;

public class MinimalKSum {
    public static void main(String[] args) {
        System.out.println(minimalKSum(new int[]{1,4,25,10,25}, 2));
        System.out.println(minimalKSum(new int[]{5, 6}, 6));
    }

    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = 0;
        long answer = 0;

        for(int ar : nums){
            int sub = ar - prev - 1;
            if(sub > 0){
                int count = 0;
                if(sub >= k){
                    while (count < k){
                        answer += prev + 1;
                        prev++;
                        count++;
                    }
                    return answer;
                } else {
                    while (count < sub){
                        answer += prev + 1;
                        prev++;
                        count++;
                    }
                    k -= sub;
                }
            }
            prev = ar;
        }
        for(int i = 0; i < k; i++){
            answer += prev + 1;
            prev++;
        }
        return answer;
    }
}
