package greedy;

import java.util.HashMap;
import java.util.Map;

public class BalancedStringSplit {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    public static int balancedStringSplit(String s) {
        int ans = 0;
        int[] ints = new int[2];
        for(char ch : s.toCharArray()){
            if(ch == 'L')
                ints[0]++;
            else
                ints[1]++;
            if(ints[0] == ints[1]){
                ans++;
                ints = new int[2];
            }
        }
        return ans;
    }
}
