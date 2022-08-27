package blind75.binarysearch;

public class SearchRotated {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,-1,0,1,2}, 0));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(search(new int[]{1}, 0));
//        System.out.println(search(new int[]{1,2,3,4,5,7,8,9,0}, 0));
        System.out.println(search(new int[]{1,2,3,4,5,7,8,9,0}, 9));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            final int m = (left + right) / 2;
            if (nums[m] == target)
                return m;
            if (nums[left] <= nums[m]) { // nums[l..m] are sorted
                if (nums[left] <= target && target < nums[m])
                    right = m - 1;
                else
                    left = m + 1;
            } else { // nums[m..n - 1] are sorted
                if (nums[m] < target && target <= nums[right])
                    left = m + 1;
                else
                    right = m - 1;
            }
        }

        return -1;
    }
}
