package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> finalList  = new ArrayList<>();

        for(int i = 1; i <= rowIndex + 1; i++){
            ArrayList<Integer> currentRowPrint = new ArrayList<>();
            if(i == 1){
                currentRowPrint.add(i);
            }else{
                for (int j = 0; j < i; j++){
                    if( j == 0 || j == i - 1 ){
                        currentRowPrint.add(1);
                    }else{
                        currentRowPrint.add(finalList.get(i - 2).get(j - 1) + finalList.get(i - 2).get(j));
                    }
                }
            }
            finalList.add(currentRowPrint);
        }

        return finalList.get(rowIndex);
    }
}
