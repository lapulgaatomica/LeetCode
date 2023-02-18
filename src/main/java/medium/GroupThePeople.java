package medium;

import java.util.*;

public class GroupThePeople {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < groupSizes.length; i++){
            int curr = groupSizes[i];
            if(!map.containsKey(curr)){
                map.put(curr, new LinkedList<>());
            }
            map.get(curr).offer(i);
            if(map.get(curr).size() == curr){
                answer.add(new ArrayList<>(map.get(curr)));
                map.remove(curr);
            }
        }
        return answer;
    }
}
