package leetcodingchallenge;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        //https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3794/
        System.out.println(removeDuplicates("abbaca"));//ca
        System.out.println(removeDuplicates("azxxzy"));//ay
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stackOfCharacters = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(!stackOfCharacters.isEmpty() && stackOfCharacters.peek().equals(s.charAt(i))){
                stackOfCharacters.pop();
            }else {
                stackOfCharacters.push(s.charAt(i));
            }
        }
        StringBuilder answer = new StringBuilder();

        for(Character character : stackOfCharacters){
            answer.append(character);
        }

        return answer.toString();
    }
}
