package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuilding {
    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        System.out.println(furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));

    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders){
        Queue<Integer> ladderAllocations = new PriorityQueue<>();
        for(int i = 0; i < heights.length - 1; i++){
            int climb = heights[i + 1] - heights[i];
            if(climb <= 0)
                continue;
            ladderAllocations.add(climb);
            if(ladderAllocations.size() <= ladders)
                continue;
            bricks -= ladderAllocations.remove();
            if(bricks < 0)
                return i;
        }
        return heights.length - 1;
    }
}
