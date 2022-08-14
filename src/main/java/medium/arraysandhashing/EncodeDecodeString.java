package medium.arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        System.out.println(encode(List.of("lint","code","love","you")));
        System.out.println(decode("lint:;code:;love:;you"));
        System.out.println(encode(List.of("we", "say", ":", "yes")));
        System.out.println(decode("we:;say:;:::;yes"));
        System.out.println(decode(encode(List.of("lint","code","love","you"))));
        System.out.println(decode(encode(List.of("we", "say", ":", "yes"))));
    }

    public static String encode(List<String> strs) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            if(i != strs.size() - 1){
                if (str.equals(":"))
                    answer.append(":::;");
                else if(str.equals(";"))
                    answer.append(";;:;");
                else
                    answer.append(str).append(":;");
            }else{
                answer.append(str);
            }
        }
        return answer.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        String[] strings = str.split(":;");

        List<String> answer = new ArrayList<>();

        for(String string : strings){
            if(string.equals("::"))
                answer.add(":");
            else if(string.equals(";;"))
                answer.add(";");
            else
                answer.add(string);
        }
        return answer;
    }
}
