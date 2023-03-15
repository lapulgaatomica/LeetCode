package medium;


public class Compress {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }

    public static int compress(char[] chars) {
        int right = 0;
        int answer = 0;
        int count = 0;
        char prev = chars[right];
        int writeIndex = 0;

        while(right < chars.length){
            char curr = chars[right];
            if(curr == prev){
                right++;
                count++;
            }else{
                chars[writeIndex++] = prev;
                if(count == 1)
                    answer += 1;
                else{
                    for(char ch : String.valueOf(count).toCharArray())
                        chars[writeIndex++] = ch;
                    answer += (int)Math.floor(Math.log10(count)) + 2;
                }
                count = 0;
            }
            prev = curr;
        }
        chars[writeIndex++] = prev;
        if(count == 1)
            return answer + (int)Math.floor(Math.log10(count)) + 1;
        else{
            for(char ch : String.valueOf(count).toCharArray())
                chars[writeIndex++] = ch;
            return answer + (int)Math.floor(Math.log10(count)) + 2;
        }
    }
}
