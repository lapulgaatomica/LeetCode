package hackerrank.algorithmlessons.bitmanipulation;

public class ChangeCase {
    public static void main(String[] args){
        String str = "CheRrY";
        System.out.print("Toggle case: ");
        str = toggleCase(str.toCharArray());
        System.out.println(str);

        System.out.print("Original string: ");
        str = toggleCase(str.toCharArray());
        System.out.println(str);
    }

    static String toggleCase(char[] a){
        for (int i=0; i<a.length; i++){
            a[i] ^= 32;// Bitwise XOR with 32
        }
        return new String(a);
    }
}
