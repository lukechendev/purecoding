/*
Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/

public class Solution {
  
  public String alienOrder(String[] words) {
    if (words.length == 0) {
      return "";
    }

    String order = "";
    if (words.length == 1) {
      for (int i = 0; i < words[0].length(); ++i) {
        if (order.indexOf(words[0].charAt(i)) == -1) {
          order = order.concat(Character.toString(words[0].charAt(i)));
        }
      }

      return order;
    }
    
    String[] cache = new String[26];
    int i = 0;
    while (i < words.length-1) {
      String first = words[i];
      String second = words[++i];

      // Looking for the first different char
      int j = 0; 
      while (j < second.length() && j < first.length() && second.charAt(j) == first.charAt(j)) {
        j++;
      }

      if (j >= second.length() || j >= first.length()) {
        continue;
      } 

      int i1 = order.indexOf(first.charAt(j));
      int i2 = order.indexOf(second.charAt(j));
      if (i1 != -1 && i2 != -1 && i1 > i2) {
        return ""; // invalid, i1 should be before i2
      }

      if (i1 != -1 && i2 == -1) {
      }
      
      if (i2 == -1) {
        i2 = order.length();
        order = order.concat(Character.toString(second.charAt(j)));
      }
      if (i1 == -1) {
        order = order.substring(0, i2).concat(Character.toString(first.charAt(j))).concat(order.substring(i2));
      } else if (i1 > i2) {
        return ""; // invalid, i1 should be before i2
      }
    }

    return order;
  }

  public static void test(String[] input, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.alienOrder(input);
    // System.out.println(System.nanoTime() - ts);
    if ((ret == null && expected == null) || ret.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Expected:" + expected + " ;Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    String[] input = {"wrt","wrf","er","ett","rftt"};
    test(input, "wertf");

    String[] input2 = {"z","x"};
    test(input2, "zx");

    String[] input3 = {"z","x","z"};
    test(input3, "");

    String[] input4 = {"za","ba","bz"};
    test(input4, "azb");

    String[] input5 = {"za","ba","bz"};
    test(input5, "azb");

    String[] input6 = {"za","bz","ba"};
    test(input6, "zb");
    test(input6, "za");

    String[] input7 = {"bcf","bef","dda","dde","fae","faf"};
    test(input7, "bdcaef");
    test(input7, "bdacef");
    test(input7, "caebdf");

    String[] input8 = {};
    test(input8, "");

    String[] input9 = {"zacazd"};
    test(input9, "zacd");

    String[] input10 = {"bcf","bef","befd","befb","dda"};
    test(input10, "");
  }
}
