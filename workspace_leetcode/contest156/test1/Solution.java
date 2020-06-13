/*
<Problem description>
*/

public class Solution {
  
  public boolean uniqueOccurrences(int[] arr) {
    int buckets[] = new int[2100];
    int low = -1000;
    for (int i = 0; i < arr.length; ++i) {
      buckets[arr[i]-low]++;
    }

    int buckets2[] = new int[2100];
    for (int i = 0; i < buckets.length; i++) {
      if (buckets2[buckets[i]] == 0) {
        buckets2[buckets[i]]++;
      } else if (buckets[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void test(int[] input, boolean expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    boolean ret = s.uniqueOccurrences(input);
    // System.out.println(System.nanoTime() - ts);
    if (ret == expected) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + ret);
    }
  }

  public static void main(String[] args) {
    int[] a1 = {1,2,2,1,1,3};
    test(a1, true);

    int[] a2 = {1,2};
    test(a2, false);

    int[] a3 = {-3,0,1,-3,1,1,1,-3,10,0};
    test(a3, true);
  }
}
