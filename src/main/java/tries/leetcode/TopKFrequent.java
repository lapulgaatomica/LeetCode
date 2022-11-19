package tries.leetcode;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Word> candidates = new ArrayList<>();
        for (var entry : map.entrySet()) {
            candidates.add(new Word(entry.getKey(), entry.getValue()));
        }

        Queue<Word> h = new PriorityQueue<>(candidates);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(h.poll().word);
        }
        return res;
    }

    static class Word implements Comparable<Word>{
        String word;
        int freq;

        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        public int compareTo(Word other) {
            if (this.freq == other.freq) {
                return this.word.compareTo(other.word);
            }
            return other.freq - this.freq;
        }
    }
}
