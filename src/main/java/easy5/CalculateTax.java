package easy5;

public class CalculateTax {
    public static void main(String[] args) {
        System.out.println(calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
    }

    public static double calculateTax(int[][] brackets, int income) {
        double answer = 0;
        int prev = 0;

        for (int i = 0; i < brackets.length; i++) {
            int[] bracket = brackets[i];
            if(i == 0) {
                answer += Math.min(income, bracket[0]) * ((double)bracket[1] / 100);
            } else {
                answer += (Math.min(income, bracket[0]) - prev) * ((double)bracket[1] / 100);
            }
            prev = Math.min(income, bracket[0]);
        }
        return answer;
    }
}
