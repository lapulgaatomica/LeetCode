package easy5;

import java.util.*;

public class FindRestaurant {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"happy","sad","good"},
                new String[]{"sad","happy","good"})));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ansList = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        int smallest = Integer.MAX_VALUE;
        Map<String, Integer> secondMap = new HashMap<>();
        for(int i = 0; i < list2.length; i++){
            String curr = list2[i];
            int sum = map.getOrDefault(curr, 0) + i;
            if(map.containsKey(curr) && sum <= smallest){
                smallest = sum;
                secondMap.put(curr, sum);
            }
        }
        for(String key : secondMap.keySet()){
            if(secondMap.get(key) == smallest)
                ansList.add(key);
        }
        String[] answer = new String[ansList.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = ansList.get(i);
        return answer;
    }
}
