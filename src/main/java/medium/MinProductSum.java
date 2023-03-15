package medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinProductSum {
    public static void main(String[] args) {

    }

    public static int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        for(int i = 0; i < nums1.length; i++){
            ans += nums1[i] * nums2[nums2.length - i - 1];
        }
        return ans;
    }
}
