package easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("b   a    "));
    }

    public static int lengthOfLastWord(String s) {
        int lengthOfWord = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                if(i == 0 || s.charAt(i - 1) == ' '){
                    lengthOfWord = 1;
                }else{
                    lengthOfWord++;
                }
            }
        }

        return lengthOfWord;
    }
}
