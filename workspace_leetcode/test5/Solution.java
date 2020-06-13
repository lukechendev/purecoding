/*
Remove Duplicates from Sorted Array

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/

class Solution {
  
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
      return len;
    }

    int i = 0;
    for (int j = 1; j < len; ++j) {
      if (nums[j] == nums[i]) {
        continue;
      }

      i++;
      if (i != j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
      }
    }

    return i + 1;
  }

  public int removeDuplicates2(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
      return len;
    }

    int i = 0;
    for (int j = 1; j < len; ++j) {
      if (nums[j] == nums[i]) {
        continue;
      }

      i++;
      nums[i] = nums[j];
    }

    return i + 1;
  }

  public int removeDuplicatesExample(int[] nums) {
    if( nums.length == 0) return 0;
    int i = 0 ; 
    for(int j = 1 ; j < nums.length ; j++){
      if(nums[i] != nums[j]){
        i++;
        nums[i] = nums[j];
      }
    }
    return i+1;
  }

  public static void test(int[] input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.removeDuplicates2(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      if (ret <= 1) {
        System.out.println("Passed");
      } else {
        int n = input[0];
        for (int i = 1; i < ret; i++) {
          if (input[i] > n) {
            n = input[i];
            continue;
          } else {
            System.out.println("Failed2: " + ret);
            return;
          }
        }
        System.out.println("Passed");
        return;
      }
    } else {
      System.out.println("Failed1: " + ret);
      return;
    }
  }

  public static void main(String[] args) {
    int[] input1 = {1,1,2};
    test(input1, 2);
    int[] input2 = {0,0,1,1,1,2,2,3,3,4};
    test(input2, 5);
    int[] input3 = {};
    test(input3, 0);
    int[] input4 = {1};
    test(input4, 1);
    int[] input5 = {1,1,1,1,1,1,1,1,1,1};
    test(input5, 1);
    int[] input6 = {1,2,3,4,5,6};
    test(input6, 6);
  }
}
