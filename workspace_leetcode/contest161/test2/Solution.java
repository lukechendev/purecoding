/*
5248. Count Number of Nice Subarrays

Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There is no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
*/

public class Solution {
  
  public int numberOfSubarrays(int[] nums, int k) {
    int numSubArrays = 0;
    
    int numOdd = 0;
    
    int iStart = 0;
    int iEnd = 0;
    
    int numOddArr = 0;
    int[] oddArr = new int[k];
    for (int i = 0; i < nums.length; ++i) {
      boolean isOdd = nums[i]%2 != 0;
      if (isOdd) {
        numOdd++;
      }
      
      if (isOdd || i == nums.length - 1) {
        if (numOddArr == k) {
          iEnd = i - 1;
          int nBefore = oddArr[0] - iStart;
          int nAfter = iEnd - oddArr[k-1];
          
          numSubArrays += nBefore + 1 + nAfter + nBefore * nAfter;
          
          iStart = oddArr[0] + 1;
          
          for (int j = 0; j < k-1; ++j) {
            oddArr[j] = oddArr[j+1];
          }
          oddArr[k-1] = i;
          
          if (isOdd && i == nums.length - 1) {
            // The last odd
            nBefore = oddArr[0] - iStart;
            nAfter = iEnd - oddArr[k-1];
            numSubArrays += nBefore + 1 + nAfter + nBefore * nAfter;
          }
        } else {
          oddArr[numOddArr++] = i;
        }
      }
    }
    
    if (numOdd < k) {
      return 0;
    }
    
    return numSubArrays;
  }

  public static void test(String input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.resolve(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("", 0);
  }
}
