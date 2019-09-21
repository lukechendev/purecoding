/*
5189. Maximum Number of Balloons

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.
*/

class Solution {
  
  public int maxNumberOfBalloons(String text) {
    int len = text.length();

    if (len < 7) {
      return 0;
    }

    // Buckets for b, a, l, o, n
    int[] buckets = new int[5];

    for (int i = 0; i < len; ++i) {
      char c = text.charAt(i);
      if (c == 'b') {
        buckets[0]++;
      } else if (c == 'a') {
        buckets[1]++;
      } else if (c == 'l') {
        buckets[2]++;
      } else if (c == 'o') {
        buckets[3]++;
      } else if (c == 'n') {
        buckets[4]++;
      }
    }

    // calculate 'b'
    int min = buckets[0];

    // calculate 'a'
    if (buckets[1] < min) {
      min = buckets[1];
    }

    // calculate 'l'
    if (buckets[2] < min * 2) {
      min = buckets[2] / 2;
    }

    // calculate 'o'
    if (buckets[3] < min * 2) {
      min = buckets[3] / 2;
    }

    // calculate 'n'
    if (buckets[4] < min) {
      min = buckets[4];
    }

    return min;
  }

  public static void test(String input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.maxNumberOfBalloons(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("nlaebolko", 1);
    test("loonbalxballpoon", 2);
    test("leetcode", 0);
  }
}
