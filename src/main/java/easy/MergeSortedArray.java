package easy;

public class MergeSortedArray {
    public static void main(String[] args) {
//        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{1, 1, 2}, 3);
//        merge(new int[]{4,0,0,0,0,0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
        merge(new int[]{4,0,0,0,0,0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6, 7, 8}, 7);
//        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2, 5, 6}, 3);
//        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n > 0){
            int mPosition = 0;
            int nPosition = 0;
            for(int i = 0; i < nums1.length; i++){
                if(mPosition < m){
                    if(nums1[i] <= nums2[nPosition]){
                        mPosition++;
                    }else{
                        int temp = nums1[i];
                        nums1[i] = nums2[nPosition];

                        if(nums2.length == 1 || temp <= nums2[1]){
                            nums2[0] = temp;
                        }else{
                            for(int j = 1; j < n; j++){
                                if(temp >= nums2[j]){
                                    nums2[j - 1] = nums2[j];
                                    nums2[j] = temp;
                                }
                            }
                        }
                    }
                }

                if(i >= m){
                    nums1[i] = nums2[nPosition];
                    nPosition++;
                }
            }
        }
        for(int num : nums1){
            System.out.println(num);
        }
    }
}
