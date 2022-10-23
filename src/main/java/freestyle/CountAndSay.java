package freestyle;

import java.util.Map;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }

    public static String countAndSay(int n) {
        String string = "1";
        for(int i = 1; i < n; i++){
            string = say(string);
        }

        return string;
    }

    public static String say(String string){
        StringBuilder answer = new StringBuilder();
        int currentStreak = 0;

        for(int i = 0; i < string.length(); i++){
            if(i != 0){
                if(string.charAt(i - 1) != string.charAt(i)){
                    answer.append(currentStreak).append(string.charAt(i - 1));
                    currentStreak = 0;
                }
            }
            currentStreak++;
        }
        answer.append(currentStreak).append(string.charAt(string.length() - 1));
        return answer.toString();
    }
}
