package easy2;

import java.util.*;

public class HasGroupsSizeX {
    public static void main(String[] args) {
        //https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
        System.out.println(hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
        System.out.println(!hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
        System.out.println(!hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
        System.out.println(hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,2,2}));

//        System.out.println(gcd(3, 1));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 2){
            return false;
        }
        Map<Integer, Integer> frequencyOfCardsInDeck = new TreeMap<>();

        for(int card: deck){
            frequencyOfCardsInDeck.put(card, frequencyOfCardsInDeck.getOrDefault(card, 0) + 1);
        }

        Set<Integer> setOfValues = new TreeSet<>(frequencyOfCardsInDeck.values());

        if(setOfValues.size() == 1){
            return true;
        }

        int gcdOfValues = 0;

        for(int currentValue : frequencyOfCardsInDeck.values()){
            gcdOfValues = gcd(gcdOfValues, currentValue);

            if(gcdOfValues == 1) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
