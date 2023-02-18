package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 9, 10, 0, 7, 6, 3, 5, 8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean wasSwapped = true;
        while (wasSwapped){
            wasSwapped = false;
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    wasSwapped = true;
                }
            }
        }
    }
}
