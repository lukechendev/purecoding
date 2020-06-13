/*
Make Array Strictly Increasing

Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.

In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].

If there is no way to make arr1 strictly increasing, return -1.

 

Example 1:

Input: arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
Output: 1
Explanation: Replace 5 with 2, then arr1 = [1, 2, 3, 6, 7].
Example 2:

Input: arr1 = [1,5,3,6,7], arr2 = [4,3,1]
Output: 2
Explanation: Replace 5 with 3 and then replace 3 with 4. arr1 = [1, 3, 4, 6, 7].
Example 3:

Input: arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
Output: -1
Explanation: You can't make arr1 strictly increasing.
 

Constraints:

1 <= arr1.length, arr2.length <= 2000
0 <= arr1[i], arr2[i] <= 10^9
*/

class Solution {
  
  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    Arrays.sort(arr2);
    
    int index2 = 0; // index of the arr2
    for (int i = 0; i < arr1.length; ++i) {
      if (arr1[i] > arr1[i+1] ) {
        for (int j = index2; j < arr2.length; ++j) {
          if (arr2[j] <= arr1[i+1]) {
            arr1[i] = arr2[j];
            index2 = j;
            break;
          }
        }
      } else if ()
    }
  }

  public static void test(int[] arr1, int[] arr2, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.makeArrayIncreasing(arr1, arr2);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    int[] arr1 =
    test("", 0);
  }
}
