package easy4;

import java.util.Map;
import java.util.TreeMap;

public class DigitSum {
    //https://leetcode.com/problems/calculate-digit-sum-of-a-string/submissions/
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
        System.out.println(digitSum2("11111222223", 3));
    }

    public static String digitSum(String s, int k) {
        while (s.length() > k){
            s = operateString(s, k);
        }
        return s;
    }

    private static String operateString(String s, int k){
        StringBuilder str = new StringBuilder();
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < s.length(); i++){
            int current = i / k;
            if(map.containsKey(current)){
                map.put(current, map.get(current) + (s.charAt(i) - '0'));
            }else{
                map.put(current, s.charAt(i) - '0');
            }
        }

        for(int value : map.values())
            str.append(value);

        return str.toString();
    }

    public static String digitSum2(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > k) {
            StringBuilder next = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                sum += sb.charAt(i) - '0';
                if ((i + 1) % k == 0 || i == sb.length() - 1) {
                    next.append(sum);
                    sum = 0;
                }
            }
            sb = next;
        }
        return sb.toString();
    }
}
