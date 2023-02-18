package easy;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(integers);
        System.out.println(integers);
        System.out.println(arrayList);
    }
}
