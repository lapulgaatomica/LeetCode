package hackerrank.medium.unsuccessful;

public class BiggerIsGreater {
    //https://www.hackerrank.com/challenges/bigger-is-greater/problem
    public static void main(String[] args) {
        System.out.println(biggerIsGreater("ab"));
        System.out.println(biggerIsGreater("bb"));
        System.out.println(biggerIsGreater("hefg"));
        System.out.println(biggerIsGreater("dhck"));
        System.out.println(biggerIsGreater("dkhc"));
    }

    public static String biggerIsGreater(String w) {
        StringBuilder answer = new StringBuilder(w);
        for(int i = w.length() - 1; i > 0; i--){
            if(w.charAt(i) > w.charAt(i - 1)){
                char temp = answer.charAt(i);
                answer.setCharAt(i, answer.charAt(i - 1));
                answer.setCharAt(i - 1, temp);
                return answer.toString();
            }
        }

        return "no answer";
    }
}
