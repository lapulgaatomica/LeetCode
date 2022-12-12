package greedy;

import java.util.Arrays;

public class TandemBicycle {
    //https://www.algoexpert.io/questions/tandem-bicycle
    public static void main(String[] args) {
        System.out.println(tandemBicycle(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, false));
    }
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        int answer = 0;
        for(int i = 0; i < redShirtSpeeds.length; i++){
            int red = redShirtSpeeds[i];

            int blue;
            if(fastest){
                blue = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
            } else{
                blue = blueShirtSpeeds[i];
            }
            answer += Math.max(red, blue);
        }
        return answer;
    }
}
