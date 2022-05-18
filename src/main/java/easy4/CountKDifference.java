package easy4;

public class CountKDifference {
    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1,2,2,1}, 1));
        System.out.println(countKDifference(new int[]{1, 3}, 3));
        System.out.println(countKDifference(new int[]{3,2,1,5,4}, 2));
    }

    public static int countKDifference(int[] nums, int k) {
        int answer = 0;

        for(int i = 0; i < nums.length - 1; i++){
            int outerNumber = nums[i];
            for (int j = i + 1; j < nums.length; j++){
                int innerNumber = nums[j];
                if(Math.abs(outerNumber - innerNumber) == k)
                    answer++;
            }
        }
        return answer;
    }
}
