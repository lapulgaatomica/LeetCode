package easy5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramMappings {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(anagramMappings(new int[]{12,28,46,32,50}, new int[]{50,12,32,46,28})));
    }

    public static int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], i));
        }

        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}
