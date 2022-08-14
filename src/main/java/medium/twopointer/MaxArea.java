package medium.twopointer;

public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer){
            int minHeight = Math.min(height[leftPointer], height[rightPointer]);
            int width = rightPointer - leftPointer;
            int currentArea = minHeight * width;
            maxArea = Math.max(maxArea, currentArea);
            if(height[leftPointer] < height[rightPointer]){
                ++leftPointer;
            }else{
                --rightPointer;
            }
        }
        return maxArea;
    }
}
