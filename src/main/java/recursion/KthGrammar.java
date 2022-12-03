package recursion;

public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1));
        System.out.println(kthGrammar(2, 1));
        System.out.println(kthGrammar(2, 2));
        System.out.println(kthGrammar(4, 2));
        System.out.println(kthGrammar(13, 2));
        System.out.println(getNthFib(6));
    }

    public static int kthGrammar(int n, int k) {
        StringBuilder sb = new StringBuilder().append('0');
        for(int i = 1; i < n; i++){
            int size = sb.length();
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < size; j++){
                if(sb.charAt(j) == '0')
                    temp.append('0').append('1');
                else
                    temp.append('1').append('0');
            }
            sb = temp;
        }

        return Integer.parseInt(String.valueOf(sb.charAt(k - 1)));
    }

    public static int getNthFib(int n) {
        if(n == 0 || n == 1)
            return n;
        return getNthFib(n -1) + getNthFib(n - 2);
    }
}
