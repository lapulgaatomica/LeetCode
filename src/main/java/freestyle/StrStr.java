package freestyle;

import java.util.LinkedHashSet;
import java.util.Set;

public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        Set<Integer> possibleStartingPoint = new LinkedHashSet<>();
        char firstChar = needle.charAt(0);
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == firstChar)
                possibleStartingPoint.add(i);
        }


        for(int start : possibleStartingPoint){
            int haystackPointer = start;
            int needlePointer = 0;

            while (haystackPointer < haystack.length() && needlePointer < needle.length()){
                if(haystack.charAt(haystackPointer) == needle.charAt(needlePointer)){
                    needlePointer++;
                    haystackPointer++;
                    if(needlePointer == needle.length())
                        return haystackPointer - needlePointer;
                }else{
                    break;
                }
            }
        }

        return -1;
    }
}
