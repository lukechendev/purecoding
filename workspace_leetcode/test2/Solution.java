/*
String to Integer (atoi)

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
*/

class Solution {
  public int myAtoi(String str) {
    int len = str.length();
    int start = 0;
    int end = len;
    boolean empty = true;
    for (int i = 0; i < len; ++i) {
      char cur = str.charAt(i);

      if (cur == ' ') {
        continue;
      }
      empty = false;

      if (cur == '-' || cur == '+') {
        if (i + 1 >= len) {
          return 0;
        }

        char cur2 = str.charAt(i + 1);
        if (cur2 >= '0' && cur2 <= '9') {
          start = i;
          break;
        } else {
          return 0;
        }
      }

      if (cur >= '0' && cur <= '9') {
        start = i;
        break;
      }

      return 0;
    }

    if (empty) {
      return 0;
    }

    for (int i = start + 1; i < len; ++i) {
      char cur = str.charAt(i);
      if (cur >= '0' && cur <= '9') {
        continue;
      } else {
        end = i;
        break;
      }
    }

    String ret = str.substring(start, end);
    try {
      return Integer.parseInt(ret);
      
    } catch (NumberFormatException e) {
      if (ret.charAt(0) == '-') {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }
  }

  public int myAtoi2(String str) {
    int len = str.length();
    int start = 0;
    int end = len;
    boolean empty = true;
    for (int i = 0; i < len; ++i) {
      char cur = str.charAt(i);

      if (cur == ' ' || cur == '0') {
        continue;
      }
      empty = false;

      if (cur == '-' || cur == '+') {
        if (i + 1 >= len) {
          return 0;
        }

        char cur2 = str.charAt(i + 1);
        if (cur2 >= '0' && cur2 <= '9') {
          start = i;
          break;
        } else {
          return 0;
        }
      }

      if (cur >= '1' && cur <= '9') {
        start = i;
        break;
      }

      return 0;
    }

    if (empty) {
      return 0;
    }

    for (int i = start + 1; i < len; ++i) {
      char cur = str.charAt(i);
      if (cur >= '0' && cur <= '9') {
        if (i > start + 12) {
          if (str.charAt(start) == '-') {
            return Integer.MIN_VALUE;
          } else {
            return Integer.MAX_VALUE;
          }
        }
        continue;
      } else {
        end = i;
        break;
      }
    }

    String ret = str.substring(start, end);
    try {
      return Integer.parseInt(ret);
      
    } catch (NumberFormatException e) {
      if (ret.charAt(0) == '-') {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }
  }

  public int myAtoi3(String str) {
    int len = str.length();
    int start = 0;
    int end = len;

    // Loop until find the first non-space
    boolean empty = true;
    for (start = 0; start < len; ++start) {
      if (str.charAt(start) == ' ') {
        continue;
      } else {
        empty = false;
        break;
      }
    }

    // It may have nothing left after spaces
    if (empty) {
      return 0;
    }

    // Get the optional sign
    int sign = 1;
    char cur = str.charAt(start);
    if (cur == '+' || cur == '-') {
      if (cur == '-') {
        sign = -1;
      }
      start++;
    }

    // Filter out all precedeeding 0s
    empty = true;
    for (;start < len; ++start) {
      cur = str.charAt(start);
      if (cur == '0') {
        continue;
      } else {
        empty = false;
        break;
      }
    }

    // It may have nothing left after 0s
    if (empty) {
      return 0;
    }

    empty = true;
    for (end = start; end < len; ++end) {
      cur = str.charAt(end);
      if (cur >= '0' && cur <= '9') {
        empty = false;

        if (end >= start + 12) {
          break;
        }

        continue;
      } else {
        break;
      }
    }

    // It may have no non-0 numeric numbers after 0s
    if (empty) {
      return 0;
    }

    String ret = str.substring(start, end);
    try {
      return Integer.parseInt(ret) * sign;
      
    } catch (NumberFormatException e) {
      if (sign == -1) {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }
  }

  public int myAtoi4(String str) {
    int res = 0;

    int len = str.length();
    int start = 0;
    int end = len;

    // Loop until find the first non-space
    boolean empty = true;
    for (start = 0; start < len; ++start) {
      if (str.charAt(start) == ' ') {
        continue;
      } else {
        empty = false;
        break;
      }
    }

    // It may have nothing left after spaces
    if (empty) {
      return 0;
    }

    // Get the optional sign
    boolean positive = true;
    char cur = str.charAt(start);
    if (cur == '+' || cur == '-') {
      if (cur == '-') {
        positive = false;
      }
      start++;
    }

    // Filter out all precedeeding 0s
    empty = true;
    for (;start < len; ++start) {
      cur = str.charAt(start);
      if (cur == '0') {
        continue;
      } else {
        empty = false;
        break;
      }
    }

    // It may have nothing left after 0s
    if (empty) {
      return 0;
    }

    for (end = start; end < len; ++end) {
      int num = str.charAt(end) - '0';
      if (num >= 0 && num <= 9) {
        if (!positive) {
          num = -num;

          if (Integer.MIN_VALUE / 10 > res || (Integer.MIN_VALUE - num)/10 > res) {
            return Integer.MIN_VALUE;
          }
          
        } else {
          if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE - num)/10 < res) {
            return Integer.MAX_VALUE;
          }
        }

        res = res * 10 + num;
      } else {
        break;
      }
    }

    return res;
  }

  public int myAtoif(String str) {
    int res = 0;

    int i = 0;
    while(i<str.length() && str.charAt(i)==' '){i++;}
    
    boolean positive = true;
    int j = i;
    while(j<str.length() && str.charAt(j)!=' ') {
	if(j == i && str.charAt(j) == '-') {
	    positive = false;
	    j++;
	    continue;
	} else if(j == i && str.charAt(j) == '+') {
	    j++;
	    continue;
	}
	
	int num = str.charAt(j)-'0';
	if(num >= 0 && num <= 9) {
	    if(!positive) {
		num = -num;

		if(Integer.MIN_VALUE/10 > res || (Integer.MIN_VALUE/100*10 == res/10*10 && num <= Integer.MIN_VALUE%10)) {
		    return Integer.MIN_VALUE;
		}
	    } else {
		if(Integer.MAX_VALUE/10 < res || (Integer.MAX_VALUE/100*10 == res/10*10 && num >= Integer.MAX_VALUE%10)) {
		    return Integer.MAX_VALUE;
		}
	    }
	    
	    res = res*10+num;
	} else {
	    break;
	}
	    
	j++;
    }
    
    return res;
  }

  public static void test(String input, int expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    int ret = s.myAtoi4(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("++2", 0);
    test("+-2", 0);
    test("-+2", 0);
    test("  0000000000012345678", 12345678);
    test("  0000000000012345678", 12345678);
    test("  -0000000000012345678", -12345678);
    test("42", 42);
    test("      -42", -42);
    test("4193 with words", 4193);
    test("words and 987", 0);
    test("   -", 0);
    test("   -++21", 0);
    test("   ", 0);
    test("-----", 0);
    test("+++++", 0);
    test("  - 3 2  ", 0);
    test("  -3 2  ", -3);
    test("  -3  ", -3);
    test("  3  ", 3);
    test("  33232323423423423423423423423423423423434423414134234234234234444444444442333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333322222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222  ", 2147483647);
    test("-91283472332", -2147483648);
    test("-2147483648", -2147483648);
    test("-2147483649", -2147483648);
    test("91283472332", 2147483647);
    test("2147483647", 2147483647);
    test("2147483648", 2147483647);
    test("2147483646", 2147483646);
    test("2147483608", 2147483608);
  }
}
