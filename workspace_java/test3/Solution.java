import java.util.*;

class Solution {
  public static void main(String[] args) {
    int[] a = {3, 2, 100, 33, 0, 1};
    List<Integer> list = new ArrayList<Integer>(a.length);
    System.out.println(list.size());

    for (int i = 0 ; i < a.length; ++i) {
      list.add(a[i]);
    }
    System.out.println(list.size());
    for (int i = 0; i < list.size(); ++i) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();

    Collections.sort(list);
    System.out.println(list.size());
    for (int i = 0; i < list.size(); ++i) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
  }
}
