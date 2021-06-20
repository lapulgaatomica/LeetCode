package easy1;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;

        for(int i = 0; i < columnTitle.length(); i++ ){
            int pow = (int)Math.pow(26, columnTitle.length() - 1 - i);
            result += pow * (columnTitle.charAt(i) - 'A' + 1);
        }

        return result;
    }
}
