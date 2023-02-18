package easy4;

import java.util.HashMap;
import java.util.Map;

public class CalculateTime {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();

        int pos = 0;
        for(char ch : keyboard.toCharArray())
            map.put(ch, pos++);
        int answer = 0;
        int prev = 0;
        for(char ch : word.toCharArray()){
            int curr = map.get(ch);
            answer += Math.abs(prev - curr);
            prev = curr;
        }
        return answer;
    }
}
