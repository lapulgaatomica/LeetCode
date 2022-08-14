package medium.arraysandhashing;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> count = new HashMap<>();

        for (final int num : nums)
            count.merge(num, 1, Integer::sum);

        Queue<T> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            final int num = entry.getKey();
            final int freq = entry.getValue();
            minHeap.offer(new T(num, freq));
            if (minHeap.size() > k)
                minHeap.poll();
        }

        for (int i = 0; i < k; ++i)
            ans[i] = Objects.requireNonNull(minHeap.poll()).num;

        return ans;
    }
}

class T {
    public int num;
    public int freq;
    public T(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}