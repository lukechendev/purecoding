/*
1209. Remove All Adjacent Duplicates in String II
User Accepted:2168
User Tried:2530
Total Accepted:2201
Total Submissions:3922
Difficulty:Medium
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
*/

public class Solution {

  public String removeDuplicatesSample(String s, int k) {
    char[] arr = s.toCharArray();
    int i = -1, j = 0;
    while (j < arr.length) {
      if (i == -1 || arr[j] != arr[i]) {
        arr[++i] = arr[j++];
      } else {
	// arr[i] == arr[j]
	char tmp = arr[i];
	int cnt1 = 0, cnt2 = 0;
	while (j < arr.length && arr[j] == tmp) {
	  cnt1++;
	  j++;
	}
	while (i >= 0 && arr[i] == tmp) {
	  cnt2++;
	  i--;
	}
	for (int ii = 0; ii < (cnt1 + cnt2) % k; ii++) {
	  arr[++i] = tmp;
	}
      }
    }

    return new String(arr, 0, i + 1);
  }

  public String removeDuplicates(String s, int k) {
    while (true) {
      boolean hasDup = false;
      StringBuffer buf = new StringBuffer(); 

      int t = 0;
      char c = 0;
      for (int i = 0; i < s.length(); ++i) {
        if (c == 0) {
          c = s.charAt(i);
          t = 1;
          continue;
        }

        if (c != s.charAt(i)) {
          for (int j = 0; j < t; ++j) {
            buf.append(c);
          }
          c = s.charAt(i);
          t = 1;
          continue;
        }

        t++;

        if (t == k) {
          hasDup = true;
          c = 0;
        }
      }

      if (c != 0) {
        for (int j = 0; j < t; ++j) {
          buf.append(c);
        }
      }

      s = buf.toString();

      if (!hasDup) {
        break;
      }
    }

    return s;
  }

  public static void test(String s, int k, String expected) {
    Solution r = new Solution();
    // long ts = System.nanoTime();
    String ret = r.removeDuplicates(s, k);
    // System.out.println(System.nanoTime() - ts);
    if ((ret == null && expected == null) || ret.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("a", 2, "a");
    test("aabcd", 2, "bcd");
    test("abcd", 2, "abcd");
    test("deeedbbcccbdaa", 3, "aa");
    test("pbbcggttciiippooaais", 2, "ps");
  }
}
