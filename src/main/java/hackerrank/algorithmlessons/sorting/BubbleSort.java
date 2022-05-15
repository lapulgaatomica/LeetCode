package hackerrank.algorithmlessons.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 6, 8,3, 9, 7, 5};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void bubbleSort(int[] array){
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++){
                if(array[i] > array[i + 1]){
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
