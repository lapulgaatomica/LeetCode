package easy2;

import java.util.*;

public class AddToArrayForm {
    public static void main(String[] args) {
        // https://leetcode.com/problems/add-to-array-form-of-integer/
        System.out.println(addToArrayForm(new int[]{1,2,0,0}, 34));
        System.out.println(addToArrayForm(new int[]{2,7,4}, 181));
        System.out.println(addToArrayForm(new int[]{2,1,5}, 806));
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
        System.out.println(addToArrayForm(new int[]{0}, 10000));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        for(int i = num.length - 1; i >= 0; i--){
           int addition = num[i] +  (k % 10);
            k /= 10;
           if(addition > 9){
               k += addition / 10;
               addition %= 10;

           }
           result.add(addition);
        }

        while(k > 0){
            int addition = k % 10;
            k /= 10;
            result.add(addition);
        }

        Collections.reverse(result);

        return result;
    }
}
