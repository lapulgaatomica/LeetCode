package medium;


public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] hash = new int[60];
        int answer = 0;

        for(int curr : time){
            int temp = curr;
            while (temp > 60)
                temp -= 60;
            if(hash[60 - temp] > 0)
                answer += hash[60 - temp];
            hash[temp % 60]++;
        }
        return answer;
    }
}
