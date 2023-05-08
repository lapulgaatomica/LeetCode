package easy5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMaximalUncoveredRanges {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaximalUncoveredRanges(10, new int[][]{{0,2},{2,4},{5,6},{3,3}})));
        System.out.println(Arrays.toString(findMaximalUncoveredRanges(10, new int[][]{{3, 5}, {7, 8}})));
        System.out.println(Arrays.toString(findMaximalUncoveredRanges(3, new int[][]{{0, 2}})));
        System.out.println(Arrays.toString(findMaximalUncoveredRanges(7, new int[][]{{2, 4}, {0, 3}})));
        System.out.println(Arrays.toString(findMaximalUncoveredRanges(10, new int[][]{{0,1},{4,4},{2,4},{2,2},{1,2}})));
        System.out.println(Arrays.toString(findMaximalUncoveredRanges(10, new int[][]{{0,2},{5,8},{3,8},{2,9},{5,7}})));
    }

    public static int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        Arrays.sort(ranges, Arrays::compare);
        List<int[]> ansList = new ArrayList<>();
        int prev = -1;
        int highest = -1;

        for(int[] range : ranges) {
            if(range[0] - highest > 1){
                ansList.add(new int[]{highest + 1, range[0] - 1});
            }
            highest = Math.max(highest, range[1]);
            prev = range[1];
        }
        if(n - highest > 1) {
            ansList.add(new int[]{highest + 1, n - 1});
        }
        int[][] ans = new int[ansList.size()][2];
        for(int i = 0; i < ansList.size(); i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
