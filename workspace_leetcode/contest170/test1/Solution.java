/*
1309. Decrypt String from Alphabet to Integer Mapping

Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.

 

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
Example 3:

Input: s = "25#"
Output: "y"
Example 4:

Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
Output: "abcdefghijklmnopqrstuvwxyz"
 

Constraints:

1 <= s.length <= 1000
s[i] only contains digits letters ('0'-'9') and '#' letter.
s will be valid string such that mapping is always possible.
*/

public class Solution {
  
    private static String CODE = "abcdefghijklmnopqrstuvwxyz";
    
    public String freqAlphabets(String s) {
        StringBuffer ret = new StringBuffer();
        
        int sLen = s.length();
        for (int i = sLen-1; i >= 0; --i) {
            char cur = s.charAt(i);
            
            int index = -1;
            if (cur == '#') {
                String v = s.substring(i-2, i);
                try {
                    index = Integer.valueOf(v) - 1;
                } catch (Exception ex) {
                    // ignore
                }
                
                i = i - 2;
            } else {
                index = cur - '1';
            }
            
            if (index >= 0) {
                ret.insert(0, CODE.charAt(index));
            }
        }
        
        return ret.toString();
    }

    public static void test(String input, int expected) {
        Solution s = new Solution();
        // long ts = System.nanoTime();
        int ret = s.resolve(input);
        // System.out.println(System.nanoTime() - ts);
        System.out.println("Result: \n" + ret);
        if (ret == expected) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed - Expected: \n" + expected);
        }
        System.out.println("=============================================");
    }

    public static void main(String[] args) {
        test("", 0);
    }
}
