package grokkingalgorithms.divideandconquer;

import java.util.Arrays;

public class Maximum {
    public static void main(String[] args) {
        System.out.println(maximum(new int[]{1, 2, 3,1, 1,5}));
    }

    public static int maximum(int[] array){
        if(array.length == 0){
            return 0;
        }

        if(array.length == 1){
            return array[0];
        }

        int state = maximum(Arrays.copyOfRange(array, 1, array.length));
        return Math.max(state, array[0]);
    }
}
