package easy;

import java.util.LinkedList;
import java.util.Queue;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary2("11", "1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary2("1010", "1011"));
        System.out.println(addBinary("111", "1"));
        System.out.println(addBinary2("111", "1"));
        System.out.println(addBinary("110010", "100"));
        System.out.println(addBinary2("110010", "100"));
    }

    public static String addBinary2(String a, String b) {
        int remainderCount = 0;
        StringBuilder answer = new StringBuilder();
        StringBuilder aa = new StringBuilder(a);
        StringBuilder bb = new StringBuilder(b);
        while(aa.length() > 0 && bb.length() > 0){
            char currA = aa.charAt(aa.length() - 1);
            char currB = bb.charAt(bb.length() - 1);
            aa.deleteCharAt(aa.length() - 1);
            bb.deleteCharAt(bb.length() - 1);
            int addition = ((int)currA - 48) + ((int)currB - 48);
            if(addition == 0){
                if(remainderCount > 0){
                    answer.append("1");
                    remainderCount--;
                }else{
                    answer.append("0");
                }
            } else if (addition == 1) {
                if(remainderCount > 0){
                    answer.append("0");
                }else{
                    answer.append("1");
                }
            }else{
                if(remainderCount > 0){
                    answer.append("1");
                }else{
                    answer.append("0");
                    remainderCount++;
                }
            }
        }
        while(aa.length() > 0){
            char currA = aa.charAt(aa.length() - 1);
            aa.deleteCharAt(aa.length() - 1);
            if(currA == '1'){
                if(remainderCount > 0)
                    answer.append(0);
                else
                    answer.append(1);
            }else{
                if(remainderCount > 0){
                    answer.append(1);
                    remainderCount--;
                }else{
                    answer.append(0);
                }
            }
        }
        while(bb.length() > 0){
            char currB = bb.charAt(bb.length() - 1);
            bb.deleteCharAt(bb.length() - 1);
            if(currB == '1'){
                if(remainderCount > 0)
                    answer.append(0);
                else
                    answer.append(1);
            }else{
                if(remainderCount > 0){
                    answer.append(1);
                    remainderCount--;
                }else{
                    answer.append(0);
                }
            }
        }
        while (remainderCount > 0){
            answer.append(1);
            remainderCount--;
        }
        return answer.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        int lengthOfLoop;
        int carry = 0;
        String resultString = "";
        int differenceInLength = 0;


        if(a.length() < b.length()){
            lengthOfLoop = a.length();
            differenceInLength = b.length() - a.length();
        }else if(b.length() < a.length()) {
            lengthOfLoop = b.length();
            differenceInLength = a.length() - b.length();
        }else{
            lengthOfLoop = a.length();
        }

        int lengthOfA = a.length() -1;
        int lengthOfB = b.length() - 1;

        for(int i = 0; i < lengthOfLoop; i++){
            if(a.charAt(lengthOfA - i) == '1' && b.charAt(lengthOfB - i) == '1'){
                if(carry == 1){
                    resultString = "1" + resultString;
                }else{
                    resultString = "0" + resultString;
                }
                carry = 1;
            }else if((a.charAt(lengthOfA - i) == '1' && b.charAt(lengthOfB - i) == '0') || (a.charAt(lengthOfA - i) == '0' && b.charAt(lengthOfB - i) == '1')){
               if(carry == 1){
                   resultString = "0" + resultString;
                   carry = 1;
               }else{
                   resultString = "1" + resultString;
                   carry = 0;
               }
            }else if(a.charAt(lengthOfA - i) == '0' && b.charAt(lengthOfB - i) == '0'){
                if(carry == 1){
                    resultString = "1" + resultString;
                }else{
                    resultString = "0" + resultString;
                }
                carry = 0;
            }
        }


        if(differenceInLength > 0){

            if(a.length() > b.length()){
                for(int i = differenceInLength -1; i >= 0; i--){
                    if(a.charAt(i) == '1'){
                        if(carry == 1){
                            resultString = "0" + resultString;
                            carry = 1;
                        }else {
                            resultString = "1" + resultString;
                            carry = 0;
                        }
                    }else{
                        if(carry == 1){
                            resultString = "1" + resultString;
                        }else {
                            resultString = "0" + resultString;
                        }
                        carry = 0;
                    }
                }
            }else{
                for(int i = differenceInLength - 1; i >= 0; i--){
                    if(b.charAt(i) == '1'){
                        if(carry == 1){
                            resultString = "0" + resultString;
                            carry = 1;
                        }else {
                            resultString = "1" + resultString;
                            carry = 0;
                        }
                    }else{
                        if(carry == 1){
                            resultString = "1" + resultString;
                        }else {
                            resultString = "0" + resultString;
                        }
                        carry = 0;
                    }
                }
            }
        }

        if(carry == 1){
            resultString = "1" + resultString;
        }
        return resultString;
    }
}
