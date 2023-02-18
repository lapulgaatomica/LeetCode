package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals[0][1]);
        int rooms = 1;
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < heap.peek()){
                rooms++;
            }else{
                heap.poll();
            }
            heap.add(curr[1]);
        }
        return rooms;
    }
}
