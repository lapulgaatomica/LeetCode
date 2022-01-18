package grokkingalgorithms.divideandconquer;

import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{2, 4, 6, 8}));
        System.out.println(sum(new int[]{}));
    }

    private static int sum(int[] numbers){
        if(numbers.length == 0){
            return 0;
        }

        if(numbers.length == 1){
            return numbers[0];
        }
        return numbers[0] + sum(Arrays.copyOfRange(numbers, 1, numbers.length));
    }
}
