package recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 7, 10, 4, 2, 4, 6, 8, 3, 9};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] list){
        int length = list.length;
        quickSort(list, 0, length - 1);
    }

    public static void quickSort(int[] list, int low, int high){
        if(low < high){
            int p = partition(list, low, high);
            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
    }

    private static int partition(int[] list, int low, int high){
        int pivot = list[high];
        int i = low;
        for(int j = low; j < high; j++){
            if(list[j] < pivot){
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
            }
        }
        int temp = list[i];
        list[i] = list[high];
        list[high] = temp;
        return i;
    }
}
