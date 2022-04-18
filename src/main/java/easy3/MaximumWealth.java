package easy3;

public class MaximumWealth {
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }

    public static int maximumWealth(int[][] accounts) {
        int highest = 0;

        for(int[] account : accounts){
            int sum = 0;
            for (int acc : account){
                sum += acc;
            }
            if(sum > highest)
                highest = sum;
        }
        return highest;
    }
}
