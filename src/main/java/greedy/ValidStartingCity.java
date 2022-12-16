package greedy;

import java.util.Arrays;

public class ValidStartingCity {
    public static void main(String[] args) {
        //https://www.algoexpert.io/questions/valid-starting-city
        System.out.println(validStartingCity(new int[]{5, 25, 15, 10, 15}, new int[]{1, 2, 1, 0, 3}, 10));
    }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        for(int i = 0; i < fuel.length; i++){
            fuel[i] = fuel[i] * mpg;
        }
        for(int i = 0; i < fuel.length; i++){
            int remaining = 0;
            int previous = i;
            int next = (i + 1) % fuel.length;
            while (next != i && remaining >= 0){
                remaining += (fuel[previous] - distances[previous]);
                previous = next;
                next = (next + 1) % fuel.length;
            }
            if(remaining >= 0)
                return i;
        }
        return -1;
    }
}
