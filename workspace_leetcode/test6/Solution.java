/*
Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

import java.util.Arrays;

class Solution {
  
  public void nextPermutation(int[] nums) {
    int len = nums.length;

    if (len <= 1) {
      return;
    }

    // Search backward to find the first i that is smaller than i + 1
    int i = len - 2;
    for (; i >= 0; --i) {
      if (nums[i] < nums[i+1]) {
        break;
      }
    }

    // Search backward to find the first j that is bigger than i
    if (i >= 0) {
      int j = len - 1;
      for (; j > i; --j) {
	if (nums[j] > nums[i]) {
	  break;
	}
      }

      // swap i an j so j becomes the next one leading the changed tail
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }

    // reverse anything > i
    int b = i + 1;
    int e = len - 1;
    while (e > b) {
      int t = nums[b];
      nums[b] = nums[e];
      nums[e] = t;
      
      --e;
      ++b;
    }
  }

  public static void test(int[] input, int[] expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    s.nextPermutation(input);
    // System.out.println(System.nanoTime() - ts);
    if (Arrays.equals(input, expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + Arrays.toString(input));
    }
  }

  public static void main(String[] args) {
    int[] input1 = {1,2,3};
    int[] expected1 = {1,3,2};
    test(input1, expected1);

    int[] input2 = {3,2,1};
    int[] expected2 = {1,2,3};
    test(input2, expected2);

    int[] input3 = {1,1,5};
    int[] expected3 = {1,5,1};
    test(input3, expected3);

    int[] input4 = {3,2,4,6,7};
    int[] expected4 = {3,2,4,7,6};
    test(input4, expected4);

    int[] input5 = {3,2,4,7,6};
    int[] expected5 = {3,2,6,4,7};
    test(input5, expected5);

    int[] input6 = {3,2,4,9,1};
    int[] expected6 = {3,2,9,1,4};
    test(input6, expected6);

    int[] input7 = {3,2,9,1,4};
    int[] expected7 = {3,2,9,4,1};
    test(input7, expected7);

    int[] input8 = {3,2,9,1,0};
    int[] expected8 = {3,9,0,1,2};
    test(input8, expected8);

    int[] input9 = {};
    int[] expected9 = {};
    test(input9, expected9);

    int[] input10 = {6};
    int[] expected10 = {6};
    test(input10, expected10);

    int[] input11 = {2,2,2,2,2,2,2,2};
    int[] expected11 = {2,2,2,2,2,2,2,2};
    test(input11, expected11);

    int[] input12 = {3,2,4,9,7,1};
    int[] expected12 = {3,2,7,1,4,9};
    test(input12, expected12);

    int[] input13 = {1,9,9,9,9,9,9};
    int[] expected13 = {9,1,9,9,9,9,9};
    test(input13, expected13);
  }
}
