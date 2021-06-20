package easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"car"}));
        System.out.println(longestCommonPrefix(new String[]{"", "b"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"a","a","b"}));
        System.out.println(longestCommonPrefix(new String[]{"aaa","aa","aaa"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String longestPrefix = strs[0];
        int finalLength = longestPrefix.length();
        int length;


        if(strs.length == 1){
            return longestPrefix;
        }else{
            for (int i = 0; i < strs.length; i++){
                if(strs[i].length() < 1) {
                    return "";
                }

                if(finalLength < strs[i].length()){
                   length = finalLength;
                }else{
                    length = strs[i].length();
                }

                for(int j = 0; j < length; j++){
                    if(longestPrefix.charAt(j) == strs[i].charAt(j)){
                        finalLength = j + 1;
                    }else{
                        finalLength = j;
                        break;
                    }
                }
            }
            return longestPrefix.substring(0, finalLength);
        }
    }
}
