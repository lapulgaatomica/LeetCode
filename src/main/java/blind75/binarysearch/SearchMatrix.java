package blind75.binarysearch;

public class SearchMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13));
        System.out.println(searchMatrix2(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3));
        System.out.println(searchMatrix2(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13));
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] currentMatrix : matrix) {
            if (currentMatrix[currentMatrix.length - 1] >= target) {
                return binarySearch(currentMatrix, target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
