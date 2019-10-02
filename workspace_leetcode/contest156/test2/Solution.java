/*
5207. Get Equal Substrings Within Budget
User Accepted:687
User Tried:1159
Total Accepted:691
Total Submissions:1559
Difficulty:Medium
You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.

You are also given an integer maxCost.

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.

If there is no substring from s that can be changed to its corresponding substring from t, return 0.

 

Example 1:

Input: s = "abcd", t = "bcdf", cost = 3
Output: 3
Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
Example 2:

Input: s = "abcd", t = "cdef", cost = 3
Output: 1
Explanation: Each charactor in s costs 2 to change to charactor in t, so the maximum length is 1.
Example 3:

Input: s = "abcd", t = "acde", cost = 0
Output: 1
Explanation: You can't make any change, so the maximum length is 1.
 

Constraints:

1 <= s.length, t.length <= 10^5
0 <= maxCost <= 10^6
s and t only contain lower case English letters.
*/

public class Solution {
  
  public int equalSubstring(String s, String t, int maxCost) {
    if (s.length() == 0) {
      return 0;
    }

    int[] r = new int[s.length()];
    for (int i = 0; i < r.length; ++i) {
      int c = s.charAt(i) - t.charAt(i);
      c = c >= 0 ? c : -c;
      r[i] = c;
    }

    int curMax = -1;
    int curMaxSub = 0;
    for (int i = 0; i < r.length; ++i) {
      int cost = r[i];
      if (cost <= maxCost && curMaxSub <= 1) {
        curMax = cost;
        curMaxSub = 1;
      } else if (cost > maxCost) {
        continue;
      }
      for (int j = i + 1; j < r.length; ++j) {
        cost += r[j];
        if (cost <= maxCost && curMaxSub <= (j - i + 1)) {
          curMax = cost;
          curMaxSub = j - i + 1;
        } else if (cost > maxCost) {
          break;
        }
      }
    }
    return curMaxSub;
  }

  public static void test(String s, String t, int maxCost, int expected) {
    Solution so = new Solution();
    // long ts = System.nanoTime();
    int ret = so.equalSubstring(s, t, maxCost);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("abcd", "bcdf", 3, 3);
    test("abcd", "cdef", 3, 1);
    test("abcd", "acde", 0, 1);
    test("abcd", "ccde", 0, 0);
    test("mhckeerb", "chbrwxeg", 14, 3);
    test("iktqzyazth", "havakbjzzc", 78, 8);
    test("tlslxtfcdjhmknqudilp", "bvydddtftartnntdhyks", 39, 6);
  }
}

