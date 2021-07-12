package easy2;

public class SortArrayByParity {
    public static void main(String[] args) {
        // https://leetcode.com/problems/sort-array-by-parity/
        for(int num : sortArrayByParity(new int[]{3, 1, 2, 4})){
            System.out.print(num + " ");
        }
    }

    public static int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];
        int i = 0;

        for(int num: nums){
            if(num % 2 == 0){
                answer[i] = num;
                i++;
            }
        }

        for(int num : nums){
            if(num % 2 == 1){
                answer[i] = num;
                i++;
            }
        }

        return answer;
    }
}
