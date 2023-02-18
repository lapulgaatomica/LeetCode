package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {

    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int[] row : matrix){
            for(int col : row){
                heap.offer(col);
                if(heap.size() > k)
                    heap.poll();
            }
        }
        return heap.poll();
    }

    public static int kthSmallest2(int[][] matrix, int k) {
        int adder = 0;
        int currRow = 0;

        while (adder + matrix[currRow].length < k){
            adder += matrix[currRow].length;
            currRow++;
        }

        return matrix[currRow][k - adder - 1];
    }
}
