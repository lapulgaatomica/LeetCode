package easy2;

public class CountingValleys {
    public static void main(String[] args) {
        // https://www.hackerrank.com/challenges/counting-valleys/problem
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(8, "DDUUUUDD"));
    }

    public static int countingValleys(int steps, String path) {
        int currentLevel = 0;
        int previousLevel = 0;
        int valleysEntered = 0;

        for(int i = 0; i < steps; i++){
            if(path.charAt(i) == 'U'){
                currentLevel++;
            }else{
                currentLevel--;
            }
            if(currentLevel < 0 && previousLevel == 0){
                valleysEntered++;
            }
            previousLevel = currentLevel;
        }
        return valleysEntered;
    }
}
