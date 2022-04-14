package easy3;

public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println(toLowerCase("Hello"));
        System.out.println(toLowerCase("here"));
        System.out.println(toLowerCase("LOVELY"));
        System.out.println(toLowerCase("al&phaBET"));
    }

    public static String toLowerCase(String s) {
        StringBuilder answer = new StringBuilder();
        for(char ch : s.toCharArray()){
            if((int) ch >= 65 && (int) ch <=  90)
                answer.append((char)(ch + 32));
            else
                answer.append(ch);
        }
        return answer.toString();
    }
}
