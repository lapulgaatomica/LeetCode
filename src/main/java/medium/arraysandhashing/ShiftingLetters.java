package medium.arraysandhashing;

public class ShiftingLetters {
    public static void main(String[] args) {
        //https://leetcode.com/problems/shifting-letters/submissions/
//        System.out.println(shiftingLetters("abc", new int[]{3, 5, 9}).equals("rpl"));
//        System.out.println(shiftingLetters("aaa", new int[]{1, 2, 3}).equals("gfd"));
//        System.out.println(shiftingLetters("bad", new int[]{10, 20, 30}).equals("jyh"));//jyh
        System.out.println(shiftingLetters("xrdofd", new int[]{70,41,71,72,73,84}).equals("surjgj"));//surjgj
//        System.out.println(shiftingLetters("z", new int[]{52}).equals("z"));//z
    }

    public static String shiftingLetters(String s, int[] shifts) {
        StringBuilder answer = new StringBuilder();
        int sum = 0;

        for(int i = shifts.length - 1; i >= 0; i--){
            sum = (sum + shifts[i]) % 26;//This place can be dicey
            int newAsciiCodeOfCurrentCharacter = s.charAt(i) + sum;

            if(newAsciiCodeOfCurrentCharacter > 122){
                newAsciiCodeOfCurrentCharacter = 96 + ((newAsciiCodeOfCurrentCharacter - 122) % 26);
                if(newAsciiCodeOfCurrentCharacter == 96){
                    newAsciiCodeOfCurrentCharacter = 122;
                }
            }

            answer.insert(0, (char) newAsciiCodeOfCurrentCharacter);
        }
        return answer.toString();
    }
}
