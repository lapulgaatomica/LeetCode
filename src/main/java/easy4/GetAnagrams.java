package easy4;

public class GetAnagrams {
    /*
    * Given two strings (lowercase a -> z), how many characters do
    *  we need to remove (from either) to make them anagrams
    * Example: hello, billion --> ANSWER: 6 (he from hello and biin from billion)
    * */

    public static void main(String[] args) {
        System.out.println(getAnagrams("hello", "billion"));
        System.out.println(getAnagrams("hello", "hello"));
    }

    public static int getAnagrams(String first, String second){
        int[] firstCharFreq = new int[26];
        int[] secondCharFreq = new int[26];

        for(char c : first.toCharArray()){
            firstCharFreq[c - 'a']++;
        }

        for(char c : second.toCharArray()){
            secondCharFreq[c - 'a']++;
        }
        int answer = 0;
        for(int i = 0; i < firstCharFreq.length; i++)
            answer += Math.abs(firstCharFreq[i] - secondCharFreq[i]);

        return answer;
    }
}
