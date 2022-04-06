package easy3;

import java.util.*;

public class IceCreamParlor {
    public static void main(String[] args) {
        System.out.println(iceCreamParlor(6, List.of(1, 3, 4, 5, 6)));
    }

    static List<Integer> iceCreamParlor(int m, List<Integer> arr)  {
        Integer[] result = new Integer[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            int y = m - x;
            Integer j = map.get(y);
            if (j != null) {
                result[0] = j + 1;
                result[1] = i + 1;
                break;
            }
            map.put(x, i);
        }
        return new ArrayList<>(Arrays.asList(result));
    }
}
