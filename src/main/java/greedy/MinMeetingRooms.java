package greedy;

import java.util.*;

public class MinMeetingRooms {
    public static void main(String[] args) {
//        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
//        System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
//        System.out.println(minMeetingRooms(new int[][]{{9, 10}, {4, 9}, {4, 17}}));
//        System.out.println(minMeetingRooms(new int[][]{{2, 11}, {6, 16}, {11, 16}}));
        System.out.println(minMeetingRooms(new int[][]{{4, 16}, {5, 17}, {4, 17}, {12, 17}}));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        Queue<int[]> queue = new LinkedList<>();
        int minRooms = 1;
        int previous = -1;

        for(int[] interval : intervals){
            int start = interval[0];
            if (start < previous){
                queue.add(interval);
                continue;
            }
            previous = interval[1];
        }
        if(queue.size() == 0)
            return minRooms;
        else if(queue.size() == 1)
            return minRooms + 1;
        else{
            int[][] ints = new int[queue.size()][2];
            int i = 0;
            for(int[] ints1 : queue){
                ints[i++] = ints1;
            }
            return minRooms + minMeetingRooms(ints);
        }
    }
}
