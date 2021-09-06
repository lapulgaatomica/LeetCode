package easy1;

public class SlowestKey {
    public static void main(String[] args) {
        //https://leetcode.com/problems/slowest-key/
        System.out.println(slowestKey(new int[]{9,29,49,50}, "cbcd"));
        System.out.println(slowestKey(new int[]{12,23,36,46,62}, "spuda"));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char answer = keysPressed.charAt(0);
        int durationOfAnswer = releaseTimes[0];

        for(int i = 1; i < releaseTimes.length; i++){
            int durationOfCurrent = releaseTimes[i] - releaseTimes[i - 1];
            char currentChar = keysPressed.charAt(i);

            if(durationOfCurrent > durationOfAnswer){
                durationOfAnswer = durationOfCurrent;
                answer = currentChar;
            }else if(durationOfCurrent == durationOfAnswer && currentChar > answer){
                answer = currentChar;
            }
        }

        return answer;
    }
}
