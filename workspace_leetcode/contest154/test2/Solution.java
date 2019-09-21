/*
5190. Reverse Substrings Between Each Pair of Parentheses

Given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any bracket.

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 

Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
*/

class Solution {
  
  public String reverseParentheses(String s) {
    StringBuffer ret = new StringBuffer();

    int len = s.length();

    int sleft = 0;
    int[] ileft = new int[len];
    int sright = 0;
    int[] iright = new int[len];

    for (int i = 0; i < len; ++i) {
      if (s.charAt(i) == '(') {
        ileft[sleft++] = i;
      } else if (s.charAt(i) == ')') {
        iright[sright++] = i;
      }
    }

    // Here we assume sleft always equals sright

    if (sleft == 0 || sright == 0) {
      return s;
    }

    int i = sleft - 1;
    int j = 0;

    if ((i + 1) % 2 == 0) {
      int start = ileft[i] + 1;
      int end = iright[j];
      if (start < end) {
        ret.append(s.substring(start, end));
      }
    } else {
      int start = iright[j] - 1;
      int end = ileft[i];
      for (int k = start; k > end; --k) {
        ret.append(s.charAt(k));
      }
    }

    --i;
    ++j;
    while (i >= 0 && j < sright) {
      if ((i + 1) % 2 == 0) {
        // No need to reverse
        int start = ileft[i] + 1;
        int end = ileft[i+1];
        if (start < end) {
          ret.insert(0, s.substring(start, end));
        }
        
        start = iright[j-1] + 1;
        end = iright[j];
        if (start < end) {
          ret.append(s.substring(start, end));
        }
      } else {
        // Need to reverse
        int start = iright[j-1] + 1;
        int end = iright[j];
        for (int k = start; k < end; ++k) {
          ret.insert(0, s.charAt(k));
        }

        start = ileft[i+1] - 1;
        end = ileft[i];
        for (int k = start; k > end; --k) {
          ret.append(s.charAt(k));
        }
      }

      --i;
      ++j;
    }

    int start = 0;
    int end = ileft[0];
    if (start < end) {
      ret.insert(0, s.substring(start, end));
    }

    start = iright[sright-1] + 1;
    end = len;
    if (start < end) {
      ret.append(s.substring(start, end));
    }

    return ret.toString();
  }

  public static void test(String input, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.reverseParentheses(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("(abcd)", "dcba");
    test("()", "");
    test("", "");
    test("abcd", "abcd");
    test("(u(love)i)", "iloveu");
    test("(ed(et(oc))el)", "leetcode");
    test("a(bcdefghijkl(mno)p)q", "apmnolkjihgfedcbq");
    test("ta()usw((((a))))", "tauswa");
  }
}
