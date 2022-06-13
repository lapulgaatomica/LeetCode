package interswitch;

public class FirstQuestion {
    public static void main(String[] args){
        System.out.println(compress("aabcccccaa"));
        System.out.println(compress("aaa"));
        System.out.println(compress("a"));
    }

    public static String compress(String string){
        StringBuilder compressedText = new StringBuilder();
        char lastChar = string.charAt(0);
        int charCount = 1;

        for(int i = 1; i < string.length(); i++) {
            if(string.charAt(i) == lastChar)
                charCount++;
            else {
                compressedText.append(lastChar).append(charCount);
                lastChar = string.charAt(i);
                charCount = 1;
            }
        }
        compressedText.append(lastChar).append(charCount);
        return compressedText.toString();
    }
}
