package easy3;

public class GetLucky {
    public static void main(String[] args) {
        //https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
        System.out.println(getLucky("iiii", 1) == 36);
        System.out.println(getLucky("leetcode", 2) == 6);
        System.out.println(getLucky("zbax", 2) == 8);
    }

    public static int getLucky(String s, int k) {
        int transform = 0;
        for(char ch : s.toCharArray()){
            int current = ((int) ch - 'a') + 1;
            if(current > 9){
                while (current > 0){
                    transform += current % 10;
                    current /= 10;
                }
            }else{
                transform += current;
            }

        }

        if(k == 1)
            return transform;

        k -= 1;
        while(k > 0){
            int temp = transform;
            transform = 0;
            while (temp > 0){
                transform += temp % 10;
                temp /= 10;
            }
            k--;
        }
        return transform;
    }
}
