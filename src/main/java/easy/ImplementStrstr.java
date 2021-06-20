package easy;

public class ImplementStrstr {
    public static void main(String[] args) {
        System.out.println(strStr("heello", "ll"));
//        System.out.println(strStr("aaaaa", "bba"));
//        System.out.println(strStr("", ""));
//        System.out.println(strStr("a", ""));
//        System.out.println(strStr("", "a"));
//        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {
        if(haystack.length() == 0 ){
            if(needle.length() == 0){
                return 0;
            }else{
                return -1;
            }
        }else if(needle.length() == 0){
            return 0;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }

        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int count = i;
                for(int j = 0; j < needle.length() & count < haystack.length(); j++){
                    if(needle.charAt(j) != haystack.charAt(count)){
                        break;
                    }else{
                        if(j + 1 == needle.length()){
                            return i;
                        }
                        count++;
                    }
                }
            }
        }
        return -1;
    }
}
