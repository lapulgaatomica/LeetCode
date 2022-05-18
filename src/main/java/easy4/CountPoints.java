package easy4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPoints {
    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
        System.out.println(countPoints("B0R0G0R9R0B0G0"));
        System.out.println(countPoints("G4"));
    }

    public static int countPoints(String rings) {
        Map<Integer, Set<Character>> map = new HashMap<>();

        for(int i = 0; i < rings.length() - 1; i += 2){
            int currentRingNumber = rings.charAt(i + 1) - 48;
            if(map.containsKey(currentRingNumber)){
                map.get(currentRingNumber).add(rings.charAt(i));
            }else{
                Set<Character> set = new HashSet<>();
                set.add(rings.charAt(i));
                map.put(currentRingNumber, set);
            }
        }
        int answer = 0;
        for(Set<Character> set : map.values()){
            if(set.size() == 3){
                answer++;
            }
        }

        return answer;
    }
}
