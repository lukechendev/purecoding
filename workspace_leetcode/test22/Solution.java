/*
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.HashMap;

public class Solution {
  
    /* from leetcode but this does't work with numbers larger than 2047, such as the test case 3*/
    public int[] twoSum2(int[] nums, int target) {
        int mod = 2048 - 1;
        int[] map= new int[2048];
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i] & mod;
System.out.println("nums[i]:" + nums[i] + ",key: " + key);
            if(map[key] != 0){
                int[] ret = {map[key] - 1, i};
                return ret;
            }
            map[nums[i]&mod] = i + 1;
        }
        return null;
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; ++i) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                int index = map.get(comp);
                return new int[]{index, i};
            } else {
                map.put(nums[i], i);
            }
        }
        
        return null;
    }

    public static void test(int[] input, int target, int[] expected) {
        Solution s = new Solution();
        // long ts = System.nanoTime();
        int[] ret = s.twoSum(input, target);
        // System.out.println(System.nanoTime() - ts);
        System.out.println("Result: \n" + ret[0] + "," + ret[1]);
        if ((ret[0] == expected[0] && ret[1] == expected[1]) || 
            (ret[0] == expected[1] && ret[1] == expected[0])) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed - Expected: \n" + expected[0] + "," + expected[1]);
        }
        System.out.println("=============================================");
    }

    public static void main(String[] args) {
        test(new int[]{2,7,11,15}, 9, new int[]{0,1});
        test(new int[]{1,21,3,14,5,60,7,6}, 81, new int[]{1,5});
        test(new int[]{6143,8191,10239,1}, 6144, new int[]{0,3});
    }
}
