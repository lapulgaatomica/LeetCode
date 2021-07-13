package easy2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class LemonadeChange {
    public static void main(String[] args) {
        //https://leetcode.com/problems/lemonade-change/
        System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));//true
        System.out.println(lemonadeChange(new int[]{5,5,10}));//true
        System.out.println(!lemonadeChange(new int[]{10,10}));//false
        System.out.println(!lemonadeChange(new int[]{5,5,10,10,20}));//false
        System.out.println(!lemonadeChange(new int[]{5,5,5,5,20,20,5,5,5,5}));//false
        System.out.println(!lemonadeChange(new int[]{5,5,20,5,5,10,5,10,5,20}));//false

    }

    public static boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int bill: bills) {
            if (bill == 5)
                fives++;
            else if (bill == 10) {
                if (fives == 0) return false;
                fives--;
                tens++;
            } else {
                if (fives > 0 && tens > 0) {
                    fives--;
                    tens--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;

//        Map<Integer, Integer> billsCount = new TreeMap<>();
//
//        for(int bill: bills){
//            billsCount.put(bill, billsCount.getOrDefault(bill, 0) + 1);
//        }
//
//        for(int key: billsCount.keySet()){
//            for(int i = 0; i < billsCount.get(key); i++){
//                if(key == 10){
//                    if(billsCount.containsKey(5) && billsCount.get(5) > 0){
//                        billsCount.put(5, billsCount.getOrDefault(5, 0) - 1);
//                    }else{
//                        return false;
//                    }
//                }
//
//                if(key == 20){
//
//                    if(billsCount.containsKey(10) && billsCount.get(10) > 0){
//                        billsCount.put(10, billsCount.getOrDefault(10, 0) - 1);
//                        if(billsCount.containsKey(5) && billsCount.get(5) > 0){
//                            billsCount.put(5, billsCount.getOrDefault(5, 0) - 1);
//                        }else{
//                            return false;
//                        }
//                    }else{
//                        return false;
//                    }
//                }
//            }
////            System.out.println(billsCount);
//        }
//        return true;
    }
}
