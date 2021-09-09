package unaccepted;

import java.util.List;

public class AlmostSorted {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/almost-sorted/problem
        almostSorted(List.of(1, 5, 4, 3, 2, 6, 7));//yes, number of consecutive decreasing is much
        almostSorted(List.of(5, 4, 3, 2));//yes, number of consecutive decreasing is much
        almostSorted(List.of(5, 4, 2, 3));//no
        almostSorted(List.of(4, 2));//yes, number of mismatches is 1
        almostSorted(List.of(2, 3, 5, 4));//yes, number of mismatches is 1
        almostSorted(List.of(3, 1, 2));//no, can't swap two and cant reverse any sequence
        almostSorted(List.of(3, 1, 2, 0));//yes, can swap 0 and 3
    }

    public static void almostSorted(List<Integer> arr) {
        int smallest = 0;
        int biggest = 0;

        for(int i = 1; i < arr.size(); i++){

        }
    }
}
