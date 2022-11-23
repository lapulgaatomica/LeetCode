package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
    }

    public static List<Integer> getRow(int rowIndex) {
        return getRow(0, new ArrayList<>(), rowIndex );
    }

    private static List<Integer> getRow(int currentIndex, List<Integer> list,int rowIndex) {
        if(rowIndex == 0)
            list.add(1);
        if(currentIndex == rowIndex)
            return list;

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for(int i = 1; i < list.size(); i++)
            temp.add(list.get(i - 1) + list.get(i));
        temp.add(1);
        list = temp;
        return getRow(++currentIndex, list, rowIndex);
    }
}
