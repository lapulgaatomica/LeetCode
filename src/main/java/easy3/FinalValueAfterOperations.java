package easy3;

public class FinalValueAfterOperations {
    public static void main(String[] args) {
        //https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
        System.out.println(finalValueAfterOperations(new String[]{"--X","X++","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"++X","++X","X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"X++","++X","--X","X--"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int answer = 0;

        for(String string : operations){
            char firstChar = string.charAt(0);
            char lastChar = string.charAt(2);
            if(firstChar == '-' || lastChar == '-'){
                answer -= 1;
            }else{
                answer += 1;
            }
        }
        return answer;
    }
}
