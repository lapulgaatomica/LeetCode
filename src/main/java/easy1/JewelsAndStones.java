package easy1;

import java.util.ArrayList;
import java.util.List;

public class JewelsAndStones {
    public static void main(String[] args) {
        // https://leetcode.com/problems/jewels-and-stones/submissions/
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        List<Character> jewelsList = new ArrayList<>();

        for(char jewel : jewels.toCharArray()){
            jewelsList.add(jewel);
        }

        int jewelCount = 0;

        for(int i = 0; i < stones.length(); i++){
            if(jewelsList.contains(stones.charAt(i))){
              jewelCount++;
            }
        }
        return jewelCount;
    }
}
