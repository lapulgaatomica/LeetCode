package easy4;

public class CountHillValley {
    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{2,4,1,1,6,5}));
        System.out.println(countHillValley(new int[]{6,6,5,5,4,1}));
        System.out.println(countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println(countHillValley(new int[]{5, 7, 7, 1, 7}));
    }

    public static int countHillValley(int[] nums) {
        int ans = 0;
        int left = nums[0];

        for (int i = 1; i + 1 < nums.length; ++i)
            if (left < nums[i] && nums[i + 1]  < nums[i]  || // hill
                    left > nums[i] && nums[i + 1] > nums[i]) { // valley
                ++ans;
                left = nums[i];
            }

        return ans;
    }
}
