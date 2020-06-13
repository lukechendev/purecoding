/*
Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
  
  public String multiplySample1(String num1, String num2) {
    int m=num1.length(), n=num2.length(), zero=0;
    int[] a = new int[m], c = new int[m+n];
    for(int i=0,k=m; i<m; i++) a[--k]=num1.charAt(i)-'0';  // reverse the first number
    for(int i=n-1; i>=0; i--)
	add(c,a,num2.charAt(i)-'0',zero++);    // multiply each digits of num2 to num1
    carry(c);            // handle all carry operation together
    int i=m+n;
    while(i>0 && c[--i]==0);  // find the highest digit
    i++;
    StringBuilder ret = new StringBuilder(i);
    while(i>0) ret.append((char)(c[--i]+'0'));
    return ret.toString();
  }
  void carry(int[] a){
    int i;
    for(int k=0,d=0; k<a.length; k++){
      i=a[k]+d;
      a[k]=i%10;
      d=i/10;
    }
  }
  void add(int[] c, int[] a, int b, int zero){
    for(int i=zero,j=0; j<a.length; j++,i++) {
      c[i]+=a[j]*b;
    }
  }


  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();

    StringBuffer ret = new StringBuffer();
    for (int i = len2 - 1; i >= 0; --i) {
      int m = ret.length() - 1 - (len2 - i - 1);

      // The number from the previous digit multiplication
      int l = 0;
      // The number from the previous digit addition
      int p = 0;
      for (int j = len1 - 1; j >= 0; --j) {
        int r = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + l;
        l = r/10;

        if (m >= 0) {
          int q = (ret.charAt(m) - '0') + r%10 + p;
          p = q/10;
          ret.setCharAt(m, (char) (q%10 + '0'));
        } else {
          int s = r%10 + p;
          p = s/10;
          ret.insert(0, (char) (s%10 + '0'));
        }
        m--;
      }
      if (l != 0 || p != 0) {
        int f = l + p;
        int last = f/10;
        ret.insert(0, (char) (f%10 + '0'));
        if (last > 0) {
          ret.insert(0, (char) (last%10 + '0'));
        }
      }

    }

    boolean zero = true;
    for (int i = ret.length() - 1; i >= 0; --i) {
      if (ret.charAt(i) != '0') {
        zero = false;
        break;
      }
    }
    if (zero) {
      return "0";
    }

    return ret.toString();
  }

  public static void test(String input, String input2, String expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    String ret = s.multiplySample1(input, input2);
    // System.out.println(System.nanoTime() - ts);
    if (ret.equals(expected)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    test("381", "292", "111252");
    test("2", "3", "6");
    test("123", "456", "56088");
    test("0", "33333", "0");
    test("33333", "0", "0");
    test("33333", "1", "33333");
    test("1", "33333", "33333");
  }
}
