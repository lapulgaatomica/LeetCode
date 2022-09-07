package medium;

import java.util.LinkedList;
import java.util.List;

public class NeedleInHaystack {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        int haystackPointer;
        int lengthOfHaystack = haystack.length();
        int lengthOfNeedle = needle.length();
        char firstCharInNeedle = needle.charAt(0);
        List<Integer> list = new LinkedList<>();

        for(int i = 0; i < lengthOfHaystack; i++){
            if(haystack.charAt(i) == firstCharInNeedle)
                list.add(i);
        }

        if(list.isEmpty()){
            return -1;
        }

        for(int i : list){
            haystackPointer = i;
            int counter = 0;
            int needlePointer = 0;
            while(haystackPointer < lengthOfHaystack){
                if(haystack.charAt(haystackPointer) == needle.charAt(needlePointer)){
                    counter++;
                    haystackPointer++;
                    needlePointer++;
                    if(counter == lengthOfNeedle){
                        return i;
                    }
                }else{
                    break;
                }
            }
        }
        return -1;
    }
}
