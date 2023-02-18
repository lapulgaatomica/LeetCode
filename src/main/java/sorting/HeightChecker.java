package sorting;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {

    }

    public static int heightChecker(int[] heights) {
        int[] sorted = sort(heights);
        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            if(sorted[i] != heights[i])
                ans++;
        }
        return ans;
    }

    private static int[] sort(int[] heights) {
        int[] toSort = Arrays.copyOf(heights, heights.length);
        for(int i = 0; i < toSort.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < toSort.length; j++){
                if(toSort[j] < toSort[minIndex])
                    minIndex = j;
            }
            int temp = toSort[minIndex];
            toSort[minIndex] = toSort[i];
            toSort[i] = temp;
        }
        return toSort;
    }
}
