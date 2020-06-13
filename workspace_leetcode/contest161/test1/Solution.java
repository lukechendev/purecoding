/*
5247. Minimum Swaps to Make Strings Equal

You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].

Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.

 

Example 1:

Input: s1 = "xx", s2 = "yy"
Output: 1
Explanation: 
Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
Example 2: 

Input: s1 = "xy", s2 = "yx"
Output: 2
Explanation: 
Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
Note that you can't swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap chars in different strings.
Example 3:

Input: s1 = "xx", s2 = "xy"
Output: -1
Example 4:

Input: s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
Output: 4
 

Constraints:

1 <= s1.length, s2.length <= 1000
s1, s2 only contain 'x' or 'y'.
*/

public class Solution {
  
  public int minimumSwap(String s1, String s2) {
    if (s1.equals(s2)) {
      return 0;
    }

    int numY = 0;
    int numXY = 0;
    int numYX = 0;
    for (int i = 0; i < s1.length(); ++i) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      if (c1 == 'y') {
        numY++;
      }
      if (c2 == 'y') {
        numY++;
      }
      
      if (c1 == 'x' && c2 == 'y') {
        numXY++;
      }
      if (c1 == 'y' && c2 == 'x') {
        numYX++;
      }
    }
    
    if (numY%2 != 0) {
      return -1;
    }
    
    int numSwap = 0;
    numSwap += numXY / 2;
    numSwap += numYX / 2;
    
    int rXY = numXY % 2;
    int rYX = numYX % 2;
    if (rXY != rYX) {
      return -1;
    } else {
      numSwap += rXY * 2;
    }
    
    return numSwap;
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
