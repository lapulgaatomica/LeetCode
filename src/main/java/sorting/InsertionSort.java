package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 9, 10, 0, 7, 6, 3, 5, 8};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int curr = i;
            while(curr > 0 && arr[curr - 1] > arr[curr]){
                int temp = arr[curr];
                arr[curr] = arr[curr - 1];
                arr[curr - 1] = temp;
                curr--;
            }
        }
    }
}
