package unaccepted;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/combination-sum/
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(combinationSum(new int[]{2}, 1));
        System.out.println(combinationSum(new int[]{1}, 1));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        for(int candidate: candidates){
            if(target % candidate == 0){
                List<Integer> innerAnswer = new ArrayList<>();
                for(int i = 0; i < target/candidate; i++){
                    innerAnswer.add(candidate);
                }
                answer.add(innerAnswer);
            }else{
                for(int innerCandidate: candidates){
                    if(innerCandidate != candidate){
                        int sumOfOuterCandidate = candidate;
                        while (sumOfOuterCandidate < target){
                            if(target % sumOfOuterCandidate == innerCandidate){
                                List<Integer> innerAnswer = new ArrayList<>();
                                if(innerCandidate < candidate){
                                    for(int i = 0; i < (target % sumOfOuterCandidate) / innerCandidate; i++){
                                        innerAnswer.add(innerCandidate);
                                    }
                                    for(int i = 0; i < target / sumOfOuterCandidate; i++){
                                        innerAnswer.add(candidate);
                                    }
                                }else{
                                    for(int i = 0; i < target / sumOfOuterCandidate; i++){
                                        innerAnswer.add(candidate);
                                    }
                                    for(int i = 0; i < (target % sumOfOuterCandidate) / innerCandidate; i++){
                                        innerAnswer.add(innerCandidate);
                                    }
                                }
                                answer.add(innerAnswer);
                                break;
                            }
                            sumOfOuterCandidate += candidate;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
