package easy4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ar : arr)
            map.put(ar, map.getOrDefault(ar, 0) + 1);

        Set<Integer> set = new HashSet<>();
        for(int value : map.values()){
            if(!set.add(value))
                return false;
        }
        return true;
    }
}
