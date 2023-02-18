package easy4;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("God Ding"));
    }

    public static String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder string = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                answer.append(reverse(string)).append(ch);
                string = new StringBuilder();
            }else
                string.append(ch);
        }
        return answer.append(reverse(string)).toString();
    }

    private static String reverse(StringBuilder word){
        int start = 0;
        int end = word.length() - 1;
        while (start < end){
            char startChar = word.charAt(start);
            char endChar = word.charAt(end);
            word.replace(start, start + 1, String.valueOf(endChar));
            word.replace(end, end + 1, String.valueOf(startChar));
            start++;
            end--;
        }
        return word.toString();
    }
}
