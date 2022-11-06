package queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        ArrayList<Integer> squareNums = new ArrayList<>();
        for(int i = 1; i * i <= n; i++)
            squareNums.add(i * i);

        Set<Integer> queue = new HashSet<>();
        queue.add(n);

        int level = 0;
        while (!queue.isEmpty()){
            level += 1;
            Set<Integer> nextQueue = new HashSet<>();
            for(Integer remainder : queue){
                for(Integer square : squareNums){
                    if(remainder.equals(square))
                        return level;
                    else if(remainder < square)
                        break;
                    else
                        nextQueue.add(remainder - square);
                }
            }
            queue = nextQueue;
        }
        return level;
    }
}
