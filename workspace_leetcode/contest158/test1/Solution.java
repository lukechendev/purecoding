/*
5222. Split a String in Balanced Strings
Difficulty:Easy
Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.

 

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
 

Constraints:

1 <= s.length <= 1000
s[i] = 'L' or 'R'
*/

public class Solution {
  
  public int balancedStringSplit(String s) {
    int num = 0;

    int nL = 0;
    int nR = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == 'L') {
        nL++;
      } else if (s.charAt(i) == 'R') {
        nR++;
      }

      if (nL > 0 && nL == nR) {
        num++;
        nL = 0;
        nR = 0;
      }
    }

    return num;
  }

  public static void test(String input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.balancedStringSplit(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("RLRRLLRLRL", 4);
    test("RLLLLRRRLR", 3);
    test("LLLLRRRR", 1);
  }
}
