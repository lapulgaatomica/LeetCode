package blind75.binarysearch;

public class FindMin {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
        System.out.println(findMin(new int[]{4,1,2,3}));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r])
                r = m;
            else
                l = m + 1;
        }

        return nums[l];
    }
}
