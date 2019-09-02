/*
Longest Substring Without Repeating Characters
Solution
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        String maxSubString = "";
        for (int i = 0; i < s.length(); ++i) {
            StringBuffer curStr = new StringBuffer();
            for (int j = i; j < s.length(); ++j ) {
                String c = Character.toString(s.charAt(j));
                if (curStr.indexOf(c) == -1) {
                    curStr.append(s.charAt(j));
                } else {
                    break;
                }
            }
            if (curStr.toString().length() > maxSubString.length()) {
                maxSubString = curStr.toString();
            }
        }
        
        return maxSubString.length();
    }

    public int lengthOfLongestSubstring2(String s) {
      if (s == null || s.length() == 0) {
        return 0;
      } else if (s.length() == 1) {
        return 1;
      }

      int max = 1;
      int curLen = 0;
      int i = 0;
      int j = 1;
      while (j < s.length()) {
        String sub = s.substring(i, j);
        int d = sub.indexOf(s.charAt(j));
        if (d == -1) {
          j++;
        } else {
          curLen = j - i;
          max = max < curLen ? curLen : max;
          i = i + d + 1;
          j++;
        }
      }
      curLen = j - i;
      max = max < curLen ? curLen : max;

      return max;
    }

    public int lengthOfLongestSubstring3(String s) {
      if (s == null) {
        return 0;
      }

      int i = 0;
      int j = 0;
      int max = 0;
      int n = s.length();
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      while (j < n) {
        Integer index = map.get(s.charAt(j));
        if (index != null) {
          max = Math.max(max, j - i);
          for (int m = i; m <= index.intValue(); ++m) {
            map.remove(s.charAt(m));
          }
          i = index.intValue() + 1;
        }
        map.put(s.charAt(j), j);
        ++j;
      }
      max = Math.max(max, j - i);

      return max;
    }

    public int lengthOfLongestSubstring4(String s) {
      if (s == null) {
        return 0;
      }

      int[] ascii = new int[128];
      int n = s.length(), max = 0;
      for (int i = 0, j = 0; j < n; ++j) {
        i = Math.max(ascii[s.charAt(j)], i);
        max = Math.max(max, j - i + 1);
        ascii[s.charAt(j)] = j + 1;
      }

      return max;
    }

    public static void test1() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("abcabcbb");
      if (ret == 3) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test2() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("bbbbb");
      if (ret == 1) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test3() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("pwwkew");
      if (ret == 3) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test4() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("au");
      if (ret == 2) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test5() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("");
      if (ret == 0) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test6() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4(null);
      if (ret == 0) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test7() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("w");
      if (ret == 1) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test8() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("aaaaaaaaaaaaabbbbbbbbbbbbccccccccccccddddddddddd");
      if (ret == 2) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void test9() {
      Solution s = new Solution();
      int ret = s.lengthOfLongestSubstring4("abcadefa");
      if (ret == 6) {
        System.out.println("Passed");
      } else {
        System.out.println("Failed: " + ret);
      }
    }

    public static void main(String[] args) {
      test1();
      test2();
      test3();
      test4();
      test5();
      test6();
      test7();
      test8();
      test9();
    }
}
