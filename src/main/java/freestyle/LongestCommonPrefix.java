package freestyle;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","q"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String shortest = strs[0];
        for(String string : strs)
            if(string.length() < shortest.length())
                shortest = string;
        if(shortest.length() == 0)
            return "";


        for(String string : strs){
            for(int i = 0; i < shortest.length(); i++){
                if(string.charAt(i) != shortest.charAt(i)){
                    shortest = shortest.substring(0, i);
                    break;
                }
            }
        }

        return shortest;
    }
}
