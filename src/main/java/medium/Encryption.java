package medium;

import java.util.Arrays;

public class Encryption {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/encryption/problem
        System.out.println(encryption("chill out"));
        System.out.println(encryption("feedthedog"));
        System.out.println(encryption("haveaniceday"));
    }

    public static String encryption(String s) {
        s = s.replaceAll(" ", "");

        double initialCharactersPerWord = Math.ceil(Math.sqrt(s.length()));

        int charactersPerWord = (int) initialCharactersPerWord;
        int numberOfWords = (int)Math.ceil(s.length()/initialCharactersPerWord);
        String[] arrayOfWords = new String[numberOfWords];

        for(int i = 0; i < numberOfWords; i++){
            int start = i * charactersPerWord;

            if(i != numberOfWords - 1){
                arrayOfWords[i] = s.substring(start, start + charactersPerWord);
            }else{
                arrayOfWords[i] = s.substring(start);
            }
        }

        String[] answers = new String[arrayOfWords[0].length()];
        Arrays.fill(answers, "");
        for(int i = 0; i < numberOfWords; i++){
            for(int j = 0; j < arrayOfWords[i].length(); j++){
                answers[j] += arrayOfWords[i].charAt(j);
            }

        }

        StringBuilder finalAnswer = new StringBuilder();
        for(int i = 0; i < answers.length; i++){
            if(i != answers.length -1){
                finalAnswer.append(answers[i]).append(" ");
            }else{
                finalAnswer.append(answers[i]);
            }
        }

        return finalAnswer.toString();
    }
}
