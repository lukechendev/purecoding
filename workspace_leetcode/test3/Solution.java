/*
Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
  
  public static Map<String, Integer> romans;
  static {
    romans = new HashMap<String, Integer>();
    romans.put("I", 1);
    romans.put("V", 5);
    romans.put("X", 10);
    romans.put("L", 50);
    romans.put("C", 100);
    romans.put("D", 500);
    romans.put("M", 1000);
    romans.put("IV", 4);
    romans.put("IX", 9);
    romans.put("XL", 40);
    romans.put("XC", 90);
    romans.put("CD", 400);
    romans.put("CM", 900);
  }

  public int romanToInt(String s) {
    if (s == null) {
      return 0;
    }

    int number = 0;

    int n = s.length();
    for (int i = 0; i < n; ++i) {
      if (i < n - 1) {
        String curTwo = s.substring(i, i+2);
        Integer v = romans.get(curTwo);
        if (v != null) {
          number += v.intValue();
          ++i;
          continue;
        }
      }

      String cur = s.substring(i, i+1);
      Integer v = romans.get(cur);
      if (v != null) {
        number += v.intValue();
      } else {
        return 0;
      }
    }

    return number;
  }

  public static int[] romansArr = new int[26];
  static {
    romansArr['I'-'A'] = 1;
    romansArr['V'-'A'] = 5;
    romansArr['X'-'A'] = 10;
    romansArr['L'-'A'] = 50;
    romansArr['C'-'A'] = 100;
    romansArr['D'-'A'] = 500;
    romansArr['M'-'A'] = 1000;
  }

    romans.put("IV", 4);
    romans.put("IX", 9);
    romans.put("XL", 40);
    romans.put("XC", 90);
    romans.put("CD", 400);
    romans.put("CM", 900);

  public int romanToInt2(String s) {
    int number = 0;

    int n;
    if (s == null || (n = s.length()) == 0) {
      return 0;
    }

    char curPre = s.charAt(i-1);
    for (int i = 1; i < n; ++i) {
      char curPre = s.charAt(i-1);
      char cur = s.charAt(i);
      if (curPre == 'I' && curPre == 'V')
    }

    return number;
  }

  public static void test(String input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.romanToInt(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("III", 3);
    test("IV", 4);
    test("IX", 9);
    test("LVIII", 58);
    test("MCMXCIV", 1994);
    test("", 0);
    test(null, 0);
  }
}
