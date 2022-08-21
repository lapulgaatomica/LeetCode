package blind75.slidingwindow;

public class CharacterReplacement {
    //https://leetcode.com/problems/longest-repeating-character-replacement/
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacementNeetcodeSoln("AABABBA", 1));
        System.out.println(characterReplacement("AB", 0));
        System.out.println(characterReplacement("AB", 1));
        System.out.println(characterReplacement("AAAAAB", 1));
        System.out.println(characterReplacement("ABBB", 2));
    }

    public static int characterReplacementNeetcodeSoln(String s, int k) {
        int[] array = new int[26];
        int answer = 0;
        int maxFrequency = 0;
        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            int freqOfCurrentCharacter = ++array[s.charAt(rightPointer) - 'A'];
            maxFrequency = Math.max(maxFrequency, freqOfCurrentCharacter);
            if (rightPointer - leftPointer + 1 - maxFrequency > k) {
                array[s.charAt(leftPointer) - 'A']--;
                leftPointer++;
            }
            answer = Math.max(answer, rightPointer - leftPointer + 1);
        }
        return answer;
    }

    public static int characterReplacement(String s, int k) {
        int answer = 0;

        for(int left = 0; left < s.length(); left++){
            int right = left + 1;
            int currentCount = 1;
            int kCount = k;
            while(right < s.length()){
                if(s.charAt(left) != s.charAt(right)){
                    if(kCount > 0){
                        kCount--;
                    }else{
                        answer = Math.max(answer, currentCount);
                        break;
                    }
                }
                right++;
                currentCount++;
            }
            answer = Math.max(answer, currentCount);
        }
        return answer;
    }
}
