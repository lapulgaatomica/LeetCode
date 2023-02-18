package heap;

import java.util.*;

public class KWeakestRows {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}}, 3)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int row = 0; row < mat.length; row++){
            int count = 0;
            for(int col : mat[row]){
                if(col == 0){
                    break;
                }
                count += col;
            }
            map.put(row, count);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                Map.Entry.<Integer, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey()).reversed());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(entry);
            if(heap.size() > k)
                heap.poll();
        }
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--){
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }
}
