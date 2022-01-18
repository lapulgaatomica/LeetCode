package grokkingalgorithms.divideandconquer;

import java.util.Arrays;

public class NumberOfItems {
    public static void main(String[] args) {
        System.out.println(numberOfItems(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static int numberOfItems(int[] array){
        if(array.length == 0){
            return 0;
        }

        if(array.length == 1){
            return 1;
        }
        return 1 + numberOfItems(Arrays.copyOfRange(array, 1, array.length));
    }
}
