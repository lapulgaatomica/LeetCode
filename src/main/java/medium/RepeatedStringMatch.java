package medium;

public class RepeatedStringMatch {
    //https://leetcode.com/problems/repeated-string-match/submissions/
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch("a", "aa"));
        System.out.println(repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
    }

    public static int repeatedStringMatch(String a, String b) {
        int index = b.length() / a.length();
        StringBuilder str = new StringBuilder();
        int count = 0;
        for(int i = 0; i <= index + 2; i++){
            if(str.indexOf(b) >= 0)
                return count;
            else{
                str.append(a);
                count++;
            }
        }
        return -1;
    }

    public static int mySubOptimalSolutionRepeatedStringMatch(String a, String b) {
        int times = 1;
        StringBuilder tempString = new StringBuilder(a);

        while (tempString.length() <= 10000){
            if(tempString.indexOf(b) >= 0)
                return times;
            tempString.append(a);
            times++;
        }
        return -1;
    }
}
