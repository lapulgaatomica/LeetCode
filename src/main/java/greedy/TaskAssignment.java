package greedy;

import java.util.*;

public class TaskAssignment {
    //https://www.algoexpert.io/questions/task-assignment
    public static void main(String[] args) {
        System.out.println(taskAssignment(3, new ArrayList<>(List.of(1, 3, 5, 3, 1, 4))));
    }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < k*2; i++){
            if(map.containsKey(tasks.get(i)))
                map.get(tasks.get(i)).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(tasks.get(i), list);
            }
        }

        Collections.sort(tasks);
        int left = 0;
        int right = tasks.size() - 1;
        while (left < right){
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(map.get(tasks.get(left)).get(0));
            map.get(tasks.get(left)).remove(0);
            inner.add(map.get(tasks.get(right)).get(0));
            map.get(tasks.get(right)).remove(0);
            answer.add(new ArrayList<>(inner));
            left++;
            right--;
        }
        return answer;
    }
}
