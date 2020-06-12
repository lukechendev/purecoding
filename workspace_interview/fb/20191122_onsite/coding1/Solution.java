/**
1. Given a list of pairs of integers (the list is not sorted), find the overlapping ones and merge them. Return the result list.
For example:
Input:
{{2, 5}, {9, 10}, {4, 7}}
Output:
{{2, 7}, {9, 10}}
**/

import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import javafx.util.Pair;

class Solution {

  private static void printL(List<Pair<Integer, Integer>> l) {
    Iterator<Pair<Integer, Integer>> i = l.iterator();
    System.out.println("");
    System.out.print("{");
    while (i.hasNext()) {
      System.out.print("{");
      Pair<Integer, Integer> p = i.next();
      System.out.print(p.getKey() + ", " + p.getValue());
      System.out.print("}");
    }
    System.out.println("}");
  }

  private static List<Pair<Integer, Integer>> merge(List<Pair<Integer, Integer>> l) {
    List<Pair<Integer, Integer>> ret = new ArrayList<Pair<Integer, Integer>>();

    printL(l);

    // sort the list of pairs
    Collections.sort(l, new Comparator<Pair<Integer, Integer>>() {
      @Override
      public int compare(final Pair<Integer, Integer> p1, final Pair<Integer, Integer> p2) {
        if (p1.getKey() < p2.getKey()) {
          return -1;
        } else if (p1.getKey() == p2.getKey()) {
          return 0;
        } else {
          return 1;
        }
      }
    });

    printL(l);

    return ret;
  }

  public static void main(String[] args) {
    List<Pair<Integer, Integer>> l = new ArrayList<Pair<Integer, Integer>>();
    l.add(new Pair<Integer, Integer>(2, 5));
    l.add(new Pair<Integer, Integer>(9, 10));
    l.add(new Pair<Integer, Integer>(4, 7));
    merge(l);
  }
}
