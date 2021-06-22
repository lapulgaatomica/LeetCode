package easy1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotReturnToOrigin {
    // https://leetcode.com/problems/robot-return-to-origin/
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
        System.out.println(judgeCircle("RRDD"));
        System.out.println(judgeCircle("LDRRLRUULR"));
    }

    public static boolean judgeCircle(String moves) {
        List<Character> movesList = new ArrayList<>();
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('U', 'D');
        characterMap.put('D', 'U');
        characterMap.put('L', 'R');
        characterMap.put('R', 'L');

        for(int i = 0; i < moves.length(); i++){
            Character currentChar = moves.charAt(i);
            Character oppositeCharacter = characterMap.get(currentChar);
            if(movesList.contains(oppositeCharacter)){
                movesList.remove(oppositeCharacter);
            }else{
                movesList.add(currentChar);
            }
        }

        return movesList.isEmpty();
    }
}
