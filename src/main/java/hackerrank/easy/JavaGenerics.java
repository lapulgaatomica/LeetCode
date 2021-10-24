package hackerrank.easy;

import java.util.Scanner;

public class JavaGenerics {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/java-generics/problem
        printArray(new Integer[]{1, 2});
        printArray(new String[]{"Hello", "World"});
    }

    public static <T> void  printArray(T[] array){
        for(T element: array){
            System.out.println(element);
        }
    }
}
