package easy4;

import java.util.Arrays;

public class CheckIfPangram {
    public static void main(String[] args) {
        System.out.println('a' - 'a');
        System.out.println('z' - 'a');
    }

    public static boolean checkIfPangram(String sentence) {
        int[] ints = new int[26];
        for(char ch : sentence.toCharArray()){
            if(ints[ch - 'a'] == 0)
                ints[ch - 'a'] = 1;
        }
        for(int intt : ints){
            if(intt == 0)
                return false;
        }
        return true;
    }
}
