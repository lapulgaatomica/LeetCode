package easy4;

import java.util.HashSet;
import java.util.PriorityQueue;

public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(1690));
    }

    public static int nthUglyNumber(int n) {
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.add(1L);

        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        while(n > 0){
            currUgly = heap.poll();
            n--;
            if(n == 0)
                return (int) currUgly;
            for(int prime : primes){
                newUgly = currUgly * prime;
                if(!seen.contains(newUgly)){
                    heap.add(newUgly);
                    seen.add(newUgly);
                }
            }
        }
        return 0;
    }
}
