package easy2;

public class TwoSumII {
    public static void main(String[] args) {
        for(int i: twoSum(new int[]{0, 0, 3, 4}, 0)){
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
