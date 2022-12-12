package greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinimumSum {
    public static void main(String[] args) {
        System.out.println(minimumSum(2932));
        System.out.println(minimumSum(4009));
    }

    public static int minimumSum(int num) {
        List<Integer> list = new LinkedList<>();
        while (num > 0){
            list.add(num % 10);
            num /= 10;
        }
        Collections.sort(list);
        return ((list.get(0) * 10) + list.get(2)) + ((list.get(1) * 10) + list.get(3));
    }
}
