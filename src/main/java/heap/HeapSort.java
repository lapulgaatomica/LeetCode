package heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 8, 7, 6, 1, 3, 9, 5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        //mutates elements in lst by utilizing the heap data structure
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            maxHeapify(arr, arr.length, i);
        }

        for(int i = arr.length - 1; i > 0; i--){
            //swap last element with first element
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, i, 0);
        }
    }

    private static void maxHeapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if(left < heapSize && arr[left] > arr[largest])
            largest = left;
        if(right < heapSize && arr[right] > arr[largest])
            largest = right;

        if(largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, heapSize, largest);
        }
    }
}
