package medium;


public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int answer = 0;
        int[] seen = new int[60];
        for(int t : time){
            answer += seen[(60 - (t % 60)) % 60];
            seen[t % 60]++;
        }
        return answer;
    }
}
