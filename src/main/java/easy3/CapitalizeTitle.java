package easy3;

import java.util.Locale;

public class CapitalizeTitle {
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }

    public static String capitalizeTitle(String title) {
        String[] strings = title.split(" ");
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if(string.length() < 3)
                answer.append(string.toLowerCase());
            else{
                string = string.toLowerCase();
                char[] chars = string.toCharArray();
                chars[0] = Character.toTitleCase(chars[0]);
                answer.append(chars);
            }
            if(i != strings.length - 1)
                answer.append(" ");
        }

        return answer.toString();
    }
}
