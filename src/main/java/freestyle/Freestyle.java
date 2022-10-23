package freestyle;

import java.util.*;

public class Freestyle {
    public static void main(String[] args) {
//        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
//        System.out.println(Arrays.toString(twoSumII(new int[]{2,7,11,15}, 9)));
//        System.out.println(Arrays.toString(twoSumII(new int[]{3,2,4}, 6)));
//        System.out.println(Arrays.toString(twoSumII(new int[]{3, 3}, 6)));
//        System.out.println(Arrays.toString(twoSumII(new int[]{2, 3, 4}, 6)));
        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum2(new int[]{0, 0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int currentNum = nums[i];
            int target = -currentNum;
            Map<Integer, Integer> map = new HashMap<>();

            for(int j = i + 1; j < nums.length; j++){
                if(j == i)
                    continue;
                if(!map.containsKey(nums[j])){
                    map.put(target - nums[j], j);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(currentNum);
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    Collections.sort(list);
                    answer.add(list);
                }
            }
        }
        return new ArrayList<>(answer);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = new char[26];
            for(char ch : str.toCharArray()){
                chars[ch - 'a']++;
            }
            String charsString = new String(chars);
            if(map.containsKey(charsString)){
                map.get(charsString).add(str);
            }else{
                List<String> innerList = new ArrayList<>();
                innerList.add(str);
                map.put(charsString, innerList);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(target - nums[i], i);
            }else{
                return new int[]{i, map.get(nums[i])};
            }
        }
        return null;
    }

    public static int[] twoSumII(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum < 0) {
                        ++lo;
                    } else if (sum > 0) {
                        --hi;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                        while (lo < hi && nums[lo] == nums[lo - 1])
                            ++lo;
                    }
                }
            }
        return res;
    }
}
