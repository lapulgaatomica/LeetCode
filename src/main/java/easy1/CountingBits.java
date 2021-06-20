package easy1;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        Arrays.stream(countBits(5)).forEach(System.out::println);
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for(int i = 0; i <= n; i++){
            String binary = Integer.toBinaryString(i);
            int numberOfBits = 0;
            for(int j = 0; j < binary.length(); j++){
                if(binary.charAt(j) == '1'){
                    numberOfBits++;
                }
            }
            result[i] = numberOfBits;
        }
        return result;
    }
}
