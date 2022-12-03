package recursion;

import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations2("23"));
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new LinkedList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");map.put('3', "def");map.put('4', "ghi");map.put('5', "jkl");
        map.put('6', "mno");map.put('7', "pqrs");map.put('8', "tuv");map.put('9', "wxyz");
        List<String> answer = new LinkedList<>();
        helper("", digits, map, answer);
        return answer;
    }

    private static void helper(String curr, String digits, Map<Character, String> map, List<String> answer){
        if(curr.length() == digits.length()){
            answer.add(curr);
        }else{
            String combs = map.get(digits.charAt(curr.length()));
            for(int i = 0; i < combs.length(); i++){
                String newCurr = curr + combs.charAt(i);
                helper(newCurr, digits, map, answer);
            }
        }
    }

    public static List<String> letterCombinations2(String digits) {
        if(digits.length() == 0)
            return new LinkedList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");map.put('3', "def");map.put('4', "ghi");map.put('5', "jkl");
        map.put('6', "mno");map.put('7', "pqrs");map.put('8', "tuv");map.put('9', "wxyz");
        List<String> answer = new LinkedList<>();
        helper2(new StringBuilder(), digits, map, answer);
        return answer;
    }

    private static void helper2(StringBuilder curr, String digits, Map<Character, String> map, List<String> answer){
        if(curr.length() == digits.length()){
            answer.add(curr.toString());
        }else{
            String combs = map.get(digits.charAt(curr.length()));
            for(int i = 0; i < combs.length(); i++){
                curr.append(combs.charAt(i)) ;
                helper2(curr, digits, map, answer);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}
