package easy1;

public class MinDeletionSize {
    public static void main(String[] args) {
        //https://leetcode.com/problems/delete-columns-to-make-sorted/
        System.out.println(minDeletionSize(new String[]{"abc", "bce", "cae"}) == 1);
        System.out.println(minDeletionSize(new String[]{"cba","daf","ghi"}) == 1);
        System.out.println(minDeletionSize(new String[]{"a", "b"}) == 0);
        System.out.println(minDeletionSize(new String[]{"zyx","wvu","tsr"}) == 3);
    }

    public static int minDeletionSize(String[] strs) {
        int answer = 0;
        int lengthOfFirstString = strs[0].length();
        String[] newStrings = new String[lengthOfFirstString];
        int outerCount = 0;

        for(String str: strs){
            int innerCount = 0;
            for(char character: str.toCharArray()){
                if(outerCount == 0){
                    newStrings[innerCount] = "" + character;
                }else{
                    newStrings[innerCount] += character;
                }
                innerCount++;
            }
            outerCount++;
        }

        for(String newString: newStrings){
            char previousCharacter = 'a';
            for(char currentCharacter: newString.toCharArray()){
                if(currentCharacter - previousCharacter < 0){
                    answer++;
                    break;
                }
                previousCharacter = currentCharacter;
            }
        }
        return answer;
    }
}
