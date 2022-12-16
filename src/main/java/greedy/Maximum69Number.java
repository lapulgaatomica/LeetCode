package greedy;

public class Maximum69Number {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
    }

    public static int maximum69Number (int num) {
        StringBuilder numString = new StringBuilder();
        numString.append(num);

        for(int i = 0; i < numString.length(); i++){
            if(numString.charAt(i) == '6'){
                numString.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(numString.toString());
    }
}
