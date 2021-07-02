package easy1;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestCompletingWord {
    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt",
                new String[]{"step","stripe","stepple", "steps"}));
        System.out.println(shortestCompletingWord("aBc 12c",
                new String[]{"abccdef", "caaacab", "cbca"}));
        System.out.println(shortestCompletingWord("1s3 456",
                new String[]{"looks","pest","stew","show"}));
        System.out.println(shortestCompletingWord("OgEu755",
                new String[]{"enough","these","play","wide","wonder","box","arrive","money","tax","thus"}));
        System.out.println(shortestCompletingWord("Ah71752",
                new String[]{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"}));
        System.out.println(shortestCompletingWord("iMSlpe4",
                new String[]{"claim","consumer","student","camera","public","never","wonder","simple","thought","use"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        licensePlate = licensePlate.replaceAll("[^a-zA-Z]", "");
        licensePlate = licensePlate.toLowerCase();
        List<Character> listOfLicencePlateCharacters = new ArrayList<>();

        for(char  character: licensePlate.toCharArray()){
            listOfLicencePlateCharacters.add(character);
        }

        for(int i = 0; i < words.length; i++){
            List<Character> temp = listOfLicencePlateCharacters
                    .stream().collect(Collectors.toList());

            for(char character: words[i].toCharArray()){
                if(temp.contains(character)){
                    temp.remove(temp.indexOf(character));
                }
                if(temp.size() == 0){
                    return words[i];
                }
            }
        }

        return "";
    }
}
