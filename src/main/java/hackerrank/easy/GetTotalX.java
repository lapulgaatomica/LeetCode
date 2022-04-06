package hackerrank.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GetTotalX {
    public static void main(String[] args) {
        System.out.println(getTotalX(List.of(2, 4), List.of(16, 32, 96)));
        System.out.println(getTotalX(List.of(2, 6), List.of(24, 36)));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int firstB = b.get(0);
        Set<Integer> candidates = new TreeSet<>();

        for(int candidate : a){
            int multiplier = 1;
            int possibleMultiple = candidate * multiplier;
            while(possibleMultiple <= firstB){
                candidates.add(possibleMultiple);
                possibleMultiple = candidate * ++multiplier;
            }
        }
        Set<Integer> interim = new HashSet<>();
        for(int candidate : candidates){
            boolean pass = true;
            for(int interimA : a){
                if (candidate % interimA != 0) {
                    pass = false;
                    break;
                }
            }
            if(pass){
                interim.add(candidate);
            }
        }
        int ans = 0;
        for (int interimB : b){
            boolean pass = false;
            for(int candidate: interim){
                if(interimB % candidate == 0){
                    pass = true;
                    break;
                }
            }
            if(pass){
                ans++;
            }
        }
        return ans;
    }
}
