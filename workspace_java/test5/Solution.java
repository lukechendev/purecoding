/*
Find pairs in an array that matches the given sum
*/

import javafx.util.Pair;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {

  private static String printList(List<Pair<Integer, Integer>> l) {
    StringBuffer buff = new StringBuffer();

    buff.append("[");
    Iterator<Pair<Integer, Integer>> i = l.iterator();
    while (i.hasNext()) {
      Pair p = i.next();
      buff.append("(" + p.getKey() + "," + p.getValue() + "),");
    }
    buff.deleteCharAt(buff.length() - 1);
    buff.append("]");

    return buff.toString();
  }
  
  public List<Pair<Integer, Integer>> findInSorted(int[] a, int sum) {
    List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();

    int lo = 0;
    int hi = a.length - 1;

    while (lo < hi) {
      int s = a[lo] + a[hi];

      if (s == sum) {
        list.add(new Pair<Integer, Integer>(a[lo], a[hi]));
        lo++;
        hi--;
        continue;
      }

      if (s < sum) {
        lo++;
      } else {
        hi--;
      }
    }

    return list;
  }

  public static void testSorted(int[] a, int sum, List<Pair<Integer, Integer>> expected) {
    Solution s = new Solution();
    // long ts = System.nanoTime();
    List<Pair<Integer, Integer>> ret = s.findInSorted(a, sum);
    // System.out.println(System.nanoTime() - ts);

    String retStr = printList(ret);
    String expStr = printList(expected);
    if (retStr.equals(expStr)) {
      System.out.println("Passed");
    } else {
      System.out.println("Failed: " + retStr + "\n Expected: " + expStr);
    }
  }

  public static void main(String[] args) {
    int[] a = {-1, 2, 3, 4, 4, 5, 8, 9};
    List<Pair<Integer, Integer>> exp = new ArrayList<Pair<Integer, Integer>>();
    exp.add(new Pair<Integer, Integer>(-1, 9));
    exp.add(new Pair<Integer, Integer>(3, 5));
    exp.add(new Pair<Integer, Integer>(4, 4));
    testSorted(a, 8, exp);
  }
}
