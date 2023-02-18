package heap;

import java.util.*;

public class KClosest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.toString(kClosest(new int[][]{{3,3}, {5,-1}, {-2, 4}}, 2)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Integer, Double>> heap = new PriorityQueue<>(Map.Entry.<Integer, Double>comparingByValue().reversed());
        Map<Integer, Double> map = new HashMap<>();

        for(int i = 0; i < points.length; i++){
            double curr = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));
            map.put(i, curr);
        }

        for(Map.Entry<Integer, Double> entry : map.entrySet()){
            heap.add(entry);
            if(heap.size() > k)
                heap.poll();
        }
        int[][] answer = new int[k][2];
        int i = 0;
        while (i < k){
            answer[i++] = points[heap.poll().getKey()];
        }
        return answer;
    }
}
