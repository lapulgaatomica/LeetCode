package easy4;

import java.util.ArrayList;
import java.util.List;

public class GeneratePossibleNextMoves {
    public static void main(String[] args) {
        System.out.println(generatePossibleNextMoves("++++"));
    }

    public static List<String> generatePossibleNextMoves(String currentState) {
        List<String> answer = new ArrayList<>();

        for(int i = 1; i < currentState.length(); i++){
            StringBuilder curr = new StringBuilder(currentState);
            if(curr.charAt(i) == curr.charAt(i - 1)){
                if(curr.charAt(i) =='+')
                    answer.add(curr.replace(i - 1, i + 1, "--").toString());
            }

        }
        return answer;
    }
}
