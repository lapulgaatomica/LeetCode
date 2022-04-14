package easy3;

public class DetectCapitalUse {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse(String word) {
        boolean allLower = false;
        boolean allUpper = false;
        boolean title = false;

        for(int i = 0; i < word.length(); i++){
            if(i == 0 && Character.isLowerCase(word.charAt(i))){
                allLower = true;
            }
            if(allLower && Character.isUpperCase(word.charAt(i))){
                return false;
            }
            if(i == 0 && Character.isUpperCase(word.charAt(i))){
                allUpper = true;
            }
            if(i == 1 && allUpper){
                if(Character.isLowerCase(word.charAt(i))){
                    title = true;
                    allUpper = false;
                }
            }

            if(i > 1 && allUpper){
                if(Character.isLowerCase(word.charAt(i)) ){
                    return false;
                }
            }

            if (i > 1 && title){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        }

        return true;
    }
}

