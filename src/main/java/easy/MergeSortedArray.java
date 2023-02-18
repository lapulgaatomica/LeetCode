package easy;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{1, 1, 2}, 3);
        merge(new int[]{4,0,0,0,0,0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
        merge(new int[]{4,0,0,0,0,0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6, 7, 8}, 7);
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPointer = 0;
        int nPointer = 0;
        int[] tempArr = new int[m + n];
        int pointer = 0;
        while (mPointer < m || nPointer < n){
            if(mPointer < m && nPointer < n){
                if(nums1[mPointer] <= nums2[nPointer])
                    tempArr[pointer++] = nums1[mPointer++];
                else
                    tempArr[pointer++] = nums2[nPointer++];
            } else if (nPointer < n)
                tempArr[pointer++] = nums2[nPointer++];
            else
                tempArr[pointer++] = nums1[mPointer++];
        }
        System.arraycopy(tempArr, 0, nums1, 0, tempArr.length);
    }
}
