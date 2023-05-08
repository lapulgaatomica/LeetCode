package medium;

import java.util.Stack;

public class PredictPartyVictory {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DDRRR") == "Dire");
        System.out.println(predictPartyVictory("RDD") == "Dire");
        System.out.println(predictPartyVictory("RD") == "Radiant");
        System.out.println(predictPartyVictory("DDDDRRDDDRDRDRRDDRDDDRDRRRRDRRRRRDRDDRDDRRDDRRRDDRRRDDDDRRRRRRRDDRRRDDRDDDRRRDRDDRDDDRRDRRDRRRDRDRDR") == "Dire");
    }

    public static String predictPartyVictory(String senate) {
        StringBuilder senateArray = new StringBuilder(senate);
        int rCount = 0;
        int dCount = 0;
        for(int i = 0; i < senateArray.length(); i++) {
            if(senateArray.charAt(i) == 'R')
                rCount++;
            else
                dCount++;
        }

        int turn = 0;

        while (rCount > 0 && dCount > 0) {
            if(senateArray.charAt(turn) == 'R') {
                boolean bannedSenatorBefore = ban(senateArray, 'D', (turn + 1) % senateArray.length());
                if(bannedSenatorBefore)
                    turn--;
                dCount--;
            } else {
                boolean bannedSenatorBefore = ban(senateArray, 'R', (turn + 1) % senateArray.length());
                if(bannedSenatorBefore)
                    turn--;
                rCount--;
            }
            turn = (turn + 1) % senateArray.length();
        }
        if(rCount > 0)
            return "Radiant";
        return "Dire";
    }

    private static boolean ban(StringBuilder senateArray, char toBan, int startAt) {
        boolean loopAround = false;
        int pointer = startAt;

        while (true) {
            if(pointer == 0)
                loopAround = true;

            if(senateArray.charAt(pointer) == toBan) {
                senateArray.deleteCharAt(pointer);
                break;
            }
            pointer = (pointer + 1) % senateArray.length();
        }
        return loopAround;
    }
}
