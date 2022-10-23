package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlElements {
    public static void main(String[] args) {
        System.out.println(stringChallenge("<div><b><p>hello world</p></b></div>"));
        System.out.println(stringChallenge("<div>abc</div><p><em><i>test test</b></em></p>"));
        System.out.println(stringChallenge("<div><div><b></b></div></p>"));
    }


    private static String stringChallenge(String string){
        Map<String, String> brackets = new HashMap<>();
        brackets.put("/div", "div");
        brackets.put("/b", "b");
        brackets.put("/i>", "i");
        brackets.put("/em", "em");
        brackets.put("/p", "p");
        Stack<String> stack = new Stack<>();
        Pattern pattern = Pattern.compile("<([^\\s>]+)");
        Matcher m = pattern.matcher(string);
        while (m.find()) {
            String currentTag = m.group(1);
            if (stack.isEmpty()) {
                stack.push(currentTag);
            } else {
                if (stack.peek().equals(brackets.get(currentTag)))
                    stack.pop();
                else
                    stack.push(currentTag);
            }
        }
        if(stack.isEmpty())
            return "true";
        else{
            while (!stack.isEmpty()){
                String tag = stack.pop();
                if(brackets.containsValue(tag))
                    return tag;
            }
        }
        return "insha allah it doesn't get here";
    }
}
