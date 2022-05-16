package hackerrank.algorithmlessons.bitmanipulation;

public class IsEven {
    public static void main(String[] args) {
        System.out.println(isEven(6));
        System.out.println(isEven(4));
        System.out.println(isEven(3));
        System.out.println(isEven(1));
        System.out.println();
        System.out.println(powerOf4(4));
        System.out.println(powerOf4(5));
    }

    private static int powerOf4(int number){
        return number  & 4;
    }

    public static boolean isEven(int number){
        return (number & 1) == 0;
    }
}
