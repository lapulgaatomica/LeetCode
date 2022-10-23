package easy4;

import java.util.*;

public class Intersect {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect2(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num1 : nums1)
            map.put(num1, map.getOrDefault(num1, 0) + 1);

        List<Integer> list = new ArrayList<>();

        for(int num2 : nums2){
            if(map.containsKey(num2) && map.get(num2) > 0){
                list.add(num2);
                map.put(num2, map.get(num2) - 1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static int[] intersect2(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j< nums2.length){
            if(nums1[i] < nums2[j])
                ++i;
            else if (nums1[i] > nums2[j])
                ++j;
            else{
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
