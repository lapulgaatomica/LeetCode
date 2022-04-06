//package grokkingalgorithms.divideandconquer;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class QuickSort {
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(quickSort(new int[]{10, 5, 2, 3})));
//    }
//
//    public static int[] quickSort(int[] array){
//        if(array.length < 2){
//            return array;
//        }else{
//            int pivot = array[0];
//            int[] less = new int[];
//            int[] greater = new int[];
//
//            for(int arr : Arrays.copyOfRange(array, 1, array.length)){
//                if(arr < pivot){
//                    less.add(arr);
//                }
//                if(arr > pivot){
//                    greater.add(arr);
//                }
//            }
//
//        }
//    }
//}
