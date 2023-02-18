package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK {
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int remainder = sum % k;
            if (remainder < 0)
                remainder += k;

            if (remainderCount.containsKey(remainder))
                answer += remainderCount.get(remainder);

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return answer;
    }
}
