package easy4;

import java.util.Arrays;
import java.util.Comparator;

public class CanAttendMeetings {
    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        int previous = -1;
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start < previous)
                return false;
            previous = interval[1];
        }
        return true;
    }
}
