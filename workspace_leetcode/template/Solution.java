/*
<Problem description>
*/

public class Solution {
  
    public int resolve(String s) {
        return 0;
    }

    public static void test(String input, int expected) {
        Solution s = new Solution();
        // long ts = System.nanoTime();
        int ret = s.resolve(input);
        // System.out.format("%,d" + " ns%n", System.nanoTime() - ts);
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
